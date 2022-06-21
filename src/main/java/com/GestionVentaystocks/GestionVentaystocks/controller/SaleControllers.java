package com.GestionVentaystocks.GestionVentaystocks.controller;

import com.GestionVentaystocks.GestionVentaystocks.models.ProductForSale;
import com.GestionVentaystocks.GestionVentaystocks.models.Sale;
import com.GestionVentaystocks.GestionVentaystocks.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class SaleControllers {

    private SaleService saleService;

    @Autowired
    public SaleControllers(SaleService saleService) {
        this.saleService = saleService;
    }

    @GetMapping("/sale")
    public List<Sale> ListSale(){
        return  saleService.ListSale();
    }

    @GetMapping("/sale/{id}")
    public Optional<Sale> getSale(@PathVariable(value = "id")Long id){
        return saleService.getSale(id);
    }

    @PostMapping("/sale")
    public Sale saveSale(@RequestBody Sale sale){
        LocalDate date = LocalDate.now();
        sale.setDate_sale(date);
        return saleService.saveSale(sale);
    }

    @DeleteMapping("/sale/{id}")
    public void deleteSale(@PathVariable(value = "id")Long id){
        saleService.deleteSale(id);
    }

    @GetMapping("/sale/mapped")
    public Map<Long,Map<LocalDate, List<ProductForSale>>> mapeoSale(){
        return saleService.mapeoSale();
    }
}
