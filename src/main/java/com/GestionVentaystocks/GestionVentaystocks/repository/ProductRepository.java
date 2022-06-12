package com.GestionVentaystocks.GestionVentaystocks.repository;

import com.GestionVentaystocks.GestionVentaystocks.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.function.Predicate;

// Gracias a la libreria JpaRepository a traves de la interface le damos
// resolvemos cuestiones basicas de consumisión de pedidos al back
// por ejemplo: repository.findAll() en el controller.
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
