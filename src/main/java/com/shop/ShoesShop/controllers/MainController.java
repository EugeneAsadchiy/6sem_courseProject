package com.shop.ShoesShop.controllers;


import com.shop.ShoesShop.Services.UsersService;
import com.shop.ShoesShop.models.Products;
import com.shop.ShoesShop.models.Users;
import com.shop.ShoesShop.repository.ProductsRepository;
import com.shop.ShoesShop.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class MainController {

    @Autowired
    private UsersRepository usersRepository;
    private final UsersService usersService;
    @Autowired
    private ProductsRepository productsRepository;

    public MainController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/home")
    public String Products(Model model) {
        Iterable<Products> product = productsRepository.findAll();
        model.addAttribute("products", product);
//        model.addAttribute("images", product.)
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
            return "redirect:/home";
        }
    }




}