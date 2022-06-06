package com.GestionVentaystocks.GestionVentaystocks.repository;

import com.GestionVentaystocks.GestionVentaystocks.models.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale,Long> {


}
