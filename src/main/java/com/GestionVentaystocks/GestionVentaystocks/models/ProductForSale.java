package com.GestionVentaystocks.GestionVentaystocks.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductForSale extends Product {

    private Integer quantity;

    public ProductForSale(Long id, String name,float price,Integer stocks,boolean activated, Integer quantity) {
        super(id,name,price,stocks,activated);
        this.quantity = quantity;
    }

    public Float getTotal() {
        return this.getPrice() * this.quantity;
    }
}
