package com.GestionVentaystocks.GestionVentaystocks.service;

import com.GestionVentaystocks.GestionVentaystocks.models.Product;
import com.GestionVentaystocks.GestionVentaystocks.models.ProductForSale;
import com.GestionVentaystocks.GestionVentaystocks.models.Sale;
import com.GestionVentaystocks.GestionVentaystocks.repository.ProductRepository;
import com.GestionVentaystocks.GestionVentaystocks.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class SaleService {
    private SaleRepository saleRepository;

    @Autowired
    private ProductRepository productRepository;


    @Autowired
    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public List<Sale> ListSale(){
        return saleRepository.findAll();
    }

    public Optional<Sale> getSale(Long id){
        return saleRepository.findById(id);
    }

    public Sale saveSale(Sale sale){

        for(ProductForSale product: sale.getShoppingCart().mapProduct(sale.getShoppingCart().getProducts())){
            Product product1 = productRepository.findById(product.getId()).get();
            product1.resStocks(product.getQuantity());
            productRepository.save(product1);
        }


        return saleRepository.save(sale);
    }

    public Map<Long,Map<LocalDate, List<ProductForSale>>> mapeoSale(){
        Map<Long,Map<LocalDate, List<ProductForSale>>> map = new HashMap<Long, Map<LocalDate, List<ProductForSale>>>();

        Map<LocalDate, List<ProductForSale>> mapsort = new HashMap<LocalDate, List<ProductForSale>>();
        for(Sale sale1: saleRepository.findAll()){
            mapsort.put(sale1.getDate_sale(),sale1.getShoppingCart().mapProduct(sale1.getShoppingCart().getProducts()));
            map.put(sale1.getId(),mapsort);
        }


        return map;
    }

    public void deleteSale(Long id) {

        saleRepository.deleteById(id);
    }

    public Map<Long, Float> total() {
        Map<Long, Float> map = new HashMap<Long, Float>();

        for(Sale sale1: saleRepository.findAll()){
            List<ProductForSale> productForSales = sale1.getShoppingCart().mapProduct(sale1.getShoppingCart().getProducts());
            float total = sale1.getShoppingCart().getTotal(productForSales);
            map.put(sale1.getId(),total);
        }
        return map;
    }
}
