package com.GestionVentaystocks.GestionVentaystocks.repository;

import com.GestionVentaystocks.GestionVentaystocks.models.shoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends JpaRepository<shoppingCart,Long> {

}