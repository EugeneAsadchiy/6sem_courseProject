package com.shop.ShoesShop.controllers;

import com.shop.ShoesShop.models.Products;

import com.shop.ShoesShop.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductsController {
    @Autowired
    private ProductsRepository productsRepository;


    @GetMapping("/products")
    public String Products(Model model) {
        Iterable<Products> products = productsRepository.findAll();
        model.addAttribute("products", products);

        return "products";
    }
    @GetMapping("/add_products")
    public String add_products(Model model) {
        return "add_products";
    }
    @PostMapping("/add_products")
    public String save_new_products(@RequestParam String name_products, @RequestParam String season,
                                    @RequestParam String amount, @RequestParam String cost, @RequestParam String gender
            , Model model)
    {
        Products products=new Products(name_products,season,amount,cost,gender);
        productsRepository.save(products);
        return "redirect:/home";
    }

}
