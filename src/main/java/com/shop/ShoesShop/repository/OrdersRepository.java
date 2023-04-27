package com.shop.ShoesShop.repository;


import com.shop.ShoesShop.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
    List<Orders> findAllByIdUsers(Long id_users);



    Orders findByNameProducts(String nameProducts);

//    String findByUserLogin(String profile);
}
