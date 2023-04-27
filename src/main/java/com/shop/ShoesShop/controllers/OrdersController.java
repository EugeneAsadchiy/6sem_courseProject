package com.shop.ShoesShop.controllers;

import com.shop.ShoesShop.Services.ImagesService;
import com.shop.ShoesShop.Services.OrdersService;
import com.shop.ShoesShop.Services.ProductsService;
import com.shop.ShoesShop.Services.UsersService;
import com.shop.ShoesShop.models.Images;
import com.shop.ShoesShop.models.Orders;
import com.shop.ShoesShop.models.Products;
import com.shop.ShoesShop.models.Users;
import com.shop.ShoesShop.repository.ImagesRepository;
import com.shop.ShoesShop.repository.OrdersRepository;
import com.shop.ShoesShop.repository.ProductsRepository;
import com.shop.ShoesShop.repository.UsersRepository;
import org.aspectj.weaver.ast.Or;
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

    public OrdersController(ProductsService productsService, UsersService usersService, OrdersService ordersService, ImagesService imagesService) {
        this.productsService = productsService;
        this.usersService = usersService;
        this.ordersService = ordersService;
        this.imagesService = imagesService;
    }

    @GetMapping("/orders")
    public String Orders(Model model) {
        Users users = usersRepository.findByUserLogin(Users.profile);
        int full_price=0;

        List<Orders> order = ordersService.getOrdersByIdUsers(users.getId_users());
//        System.out.println();

//        Orders first=order.get(1);

//        System.out.println(first);
        for (Orders or : order) {
            full_price = full_price + Integer.parseInt(or.getCost());
        }
        System.out.println(order);
//        Iterable<Products> product = productsRepository.findAll();
//        Images images = imagesRepository.findByOrdersIdProducts()
//        model.addAttribute("products", product);
        model.addAttribute("orders", order);
        model.addAttribute("fullprice", full_price);
//        model.addAttribute("images", product.)
        model.addAttribute("session", Users.session);
        model.addAttribute("profile", Users.profile);
        return "orders";
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
}
