package com.GestionVentaystocks.GestionVentaystocks.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Sale")
@Getter @Setter
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_sale")
    private LocalDate date_sale;

    @JoinColumn(name = "products_id")
    @ManyToMany
    private List<Product> products;

}
