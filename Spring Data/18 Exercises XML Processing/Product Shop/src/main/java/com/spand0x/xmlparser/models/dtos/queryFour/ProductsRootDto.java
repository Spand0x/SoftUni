package com.spand0x.xmlparser.models.dtos.queryFour;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "sold-products")
public class ProductsRootDto {
    private int count;
    private List<SoldProductDto> products;

    public ProductsRootDto() {
    }

    @XmlAttribute(name = "count")
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ProductsRootDto(List<SoldProductDto> products) {
        this.products = products;
    }

    @XmlElement(name = "product")
    public List<SoldProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<SoldProductDto> products) {
        this.products = products;
    }
}
