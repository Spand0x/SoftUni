package com.spand0x.xmlparser.models.dtos.queryOne;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ProductsInRangeDto {
    private List<ProductInRangeDto> products;

    public ProductsInRangeDto(List<ProductInRangeDto> products) {
        this.products = products;
    }

    public ProductsInRangeDto() {
    }

    @XmlElement(name = "product")
    public List<ProductInRangeDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductInRangeDto> products) {
        this.products = products;
    }
}
