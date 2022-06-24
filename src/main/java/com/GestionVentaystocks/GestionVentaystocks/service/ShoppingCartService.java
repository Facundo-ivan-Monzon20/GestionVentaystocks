package com.GestionVentaystocks.GestionVentaystocks.service;


import com.GestionVentaystocks.GestionVentaystocks.models.Product;
import com.GestionVentaystocks.GestionVentaystocks.models.ProductForSale;
import com.GestionVentaystocks.GestionVentaystocks.models.shoppingCart;
import com.GestionVentaystocks.GestionVentaystocks.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;

    @Autowired
    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    public List<shoppingCart> ListShoppingCart(){
        return shoppingCartRepository.findAll();
    }

    public  Map<Long, List<ProductForSale>> getShoppingCart(Long id){
        shoppingCart cart = shoppingCartRepository.findById(id).get();
        Map<Long, List<ProductForSale>> map = new HashMap<Long, List<ProductForSale>>();
        map.put(cart.getId(),cart.mapProduct(cart.getProducts()));

        return map;
    }

    public shoppingCart saveShoppingCart(shoppingCart shoppingCart){

        return shoppingCartRepository.save(shoppingCart);
    }

    public shoppingCart updateShoppingCart(Long id, shoppingCart shoppingCart){

        shoppingCart cart = shoppingCartRepository.findById(id).get();
        cart.setProducts(shoppingCart.getProducts());
        return shoppingCartRepository.save(cart);
    }

    public void deleteShoppingCart(Long id){
        shoppingCartRepository.deleteById(id);
    }

    public float total(Long id){
        shoppingCart cart = shoppingCartRepository.findById(id).get();
        return cart.getTotal(cart.mapProduct(cart.getProducts())) ;
    }

    public Map<Long, List<ProductForSale>> mapeoCarrito(){

        Map<Long, List<ProductForSale>> map = new HashMap<Long, List<ProductForSale>>();

        for(shoppingCart cart: shoppingCartRepository.findAll()){
            map.put(cart.getId(), cart.mapProduct(cart.getProducts()));
        }
        return map;
    }

    public void quitarProducto(Long id, Long Idproduct) {
        shoppingCart cart = shoppingCartRepository.findById(id).get();
        cart.setProducts(cart.quitar(Idproduct));
        shoppingCartRepository.save(cart);
    }

    public void agregarProducto(Long id, Product product) {

        shoppingCart cart = shoppingCartRepository.findById(id).get();
        cart.setProducts(cart.agregar(product));
        shoppingCartRepository.save(cart);

    }
}
