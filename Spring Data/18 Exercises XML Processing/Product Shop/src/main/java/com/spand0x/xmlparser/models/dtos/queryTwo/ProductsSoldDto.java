package com.spand0x.xmlparser.models.dtos.queryTwo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "sold-products")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ProductsSoldDto {

    private List<ProductSoldDto> products;

    public ProductsSoldDto() {
    }

    @XmlElement(name = "product")
    public List<ProductSoldDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductSoldDto> products) {
        this.products = products;
    }
}
