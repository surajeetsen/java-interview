package com.globomart.globomartproductcatalog.entity;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCT_CATALOG")
public class ProductCatalog {

    @Id
    @GeneratedValue
    @Column(name = "PRODUCT_ID")
    private Integer productId;

    @Column(name = "PRODUCT_TYPE")
    private String productType;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "PRODUCT_DESCRIPTION")
    private String productDescription;

    public ProductCatalog() {
    }

    public ProductCatalog(String productType, String productName, String productDescription) {
        this.productType = productType;
        this.productName = productName;
        this.productDescription = productDescription;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
}
