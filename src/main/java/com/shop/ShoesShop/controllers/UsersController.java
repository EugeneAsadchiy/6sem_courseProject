package com.shop.ShoesShop.controllers;

import com.shop.ShoesShop.Services.UsersService;
import com.shop.ShoesShop.models.Users;
import com.shop.ShoesShop.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;
    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/customers")
    public String Products(Model model) {
        Iterable<Users> users = usersRepository.findAll();

        model.addAttribute("users", users);
        model.addAttribute("session", Users.session);
        model.addAttribute("profile", Users.profile);
//        model.addAttribute("images", product.)
        return "customers";
    }

}
