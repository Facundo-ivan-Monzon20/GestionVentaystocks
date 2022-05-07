package com.GestionVentaystocks.GestionVentaystocks.controller;


import com.GestionVentaystocks.GestionVentaystocks.models.Product;
import com.GestionVentaystocks.GestionVentaystocks.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/Products")
@CrossOrigin(origins = "http://localhost:4200/")
public class ProductControllers {

  @Autowired
  private ProductRepository repository;

  @GetMapping("/ListProducts")
  public List<Product> ListProducts(){
    return repository.findAll();
  }
}
