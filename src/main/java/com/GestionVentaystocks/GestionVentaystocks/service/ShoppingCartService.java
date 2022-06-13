package com.GestionVentaystocks.GestionVentaystocks.service;

import com.GestionVentaystocks.GestionVentaystocks.models.Product;
import com.GestionVentaystocks.GestionVentaystocks.models.ProductForSale;
import com.GestionVentaystocks.GestionVentaystocks.models.shoppingCart;
import com.GestionVentaystocks.GestionVentaystocks.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingCartService {

    private List<ProductForSale> productsSale = new ArrayList<ProductForSale>();
    private float total;

    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    public Long ShoppingCartGuardar(shoppingCart shoppingcart){

        return shoppingCartRepository.save(shoppingcart).getId();

    }

    public shoppingCart getShoppingCart(Long id){

        return shoppingCartRepository.findById(id).get();
    }

    public shoppingCart ShoppingCartAgregarProducto(Long id, Product product){
        shoppingCart shoppingCart = shoppingCartRepository.findById(id).get();
        shoppingCart.agregarProduct(product);

        productsSale = shoppingCart.mapProduct(shoppingCart.getProducts());
        total = shoppingCart.getTotal(productsSale);

        return shoppingCartRepository.save(shoppingCart);
    }

    public shoppingCart ShoppingCartQuitarProducto(Long id, shoppingCart shoppingcart){
        shoppingCart shoppingCart = shoppingCartRepository.findById(id).get();

        shoppingCart.setProducts(shoppingcart.getProducts());

        productsSale = shoppingCart.mapProduct(shoppingCart.getProducts());
        total = shoppingCart.getTotal(productsSale);

        return shoppingCartRepository.save(shoppingCart);
    }

    public List<ProductForSale> ListProductForSale(Long id){
        shoppingCart shoppingCart = shoppingCartRepository.findById(id).get();

        return shoppingCart.mapProduct(shoppingCart.getProducts());
    }

    public float getTotal(Long id){
        shoppingCart shoppingCart = shoppingCartRepository.findById(id).get();

        productsSale = shoppingCart.mapProduct(shoppingCart.getProducts());

        return shoppingCart.getTotal(productsSale);
    }


    public void shoppingCartBorrar(Long id){

        shoppingCartRepository.deleteById(id);

    }




}
