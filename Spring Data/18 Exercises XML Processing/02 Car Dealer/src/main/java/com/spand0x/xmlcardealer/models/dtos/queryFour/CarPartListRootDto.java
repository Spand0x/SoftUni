package com.spand0x.xmlcardealer.models.dtos.queryFour;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarPartListRootDto {
    @XmlElement(name = "car")
    private List<CarPartListDto> cars;

    public CarPartListRootDto() {
    }

    public CarPartListRootDto(List<CarPartListDto> cars) {
        this.cars = cars;
    }

    public List<CarPartListDto> getCars() {
        return cars;
    }

    public void setCars(List<CarPartListDto> cars) {
        this.cars = cars;
    }
}
