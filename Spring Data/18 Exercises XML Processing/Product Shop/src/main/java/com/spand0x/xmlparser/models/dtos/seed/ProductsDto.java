package com.spand0x.xmlparser.models.dtos.seed;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ProductsDto {

    List<ProductSeedDto> productSeedDto;

    public ProductsDto() {
    }

    public ProductsDto(List<ProductSeedDto> productSeedDto) {
        this.productSeedDto = productSeedDto;
    }

    @XmlElement(name = "product")
    public List<ProductSeedDto> getProductSeedDto() {
        return productSeedDto;
    }

    public void setProductSeedDto(List<ProductSeedDto> productSeedDto) {
        this.productSeedDto = productSeedDto;
    }
}
