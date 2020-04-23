package com.spand0x.xmlcardealer.models.dtos.seed;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "suppliers")
@XmlAccessorType(XmlAccessType.FIELD)
public class SuppliersRootSeedDto {
    @XmlElement(name = "supplier")
    private List<SupplierSeedDto> suppliers;

    public SuppliersRootSeedDto() {
    }

    public SuppliersRootSeedDto(List<SupplierSeedDto> suppliers) {
        this.suppliers = suppliers;
    }

    public List<SupplierSeedDto> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<SupplierSeedDto> suppliers) {
        this.suppliers = suppliers;
    }
}
