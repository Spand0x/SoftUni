package com.spand0x.xmlparser.models.dtos.queryFour;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder = {"firstName","lastName","age","soldProducts"})
public class UserProductsSoldDto {
    private String firstName;
    private String lastName;
    private String age;
    private ProductsRootDto soldProducts;

    public UserProductsSoldDto() {
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

    @XmlAttribute(name = "age")
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @XmlElement(name = "sold-products")
    public ProductsRootDto getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(ProductsRootDto soldProducts) {
        this.soldProducts = soldProducts;
    }
}
