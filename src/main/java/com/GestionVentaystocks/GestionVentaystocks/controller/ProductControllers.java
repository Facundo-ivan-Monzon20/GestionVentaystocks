package com.GestionVentaystocks.GestionVentaystocks.controller;


import com.GestionVentaystocks.GestionVentaystocks.models.Product;
import com.GestionVentaystocks.GestionVentaystocks.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
//ruta principal o raìz de donde se consumen los distintos pedidos. get,post,etc
@RequestMapping("api/products")
//la ruta de donde se consume la api, o el front-end le hace pedidos al back-end
@CrossOrigin(origins = "*")
public class ProductControllers {

  @Autowired
  private ProductRepository repository;

  // este metodo es un Get donde se listan todos los productos.
  @GetMapping("/list_products")
  public List<Product> ListProducts(){
    return repository.findAll();
  }

  @PostMapping("/save_products")
  public Product saveProduct(@RequestBody Product product){
    return repository.save(product);
  }

  @GetMapping("/product/{id}")
  public Product getProducto(@PathVariable(value = "id") Long id){
    Product product = repository.getById(id);
    return product;
  }

  @PutMapping("update_product/{id}")
  public void updateStocks(@PathVariable(value = "id") Long id, @RequestBody Product product){
    Product product_id = repository.getById(id);
    if (product_id.getId().equals(product.getId())){
      repository.save(product);
    }
  }

  @PutMapping("update_stocks/{id}")
  public void updateStocks(@PathVariable(value = "id") Long id, @RequestBody Integer stock){
    Product product = repository.getById(id);
    product.sum_stock(stock);
    repository.save(product);
  }

  @DeleteMapping("/delete_product/{id}")
  public void deleteProduct(@PathVariable(value = "id") Long id){
      repository.deleteById(id);
  }
}
