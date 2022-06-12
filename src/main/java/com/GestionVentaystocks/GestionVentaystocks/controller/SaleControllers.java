package com.GestionVentaystocks.GestionVentaystocks.controller;

import com.GestionVentaystocks.GestionVentaystocks.models.Product;
import com.GestionVentaystocks.GestionVentaystocks.models.Sale;
import com.GestionVentaystocks.GestionVentaystocks.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/")
@CrossOrigin(origins = "*")
public class SaleControllers {

    @Autowired
    private SaleRepository saleRepository;


    @GetMapping("/sale/")
    public int get_total(@PathVariable(name = "id") Long id){
        Sale sale = saleRepository.getById(id);
        List<Product> products = sale.getProducts();

        //Map<Product, Integer> map = products.stream().collect(Collectors.toMap(Function.identity(), value -> 1, Integer::sum));
        //map.get(products.get(1));

        int total = 0;
        return total;

    }
}
