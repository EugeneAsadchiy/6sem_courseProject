package com.shop.ShoesShop.controllers;

import com.shop.ShoesShop.Services.*;
import com.shop.ShoesShop.models.*;
import com.shop.ShoesShop.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller
public class OrdersController {

    @Autowired
    private ProductsRepository productsRepository;
    private final ProductsService productsService;
    @Autowired
    private UsersRepository usersRepository;
    private final UsersService usersService;
    @Autowired
    private OrdersRepository ordersRepository;
    private final OrdersService ordersService;
    @Autowired
    private ImagesRepository imagesRepository;
    private final ImagesService imagesService;
    @Autowired
    private ConfirmedOrdersRepository confirmedOrdersRepository;
    private final ConfirmedOrdersService confirmedOrdersService;

    public OrdersController(ProductsService productsService, UsersService usersService, OrdersService ordersService, ImagesService imagesService, ConfirmedOrdersService confirmedOrdersService) {
        this.productsService = productsService;
        this.usersService = usersService;
        this.ordersService = ordersService;
        this.imagesService = imagesService;
        this.confirmedOrdersService = confirmedOrdersService;
    }

    @GetMapping("/orders")
    public String Orders(Model model) {
        Users users = usersRepository.findByUserLogin(Users.profile);
        int full_price=0;

        List<Orders> order = ordersService.getOrdersByIdUsers(users.getId_users());
        for (Orders or : order) {
            full_price = full_price + or.getCost();
        }
        System.out.println(order);

        model.addAttribute("orders", order);
        model.addAttribute("fullprice", full_price);

        model.addAttribute("session", Users.session);
        model.addAttribute("profile", Users.profile);
        return "orders";
    }
    @PostMapping("/accept_order")
    public String orders_accept(Model model){
        Users users = usersRepository.findByUserLogin(Users.profile);
        List<Orders> order = ordersService.getOrdersByIdUsers(users.getId_users());
        for(Orders ord : order)
        {
            confirmedOrdersService.saveOrders(ord);
            ordersRepository.delete(ord);
        }
        return "redirect:/home";
    }

    @PostMapping("/products/{id_products}/order")
    public String order_products(@PathVariable Long id_products, @RequestParam(name = "size") String size, Model model) {
        Products products = productsRepository.findById(id_products).orElseThrow();
        System.out.println(size);
        Users users = usersRepository.findByUserLogin(Users.profile);
//        Images images = imagesRepository.findById(products.getPreviewImageId());
        Images images = imagesService.getUrl(products.getPreviewImageId());
        ordersService.saveOrders(products, images.getUrlImages(), size, users.getId_users());
        return "redirect:/products/{id_products}";
    }

    @PostMapping("/orders/{nameProducts}/remove")
    public String remove_order(@PathVariable String nameProducts, Model model) {
        Orders orders = ordersService.findByNameOrders(nameProducts);
        ordersRepository.delete(orders);
        return "redirect:/orders";
    }
    @GetMapping("/confirmed_orders")
    public String confirmed_orders(Model model) {
        if (Users.session == 1)
        {
            Iterable<ConfirmedOrders> confirmedOrders = confirmedOrdersRepository.findAll();
            model.addAttribute("confirmedOrders", confirmedOrders);

        }
        else {
            Users users = usersRepository.findByUserLogin(Users.profile);
            List<ConfirmedOrders> confirmedOrders = confirmedOrdersService.getOrdersByIdUsers(users.getId_users());
            model.addAttribute("confirmedOrders", confirmedOrders);
        }

        model.addAttribute("session", Users.session);
        model.addAttribute("profile", Users.profile);
//        model.addAttribute("images", product.)
        return "confirmed_orders";
    }
}
