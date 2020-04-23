package com.spand0x.xmlcardealer.models.dtos.queryTwo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarViewMakeRootDto {
    @XmlElement(name = "car")
    private List<CarViewMakeDto> cars;

    public CarViewMakeRootDto() {
    }

    public CarViewMakeRootDto(List<CarViewMakeDto> cars) {
        this.cars = cars;
    }

    public List<CarViewMakeDto> getCars() {
        return cars;
    }

    public void setCars(List<CarViewMakeDto> cars) {
        this.cars = cars;
    }
}
