package com.GestionVentaystocks.GestionVentaystocks.service;

import com.GestionVentaystocks.GestionVentaystocks.models.Product;
import com.GestionVentaystocks.GestionVentaystocks.models.shoppingCart;
import com.GestionVentaystocks.GestionVentaystocks.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    public Optional<shoppingCart> getShoppingCart(Long id){

        return shoppingCartRepository.findById(id);
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

    public void sumProduct(Long id, Product product){
        shoppingCart cart = shoppingCartRepository.findById(id).get();
        cart.agregarProduct(product);
        shoppingCartRepository.save(cart);
    }

    public void resProduct(Long id, Product product){
        shoppingCart cart = shoppingCartRepository.findById(id).get();
        cart.quitarProduct(product);
        shoppingCartRepository.save(cart);
    }

    public float total(Long id){
        shoppingCart cart = shoppingCartRepository.findById(id).get();
        return cart.getTotal(cart.mapProduct(cart.getProducts())) ;
    }


}
