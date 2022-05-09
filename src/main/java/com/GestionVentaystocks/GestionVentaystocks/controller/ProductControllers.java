package com.GestionVentaystocks.GestionVentaystocks.controller;


import com.GestionVentaystocks.GestionVentaystocks.models.Product;
import com.GestionVentaystocks.GestionVentaystocks.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController

//ruta principal o raìz de donde se consumen los distintos pedidos. get,post,etc
@RequestMapping("api/Products")
//la ruta de donde se consume la api, o el front-end le hace pedidos al back-end
@CrossOrigin(origins = "http://localhost:4200/")
public class ProductControllers {

  @Autowired
  private ProductRepository repository;

  // este metodo es un Get donde se listan todos los productos.
  @GetMapping("/ListProducts")
  public List<Product> ListProducts(){
    return repository.findAll();
  }

  @PostMapping("/ListProducts")
  public Product saveProduct(@RequestBody Product product){
    return repository.save(product);
  }

}
