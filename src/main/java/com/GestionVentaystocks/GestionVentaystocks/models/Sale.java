package com.GestionVentaystocks.GestionVentaystocks.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "Sale")
@Getter @Setter
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_sale")
    private LocalDate date_sale;

    @JoinColumn(name = "shopping_cart_id")
    @OneToOne
    private shoppingCart shoppingCart;

}
