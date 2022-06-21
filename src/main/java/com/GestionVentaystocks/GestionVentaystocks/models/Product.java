package com.GestionVentaystocks.GestionVentaystocks.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

// Esta clase se conecta con la tabla Mysql de H2
@Entity
@Table(name = "Product")
@Getter
@Setter
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", length = 60, nullable = false)
  private String name;

  @Column(name = "price", length = 60, nullable = false)
  private float price;

  @Column(name= "stocks")
  private Integer stocks;

  @Column(name = "activated", columnDefinition = "boolean default true")
  private boolean activated;


  public Product(Long id, String name, float price, Integer stocks, boolean activated) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.stocks = stocks;
    this.activated = activated;
  }

  public Product() {

  }

  public Integer sumStocks(Integer sum){
    this.stocks = this.stocks + sum;
    return stocks;
  }

  public void resStocks(Integer res){
    this.stocks = this.stocks - res;
  }
}
