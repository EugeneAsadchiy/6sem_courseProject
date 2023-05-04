package com.shop.ShoesShop.Services;

import com.shop.ShoesShop.models.Orders;
import com.shop.ShoesShop.models.Products;
import com.shop.ShoesShop.repository.OrdersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrdersService {
    private final OrdersRepository ordersRepository;
    public void saveOrders(Products products,String orders_images,String size ,Long id_users) {
        Orders orders= new Orders();
        orders.setNameProducts(products.getNameProducts());
        orders.setCost(products.getCost());
        orders.setGender(products.getGender());
        orders.setAmount(1);
        orders.setSeason(products.getSeason());
        orders.setIdUsers(id_users);
        orders.setSize(size);
        orders.setUrlImages(orders_images);

        ordersRepository.save(orders);
    }

    public List<Orders> getOrdersByIdUsers(Long id_users)
    {
        return ordersRepository.findAllByIdUsers(id_users);
    }

    public Orders findByNameOrders(String nameProducts) {
        return ordersRepository.findByNameProducts(nameProducts);
    }


}
