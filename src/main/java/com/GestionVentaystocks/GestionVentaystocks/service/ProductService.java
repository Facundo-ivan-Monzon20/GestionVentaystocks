package com.GestionVentaystocks.GestionVentaystocks.service;

import com.GestionVentaystocks.GestionVentaystocks.models.Product;
import com.GestionVentaystocks.GestionVentaystocks.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<Product> filterProductColum(){
        List<Product> newListProduct = new ArrayList<>();
        for (Product product : productRepository.findAll()) {
            if (product.isActivated()) {
                newListProduct.add(product);
            }
        }
        return newListProduct;
    }

    public Optional<Product> ProductPorId(Long id){

        if (productRepository.existsById(id) && productRepository.findById(id).get().isActivated()){
            return productRepository.findById(id);
        }
        return Optional.empty();
    }

    public Product ProductGuardar(Product product){

        for (Product p: productRepository.findAll()){
            if(p.getName().equals(product.getName())){
                p.setPrice(product.getPrice());
                p.setStocks(product.getStocks());
                p.setActivated(true);
                return productRepository.save(p);
            }
        }

        product.setActivated(true);
        return productRepository.save(product);
    }

    public void ProductActualizar(Long id, Product product){

        if (productRepository.existsById(id)){
            Optional<Product> product_id = productRepository.findById(id);
            Product setProduct = product_id.get();

            if (!setProduct.getName().equals(product.getName())){
                setProduct.setName(product.getName());
            }
            if (!(setProduct.getPrice() == product.getPrice())){
                setProduct.setPrice(product.getPrice());
            }

            if (!setProduct.getStocks().equals(product.getStocks())){
                setProduct.setStocks(product.getStocks());
            }

            productRepository.save(setProduct);
        }

    }

    public void ProductEliminar(Long id){
        if (productRepository.existsById(id)){
            Optional<Product> product_id = productRepository.findById(id);
            Product setProduct = product_id.get();
            setProduct.setActivated(false);
            productRepository.save(setProduct);
        }
    }

}
