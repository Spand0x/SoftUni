package com.spand0x.xmlcardealer.models.dtos.queryThree;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "suppliers")
@XmlAccessorType(XmlAccessType.FIELD)
public class SupplierLocalRootDto {
    @XmlElement(name = "suppliers")
    private List<SupplierLocalDto> suppliers;

    public SupplierLocalRootDto() {
    }

    public SupplierLocalRootDto(List<SupplierLocalDto> suppliers) {
        this.suppliers = suppliers;
    }

    public List<SupplierLocalDto> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<SupplierLocalDto> suppliers) {
        this.suppliers = suppliers;
    }
}
