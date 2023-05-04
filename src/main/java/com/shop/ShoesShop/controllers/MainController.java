package com.shop.ShoesShop.controllers;


import com.shop.ShoesShop.Services.ProductsService;
import com.shop.ShoesShop.Services.UsersService;
import com.shop.ShoesShop.models.Products;
import com.shop.ShoesShop.models.Users;
import com.shop.ShoesShop.repository.ProductsRepository;
import com.shop.ShoesShop.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Controller
public class MainController {

    @Autowired
    private UsersRepository usersRepository;
    private final UsersService usersService;
    @Autowired
    private ProductsRepository productsRepository;
    private final ProductsService productsService;

    public MainController(UsersService usersService, ProductsService productsService) {
        this.usersService = usersService;
        this.productsService = productsService;
    }

    @GetMapping("/home")
    public String Products(@RequestParam(value = "searchName", required = false) String searchName,
                           @RequestParam(name = "products_name", required = false, defaultValue = "") String products_name,
                           @RequestParam(name = "min_price", required = false, defaultValue = "0") String min_price,
                           @RequestParam(name = "max_price", required = false, defaultValue = "99999") String max_price,
                           @RequestParam(name = "gender", required = false, defaultValue = "") String gender,
                           @RequestParam(name = "season", required = false, defaultValue = "") String season,
                           @RequestParam(name = "sort_by_price", required = false, defaultValue = "") String sort_by_price,
                           Model model)
    {
        if (!products_name.equals("") && !min_price.equals("0") && !max_price.equals("99999") && gender.equals("") && season.equals(""))
        {
            System.out.println(products_name+ min_price + max_price+gender+season);
            model.addAttribute("products", productsService.sortProductsNamePrice(products_name, min_price, max_price));

        }
        else if(min_price.equals("0") && max_price.equals("99999") && !sort_by_price.equals("")){
            model.addAttribute("products", productsService.sortASCandDESC(min_price,max_price,sort_by_price));
        }
        else if (!products_name.equals("") && !min_price.equals("0") && !max_price.equals("99999") && !gender.equals("") && !season.equals(""))
        {
            System.out.println(products_name+ min_price + max_price+gender+season);
            model.addAttribute("products", productsService.sortProducts(products_name, min_price, max_price, gender, season));

        }
        else if (!min_price.equals("0") && !max_price.equals("99999") && gender.equals("") && season.equals("") ) {

            model.addAttribute("products", productsService.sortProductsbyPrice(min_price, max_price));

        }
        else if (!min_price.equals("0") && !max_price.equals("99999") && !gender.equals("") && !season.equals("") ) {

            model.addAttribute("products", productsService.sortProductsbyPriceAndGenderAndSeason(min_price, max_price, gender,season));

        }
//        else if (!sort_by_price.equals("")) {
//
//            model.addAttribute("products", productsService.sortProductsByDESCAndASC(sort_by_price));
//
//        }
        else{
            List<Products> product = productsService.getProductByName(searchName);
            model.addAttribute("products", product);
        }
        model.addAttribute("session", Users.session);
        model.addAttribute("profile", Users.profile);
        return "home";
    }

    @GetMapping("/authorization")
    public String authorization(Model model) {
        model.addAttribute("title", "Главная страница!");
        return "authorization";
    }

    @PostMapping("/authorization")
    public String authorization(@RequestParam String userLogin, @RequestParam String userPassword, Model model) throws IOException {
        boolean check = usersService.enterUsers(userLogin, userPassword);
        if (check)
        {
            Users.profile=userLogin;
            return "redirect:/home";
        }
        else {
            return "redirect:/authorization";
        }
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("title", "Главная страница!");
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(Users users, Model model) throws IOException {
        boolean check = usersService.registrationUsers(users.getUserLogin(), users.getUserPassword());
        if (check)
        {
            return "redirect:/registration";
        }
        else {
            usersService.saveUsers(users);
            Users.profile=users.getUserLogin();
            return "redirect:/home";
        }
    }




}