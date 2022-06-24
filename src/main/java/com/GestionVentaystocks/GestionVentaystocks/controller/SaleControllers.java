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

    @GetMapping("/venta")
    public List<Sale> ListSale(){
        return  saleService.ListSale();
    }

    @GetMapping("/venta/{id}")
    public Optional<Sale> getSale(@PathVariable(value = "id")Long id){
        return saleService.getSale(id);
    }

    @PostMapping("/venta")
    public Sale saveSale(@RequestBody Sale sale){
        LocalDate date = LocalDate.now();
        sale.setDate_sale(date);
        return saleService.saveSale(sale);
    }

    @DeleteMapping("/venta/{id}")
    public void deleteSale(@PathVariable(value = "id")Long id){
        saleService.deleteSale(id);
    }

    @GetMapping("/venta/mapped")
    public Map<Long,Map<LocalDate, List<ProductForSale>>> mapeoSale(){
        return saleService.mapeoSale();
    }

    @GetMapping("/venta/total")
    public Map<Long,Float> totalSale(){
        return saleService.total();
    }

}
