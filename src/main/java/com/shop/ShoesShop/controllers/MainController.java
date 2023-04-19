package com.shop.ShoesShop.controllers;


import com.shop.ShoesShop.models.Users;
import com.shop.ShoesShop.repository.ProductsRepository;
import com.shop.ShoesShop.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @Autowired
    private UsersRepository usersRepository;
    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("title", "Главная страница!");
        return "home";
    }
    @GetMapping("/authorization")
    public String authorization(Model model) {
        model.addAttribute("title", "Главная страница!");
        return "authorization";
    }
    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("title", "Главная страница!");
        return "registration";
    }
    @PostMapping("/registration")
    public String save_new_users(@RequestParam String user_login, @RequestParam String user_password, Model model) {
        Users users = new Users(user_login, user_password);
        usersRepository.save(users);
        return "redirect:/home";
    }
//    @PostMapping("/sign_in")
//    public String save_new_products(@RequestParam String name_products, @RequestParam String season,
//                                    @RequestParam String amount, @RequestParam String cost, @RequestParam String gender
//            , Model model) {
//        Products products = new Products(name_products, season, amount, cost, gender);
//        productsRepository.save(products);
//        return "redirect:/home";
//    }


}