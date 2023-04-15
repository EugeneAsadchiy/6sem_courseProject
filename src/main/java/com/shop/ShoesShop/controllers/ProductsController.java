package com.shop.ShoesShop.controllers;

import com.shop.ShoesShop.models.Products;

import com.shop.ShoesShop.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

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
        return "products_add";
    }

    @PostMapping("/add_products")
    public String save_new_products(@RequestParam String name_products, @RequestParam String season,
                                    @RequestParam String amount, @RequestParam String cost, @RequestParam String gender
            , Model model) {
        Products products = new Products(name_products, season, amount, cost, gender);
        productsRepository.save(products);
        return "redirect:/home";
    }

    @GetMapping("/products/{id_products}")
    public String productsDetails(@PathVariable(value = "id_products") long id_products, Model model) {
        if(!productsRepository.existsById(id_products)){
            return "redirect:/home";
        }
//        Products product = productsRepository.findById(id_products);
        Optional<Products> products = productsRepository.findById(id_products);
        ArrayList<Products> prod = new ArrayList<>();
        products.ifPresent(prod::add);
        model.addAttribute("products", prod);

        return "products_details";
    }

    @GetMapping("/products/{id_products}/edit")
    public String productsEdit(@PathVariable(value = "id_products") long id_products, Model model) {
        if (!productsRepository.existsById(id_products)) {
            return "redirect:/home";
        }
        Optional<Products> products = productsRepository.findById(id_products);
        ArrayList<Products> prod = new ArrayList<>();
        products.ifPresent(prod::add);
        model.addAttribute("products", prod);

        return "products_edit";
    }
    @PostMapping("/products/{id_products}/edit")
    public String save_edit_products(@PathVariable(value = "id_products") long id_products, @RequestParam String name_products,
                                     @RequestParam String season, @RequestParam String amount, @RequestParam String cost,
                                     @RequestParam String gender, Model model) {
        Products products = productsRepository.findById(id_products).orElseThrow();
        products.setName_products(name_products);
        products.setSeason(season);
        products.setAmount(amount);
        products.setCost(cost);
        products.setGender(gender);
        productsRepository.save(products);

        return "redirect:/products";
    }

    @PostMapping("/products/{id_products}/remove")
    public String save_remove_products(@PathVariable(value = "id_products") long id_products, Model model) {
        Products products = productsRepository.findById(id_products).orElseThrow();
        productsRepository.delete(products);

        return "redirect:/products";
    }


}
