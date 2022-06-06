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
@RequestMapping("api/sale")
@CrossOrigin(origins = "*")
public class SaleControllers {

    @Autowired
    private SaleRepository saleRepository;

    @GetMapping("/get_sale")
    public List<Sale> get_sales(){
        return saleRepository.findAll();
    }

    @PostMapping("/save_sale")
    public void saveSale(@RequestBody Sale sale){
        LocalDate date = LocalDate.now();
        sale.setDate_sale(date);

        saleRepository.save(sale);
    }

    @GetMapping("/sale_total/{id}")
    public int get_total(@PathVariable(name = "id") Long id){
        Sale sale = saleRepository.getById(id);
        List<Product> products = sale.getProducts();

        //Map<Product, Integer> map = products.stream().collect(Collectors.toMap(Function.identity(), value -> 1, Integer::sum));
        //map.get(products.get(1));

        int total = 0;
        for (Product product : products) {
            total = total + product.getPrice();
        }
        return total;
    }
}
