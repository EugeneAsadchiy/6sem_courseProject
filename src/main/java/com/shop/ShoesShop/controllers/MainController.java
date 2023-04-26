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
    public String Products(@RequestParam(value = "searchName", required = false) String searchName, Model model) {
//        Iterable<Products> product = productsRepository.findAll();
        List<Products> product = productsService.getProductByName(searchName);
        model.addAttribute("products", product);
//        List<Products> products = productsService.getProductByName(searchName);

//        model.addAttribute("images", product.)
        model.addAttribute("session", Users.session);
        model.addAttribute("profile", Users.profile);
        return "home";
    }
//    @PostMapping("/home")
//    public String SearchProducts(Model model, @RequestParam("") ) {
//        Iterable<Products> product = productsRepository.findAll();
//        model.addAttribute("products", product);
////        model.addAttribute("images", product.)
//        model.addAttribute("session", Users.session);
//        model.addAttribute("profile", Users.profile);
//        return "home";
//    }
//    @RequestMapping(value = "/search", method = RequestMethod.POST)
//    public String search(Model model, @RequestParam("searchName") String name){
//        System.out.println(name);
//        List<Products> products = productsService.getProductByName(name);
//        model.addAttribute("searchName", products);
//        model.addAttribute("products", products);
//        System.out.println(products);
//        model.addAttribute("session", Users.session);
//        model.addAttribute("profile", Users.profile);
//        return "home";
//    }

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