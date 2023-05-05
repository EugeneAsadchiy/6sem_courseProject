package com.shop.ShoesShop.Services;

import com.shop.ShoesShop.models.ConfirmedOrders;
import com.shop.ShoesShop.models.Orders;
import com.shop.ShoesShop.models.Products;
import com.shop.ShoesShop.repository.ConfirmedOrdersRepository;
import com.shop.ShoesShop.repository.OrdersRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Date;
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
        confirmedOrders.setAmount(1);
        confirmedOrders.setSeason(orders.getSeason());
        confirmedOrders.setIdUsers(orders.getIdUsers());
        confirmedOrders.setSize(orders.getSize());
        confirmedOrdersRepository.save(confirmedOrders);

    }
    public List<ConfirmedOrders> getOrdersByIdUsers(Long id_user){
        return confirmedOrdersRepository.findAllByIdUsers(id_user);
    }
    public List<ConfirmedOrders> getAllByDate(LocalDate date_since, LocalDate date_before){
        return confirmedOrdersRepository.findAllByDataOfCreatedBetween(date_since,date_before);
    }
    public Orders findByNameOrders(String nameProducts) {
        return ordersRepository.findByNameProducts(nameProducts);
    }
}
