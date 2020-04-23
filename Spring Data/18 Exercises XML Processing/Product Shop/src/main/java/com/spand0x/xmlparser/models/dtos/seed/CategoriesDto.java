package com.spand0x.xmlparser.models.dtos.seed;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class CategoriesDto {

    List<CategorySeedDto> categories;

    public CategoriesDto() {
    }

    public CategoriesDto(List<CategorySeedDto> categories) {
        this.categories = categories;
    }

    @XmlElement(name = "category")
    public List<CategorySeedDto> getCategories() {
        return categories;
    }

    public void setCategories(List<CategorySeedDto> categories) {
        this.categories = categories;
    }
}
