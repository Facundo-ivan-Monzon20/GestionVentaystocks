package com.GestionVentaystocks.GestionVentaystocks.controller;

import com.GestionVentaystocks.GestionVentaystocks.models.Product;
import com.GestionVentaystocks.GestionVentaystocks.models.ProductForSale;
import com.GestionVentaystocks.GestionVentaystocks.models.shoppingCart;
import com.GestionVentaystocks.GestionVentaystocks.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//ruta principal o raìz de donde se consumen los distintos pedidos. get,post,etc
@RequestMapping("/api/")
//la ruta de donde se consume la api, o el front-end le hace pedidos al back-end
@CrossOrigin(origins = "*")
public class ShoppingCartCotrollers {


    private ShoppingCartService shoppingCartService;

    @Autowired
    public ShoppingCartCotrollers(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping("/shoppingCart/{id}")
    public shoppingCart getShoppingCart(@PathVariable(value = "id") Long id){
        return shoppingCartService.getShoppingCart(id);
    }

    @GetMapping("/shoppingCart/ListProduct/{id}")
    public List<ProductForSale> getListProduct(@PathVariable(value = "id") Long id){
        return shoppingCartService.ListProductForSale(id);
    }

    @GetMapping("/shoppingCart/total/{id}")
    public float getTotal(@PathVariable(value = "id") Long id){
        return shoppingCartService.getTotal(id);
    }

    @PostMapping("/shoppingCart")
    public Long saveShoppingCart(@RequestBody shoppingCart shoppingCart){
        return shoppingCartService.ShoppingCartGuardar(shoppingCart);
    }

    @PutMapping("shoppingCart/agregarProducto/{id}")
    public shoppingCart addShoppingCart(@PathVariable(value = "id") Long id,@RequestBody Product product){

        return shoppingCartService.ShoppingCartAgregarProducto(id,product);
    }
    @PutMapping("shoppingCart/quitarProducto/{id}")
    public shoppingCart putOffShoppingCart(@PathVariable(value = "id") Long id,@RequestBody shoppingCart shoppingcart){
        return shoppingCartService.ShoppingCartQuitarProducto(id,shoppingcart);
    }

    @DeleteMapping("/shoppingCart/{id}")
    public void deleteShoppingCart(@PathVariable(value = "id")Long id){
        shoppingCartService.shoppingCartBorrar(id);
    }


}
