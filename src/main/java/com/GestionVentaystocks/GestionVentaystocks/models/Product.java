package com.GestionVentaystocks.GestionVentaystocks.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

// Esta clase se conecta con la tabla Mysql de H2
@Entity
@Table(name = "Product")
@Getter @Setter
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", length = 60, nullable = false, unique = true)
  private String name;

  @Column(name = "price", length = 60, nullable = false)
  private Integer price;

  @Column(name = "stocks")
  private Integer stocks;


  public void sum_stock(Integer stock){
    this.stocks = this.stocks + stock;
  }
}
