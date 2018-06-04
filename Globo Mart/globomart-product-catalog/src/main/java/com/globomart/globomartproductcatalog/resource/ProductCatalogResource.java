package com.globomart.globomartproductcatalog.resource;

import com.globomart.globomartproductcatalog.dao.ProductCatalogRepository;
import com.globomart.globomartproductcatalog.dto.Product;
import com.globomart.globomartproductcatalog.entity.ProductCatalog;
import com.globomart.globomartproductcatalog.exception.ProductNotFoundException;
import com.globomart.globomartproductcatalog.exception.ProductTypeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class ProductCatalogResource {

    @Autowired
    private ProductCatalogRepository productCatalogRepository;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productCatalogRepository.findAll()
                                .stream()
                                .map(productCatalog -> new Product(productCatalog.getProductType(),
                                                                   productCatalog.getProductName(),
                                                                   productCatalog.getProductDescription()))
                                .collect(Collectors.toList());
    }

    @PostMapping("/products")
    public boolean addProduct(@RequestBody final Product product) {
        productCatalogRepository.save(new ProductCatalog(product.getProductType(),
                                                         product.getProductName(),
                                                         product.getProductDescription()));
        return true;
    }

    @GetMapping("/products/{productType}")
    public List<Product> getProductByType(@PathVariable("productType") final String productType) throws ProductTypeNotFoundException {
        List<ProductCatalog> products = productCatalogRepository.findByProductType(productType);

        if(products == null || products.size() == 0) {
            throw new ProductTypeNotFoundException("Product Type " + productType + " not found!");
        }

        return products.stream()
                .map(productCatalog -> new Product(productCatalog.getProductType(),
                                                   productCatalog.getProductName(),
                                                   productCatalog.getProductDescription()))
                .collect(Collectors.toList());
    }

    @DeleteMapping("/products")
    public Product deleteProduct(@RequestBody final Product product) throws ProductNotFoundException {
        Example<ProductCatalog> productExample = Example.of(new ProductCatalog(product.getProductType(),
                                                                               product.getProductName(),
                                                                               product.getProductDescription()));

        Optional<ProductCatalog> productCatalog = productCatalogRepository.findOne(productExample);
        if(!productCatalog.isPresent()) {
            throw new ProductNotFoundException("Product " + product.getProductName() + " Not found!");
        }

        ProductCatalog productCat = productCatalog.get();
        Product delProduct = new Product(productCat.getProductType(), productCat.getProductName(), productCat.getProductDescription());
        productCatalogRepository.delete(productCat);
        return delProduct;
    }

}
