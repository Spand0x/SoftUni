package com.spand0x.xmlcardealer.models.dtos.seed;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomersRootSeedDto {
    @XmlElement(name = "customer")
    private List<CustomersSeedDto> customers;

    public CustomersRootSeedDto() {
    }

    public List<CustomersSeedDto> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomersSeedDto> customers) {
        this.customers = customers;
    }
}
