package com.spand0x.xmlcardealer.models.dtos.queryFive;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "sales")
@XmlAccessorType(XmlAccessType.FIELD)
public class SaleDiscountRootDto {
    @XmlElement(name = "sale")
    private List<SaleDiscountDto> sales;

    public SaleDiscountRootDto() {
    }

    public SaleDiscountRootDto(List<SaleDiscountDto> sales) {
        this.sales = sales;
    }

    public List<SaleDiscountDto> getSales() {
        return sales;
    }

    public void setSales(List<SaleDiscountDto> sales) {
        this.sales = sales;
    }
}
