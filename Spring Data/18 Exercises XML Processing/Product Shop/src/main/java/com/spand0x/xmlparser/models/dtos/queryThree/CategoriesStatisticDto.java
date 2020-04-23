package com.spand0x.xmlparser.models.dtos.queryThree;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class CategoriesStatisticDto {
    private List<CategoryStatisticDto> categories;

    public CategoriesStatisticDto() {
    }

    public CategoriesStatisticDto(List<CategoryStatisticDto> categories) {
        this.categories = categories;
    }

    @XmlElement(name = "category")
    public List<CategoryStatisticDto> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryStatisticDto> categories) {
        this.categories = categories;
    }
}
