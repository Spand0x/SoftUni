package com.spand0x.xmlparser.models.dtos.queryTwo;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class UserProductsDto {
    private String firstName;
    private String lastName;
    private ProductsSoldDto soldProducts;

    public UserProductsDto() {
    }

    @XmlAttribute(name = "first-name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @XmlAttribute(name = "last-name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @XmlElement(name = "sold-products")
    public ProductsSoldDto getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(ProductsSoldDto soldProducts) {
        this.soldProducts = soldProducts;
    }
}
