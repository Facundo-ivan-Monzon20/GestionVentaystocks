package com.GestionVentaystocks.GestionVentaystocks.models;

import com.GestionVentaystocks.GestionVentaystocks.service.ProductService;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Map;

import javax.persistence.*;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Entity
@Table(name = "shoppingCart")
@Getter
@Setter
public class shoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @JoinColumn(name = "products_id")
    @ManyToMany
    private List<Product> products;


    public void agregarProduct(Product product){
        products.add(product);
    }

    public List<ProductForSale> mapProduct(List<Product> products){

        List<ProductForSale> productsCart = new ArrayList<ProductForSale>();
        Map<Product, Integer> map = products.stream().collect(Collectors.toMap(Function.identity(), value -> 1, Integer::sum));
        List<Product> keys = new ArrayList<Product>();

        for(Product product: products){
            if(keys.contains(product)){
            }else{
                keys.add(product);
                productsCart.add(new ProductForSale(product.getId(),product.getName(),product.getPrice(),product.getStocks(),product.isActivated(),map.get(product)));
            }
        }
        return productsCart;
    }

    public float getTotal(List<ProductForSale> products){

        float total = 0;

        for(ProductForSale product: products){
            total = total + product.getTotal();
        }
        return total;

    }
}
