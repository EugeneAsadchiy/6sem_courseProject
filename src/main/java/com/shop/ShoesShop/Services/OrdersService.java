package com.shop.ShoesShop.Services;

import com.shop.ShoesShop.models.Orders;
import com.shop.ShoesShop.models.Products;
import com.shop.ShoesShop.repository.OrdersRepository;
import com.shop.ShoesShop.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrdersService {
    private final OrdersRepository ordersRepository;
    public void saveOrders(Products products, Long id_users) {
        Orders orders= new Orders();
        orders.setNameProducts(products.getNameProducts());
        orders.setCost(products.getCost());
        orders.setGender(products.getGender());
        orders.setAmount("1");
        orders.setSeason(products.getSeason());
        orders.setIdUsers(id_users);
        ordersRepository.save(orders);
    }
}
