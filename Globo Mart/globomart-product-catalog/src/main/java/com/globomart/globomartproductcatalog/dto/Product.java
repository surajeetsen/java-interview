package com.globomart.globomartproductcatalog.dto;

import javax.persistence.Column;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Product {
    private String productType;

    private String productName;

    private String productDescription;

    public Product() {
    }

    public Product(String productType, String productName, String productDescription) {
        this.productType = productType;
        this.productName = productName;
        this.productDescription = productDescription;
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
