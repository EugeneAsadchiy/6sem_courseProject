package com.shop.ShoesShop.repository;

import com.shop.ShoesShop.models.Products;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductsRepository extends JpaRepository<Products, Long> {
    List<Products> findByNameProducts(String name);
//    List<Products> findById_products (Long id_products);
    List<Products> findByNameProductsAndCostBetweenAndGenderAndSeason(String products_name,int min_price, int max_price,
                                                                      String gender,String season);
    List<Products> findByCostBetween(int min_price, int max_price);
    List<Products> findByCostBetweenAndGenderAndSeason(int min_price, int max_price,String gender,String season );

    List<Products> findByCost(Sort cost);
//    List<Products> findByName_products(String name_products);
}
