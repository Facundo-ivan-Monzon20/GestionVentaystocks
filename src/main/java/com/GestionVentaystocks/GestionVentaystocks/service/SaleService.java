package com.GestionVentaystocks.GestionVentaystocks.service;

import com.GestionVentaystocks.GestionVentaystocks.models.Product;
import com.GestionVentaystocks.GestionVentaystocks.models.ProductForSale;
import com.GestionVentaystocks.GestionVentaystocks.models.Sale;
import com.GestionVentaystocks.GestionVentaystocks.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

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

        Map<Product, Integer> mapProduct = sale.getProducts().stream().collect(Collectors.toMap(Function.identity(), value -> 1, Integer::sum));
        List<Product> keys = new ArrayList<Product>();

        for(Product product: sale.getProducts()){

            if(keys.contains(product)){

            }else{
                productsSale.add(new ProductForSale(product.getId(),product.getName(),product.getPrice(),product.getStocks(),product.isActivated(),mapProduct.get(product)));
            }
        }

        return saleRepository.save(sale);
    }

    public float precioTotalPorUnidad(Integer indice){

        return productsSale.get(indice).getTotal();
    }

    public float total(){
        float suma = 0;

        for(int i=0; i < productsSale.size();i++){
            suma = suma + productsSale.get(i).getTotal();
        }
        return suma;
    }
}
