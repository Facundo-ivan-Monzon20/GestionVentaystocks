package com.GestionVentaystocks.GestionVentaystocks.controller;

import com.GestionVentaystocks.GestionVentaystocks.models.Product;
import com.GestionVentaystocks.GestionVentaystocks.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
//ruta principal o raìz de donde se consumen los distintos pedidos. get,post,etc
@RequestMapping("/api/")
//la ruta de donde se consume la api, o el front-end le hace pedidos al back-end
@CrossOrigin(origins = "*")
public class ProductControllers {
  private ProductService productService;

  @Autowired
  public ProductControllers(ProductService productService) {
    this.productService = productService;
  }

  // este metodo es un Get donde se listan todos los productos.
  @GetMapping("/productos")
  public List<Product> ListProducts(){
    return productService.filterProductColum();
  }
  @GetMapping("/productos/{id}")
  public Optional<Product> getProduct(@PathVariable(value = "id") Long id){
    return productService.ProductPorId(id);
  }
  @PostMapping("/productos")
  public Product saveProduct(@RequestBody Product product){

    return productService.ProductGuardar(product);
  }

  @PutMapping("productos/{id}")
  public void updateProduct(@PathVariable(value = "id") Long id,@RequestBody Product product){
    productService.ProductActualizar(id,product);
  }

  @DeleteMapping("/productos/{id}")
  public void deleteProduct(@PathVariable(value = "id") Long id){

    productService.ProductEliminar(id);
  }
}
