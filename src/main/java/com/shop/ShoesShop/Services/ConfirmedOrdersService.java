package com.shop.ShoesShop.Services;

import com.shop.ShoesShop.models.ConfirmedOrders;
import com.shop.ShoesShop.models.Orders;
import com.shop.ShoesShop.models.Products;
import com.shop.ShoesShop.repository.ConfirmedOrdersRepository;
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
public class ConfirmedOrdersService {
    private final OrdersRepository ordersRepository;
    private final ConfirmedOrdersRepository confirmedOrdersRepository;
    public void saveOrders (Orders orders) {
        ConfirmedOrders confirmedOrders = new ConfirmedOrders();
        confirmedOrders.setNameProducts(orders.getNameProducts());
        confirmedOrders.setCost(orders.getCost());
        confirmedOrders.setGender(orders.getGender());
        confirmedOrders.setAmount("1");
        confirmedOrders.setSeason(orders.getSeason());
        confirmedOrders.setIdUsers(orders.getIdUsers());
        confirmedOrders.setSize(orders.getSize());
        confirmedOrdersRepository.save(confirmedOrders);

    }
    public List<ConfirmedOrders> getOrdersByIdUsers(Long id_user){
        return confirmedOrdersRepository.findAllByIdUsers(id_user);
    }
//    public List<Orders> getOrdersByIdUsers(Long id_users)
//    {
//        return ordersRepository.findAllByIdUsers(id_users);
//    }

    public Orders findByNameOrders(String nameProducts) {
        return ordersRepository.findByNameProducts(nameProducts);
    }



}
