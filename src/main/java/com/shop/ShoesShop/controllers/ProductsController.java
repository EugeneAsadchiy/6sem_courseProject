package com.shop.ShoesShop.controllers;

import com.shop.ShoesShop.Services.OrdersService;
import com.shop.ShoesShop.Services.ProductsService;
import com.shop.ShoesShop.Services.UsersService;
import com.shop.ShoesShop.models.Products;

import com.shop.ShoesShop.models.Users;
import com.shop.ShoesShop.repository.OrdersRepository;
import com.shop.ShoesShop.repository.ProductsRepository;
import com.shop.ShoesShop.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;

@Controller
public class ProductsController {
    @Autowired
    private ProductsRepository productsRepository;
    private final ProductsService productsService;
    @Autowired
    private UsersRepository usersRepository;
    private final UsersService usersService;
    @Autowired
    private OrdersRepository ordersRepository;
    private final OrdersService ordersService;
    public ProductsController(ProductsService productsService, UsersService usersService, OrdersService ordersService) {
        this.productsService = productsService;
        this.usersService = usersService;
        this.ordersService = ordersService;
    }

    @GetMapping("/products")
    public String Products(Model model) {
        Iterable<Products> product = productsRepository.findAll();

        model.addAttribute("products", product);
        model.addAttribute("session", Users.session);
        model.addAttribute("profile", Users.profile);
//        model.addAttribute("images", product.)
        return "products";
    }


    @GetMapping("/add_products")
    public String add_products(Model model) {
        model.addAttribute("session", Users.session);
        model.addAttribute("profile", Users.profile);
        return "products_add";
    }

    @PostMapping("/add_products")
    public String save_new_products(Products products, @RequestParam("file1") MultipartFile file1,
                                    @RequestParam("file2") MultipartFile file2, @RequestParam("file3") MultipartFile file3) throws IOException {

        productsService.saveProducts(products, file1, file2, file3);
        return "redirect:/home";
    }

    @GetMapping("/products/{id_products}")
    public String productsDetails(@PathVariable Long id_products, Model model) {
        if (!productsRepository.existsById(id_products)) {
            return "redirect:/home";
        }
        Products products = productsService.getProductById(id_products);
        model.addAttribute("products", products);
        model.addAttribute("images", products.getImage());
        model.addAttribute("session", Users.session);
        model.addAttribute("profile", Users.profile);

        return "products_details";
    }

    @GetMapping("/products/{id_products}/edit")
    public String productsEdit(@PathVariable Long id_products, Model model) {
        if (!productsRepository.existsById(id_products)) {
            return "redirect:/home";
        }
        Products products = productsService.getProductById(id_products);

        model.addAttribute("products", products);
        model.addAttribute("images", products.getImage());
        model.addAttribute("session", Users.session);
        model.addAttribute("profile", Users.profile);
        return "products_edit";
    }

    @PostMapping("/products/{id_products}/edit")
    public String save_edit_products(@PathVariable(name = "id_products") Long id_products, Products products, @RequestParam("file1") MultipartFile file1,
                                     @RequestParam("file2") MultipartFile file2, @RequestParam("file3") MultipartFile file3, Model model) throws IOException {

        products.setId_products(id_products);
//        productsRepository.save(products);
        LocalDateTime dataOfCreated;
        dataOfCreated= LocalDateTime.now();
//        products.setPreviewImageId();
        products.setDataOfCreated(dataOfCreated);
        productsService.saveProducts(products, file1, file2, file3);

        return "redirect:/products";
    }

    @PostMapping("/products/{id_products}/remove")
    public String save_remove_products(@PathVariable Long id_products, Model model) {
        Products products = productsRepository.findById(id_products).orElseThrow();
        productsRepository.delete(products);

        return "redirect:/products";
    }
    @PostMapping("/products/{id_products}/order")
    public String order_products(@PathVariable Long id_products, Model model) {
        Products products = productsRepository.findById(id_products).orElseThrow();

        Users users= usersRepository.findByUserLogin(Users.profile);
        ordersService.saveOrders(products, users.getId_users());
        return "redirect:/products/{id_products}";
    }


}
