package com.globomart.globomartproductcatalog.dao;

import com.globomart.globomartproductcatalog.entity.ProductCatalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCatalogRepository extends JpaRepository<ProductCatalog, Integer> {
    public List<ProductCatalog> findByProductType(String productType);
}