package com.shop.ShoesShop.repository;


import com.shop.ShoesShop.models.ConfirmedOrders;
import com.shop.ShoesShop.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface ConfirmedOrdersRepository extends JpaRepository<ConfirmedOrders, Long> {

    List<ConfirmedOrders> findAllByDataOfCreatedBetween(LocalDate dataOfCreated, LocalDate dataOfCreated2);
    List<ConfirmedOrders> findAllByIdUsers(Long id_user);
}
