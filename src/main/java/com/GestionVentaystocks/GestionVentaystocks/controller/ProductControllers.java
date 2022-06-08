package com.GestionVentaystocks.GestionVentaystocks.controller;

import org.springframework.http.ResponseEntity;
import com.GestionVentaystocks.GestionVentaystocks.models.Product;
import com.GestionVentaystocks.GestionVentaystocks.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
//ruta principal o raìz de donde se consumen los distintos pedidos. get,post,etc
@RequestMapping("/api/")
//la ruta de donde se consume la api, o el front-end le hace pedidos al back-end
@CrossOrigin(origins = "http://localhost:3000")
public class ProductControllers {

  @Autowired
  private ProductRepository repository;

  // este metodo es un Get donde se listan todos los productos.
  @GetMapping("/productos")
  public List<Product> ListProducts(){
    return repository.findAll();
  }

  @PostMapping("/productos")
  public Product saveProduct(@RequestBody Product product){
    return repository.save(product);
  }

  @GetMapping("/productos/{id}")
	public void getProductoById(@PathVariable(value = "id") Long id){
    repository.getById(id);
  }

  @PutMapping("/productos/{id}")
  public void updateStocks(@PathVariable(value = "id") Long id, @RequestBody Product product){
    Product product_id = repository.getById(id);
    if (product_id.getById().equals(product.getById())){
      repository.save(product);
    }
  }

  @PutMapping("/stocks/{id}")
  public void updateStocks(@PathVariable(value = "id") Long id, @RequestBody Integer stock){
    Product product = repository.getById(id);
    product.sum_stock(stock);
    repository.save(product);
  }

  @DeleteMapping("/productos/{id}")
  public void deleteProduct(@PathVariable(value = "id") Long id){
      repository.deleteById(id);
  }
}
