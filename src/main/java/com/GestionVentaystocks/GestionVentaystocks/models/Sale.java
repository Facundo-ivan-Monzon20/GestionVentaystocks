package com.GestionVentaystocks.GestionVentaystocks.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Sale")
@Getter @Setter
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "date_sale")
    private Date date_sale;

    @Column(name = "products")
    @ElementCollection(targetClass=Product.class)
    private List<Product> products;
}
