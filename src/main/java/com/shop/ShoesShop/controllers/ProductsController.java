package com.shop.ShoesShop.controllers;

//import com.shop.ShoesShop.models.users;
//import com.shop.ShoesShop.repository.usersRepository;
//import org.hibernate.event.spi.PostCollectionRecreateEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductsController {
//    @Autowired
//    private usersRepository usersRepository;


    @GetMapping("/products")
    public String products(Model model) {
//        Iterable<users> users=usersRepository.findAll();
//        model.addAttribute("users", users);
        model.addAttribute("title", "Продукция!");
        return "products";
    }

}
