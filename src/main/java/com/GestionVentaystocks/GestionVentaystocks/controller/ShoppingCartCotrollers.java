package com.GestionVentaystocks.GestionVentaystocks.controller;


import com.GestionVentaystocks.GestionVentaystocks.models.Product;
import com.GestionVentaystocks.GestionVentaystocks.models.ProductForSale;
import com.GestionVentaystocks.GestionVentaystocks.models.shoppingCart;
import com.GestionVentaystocks.GestionVentaystocks.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
//ruta principal o raìz de donde se consumen los distintos pedidos. get,post,etc
@RequestMapping("/api")
//la ruta de donde se consume la api, o el front-end le hace pedidos al back-end
@CrossOrigin(origins = "*")
public class ShoppingCartCotrollers {


    private ShoppingCartService shoppingCartService;

    @Autowired
    public ShoppingCartCotrollers(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping("/carrito")
    public List<shoppingCart> getListShopping(){
        return shoppingCartService.ListShoppingCart();
    }

    @GetMapping("/carrito/{id}")
    public Optional<shoppingCart> getShoppingCart(@PathVariable(value = "id") Long id){
        return shoppingCartService.getShoppingCart(id);
    }

    @PostMapping("/carrito")
    public shoppingCart saveShoppingCart(@RequestBody shoppingCart shoppingCart){
        return shoppingCartService.saveShoppingCart(shoppingCart);
    }

    @PutMapping("/carrito/{id}")
    public shoppingCart updateShoppingCart(@PathVariable(value = "id") Long id, @RequestBody shoppingCart shoppingCart){
        return shoppingCartService.updateShoppingCart(id,shoppingCart);
    }

    @DeleteMapping("/carrito/{id}")
    public void deleteShoppingCart(@PathVariable(value = "id") Long id){
        shoppingCartService.deleteShoppingCart(id);
    }

    @PutMapping("/carrito/agregar/{id}")
    public void sumProduct(@PathVariable(value = "id") Long id,@RequestBody Product product){
        shoppingCartService.sumProduct(id,product);
    }

    @PutMapping("/carrito/quitar/{id}")
    public void resProduct(@PathVariable(value = "id") Long id,@RequestBody Product product){
        shoppingCartService.resProduct(id,product);
    }

    @GetMapping("/carrito/total/{id}")
    public float total(@PathVariable(value = "id")Long id){
        return shoppingCartService.total(id);
    }
}
