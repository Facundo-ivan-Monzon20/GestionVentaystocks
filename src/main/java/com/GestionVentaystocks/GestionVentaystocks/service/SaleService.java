package com.GestionVentaystocks.GestionVentaystocks.service;

import com.GestionVentaystocks.GestionVentaystocks.models.ProductForSale;
import com.GestionVentaystocks.GestionVentaystocks.models.Sale;
import com.GestionVentaystocks.GestionVentaystocks.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SaleService {

    List<ProductForSale> productsSale = new ArrayList<ProductForSale>();
    private SaleRepository saleRepository;


    @Autowired
    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public List<Sale> ListSale(){

        return saleRepository.findAll();
    }

    public Sale SaleGuardar(Sale sale){

        return saleRepository.save(sale);
    }
}
