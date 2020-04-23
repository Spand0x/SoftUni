package com.spand0x.xmlcardealer.models.dtos.seed;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarsRootSeedDto {
    @XmlElement(name = "car")
    private List<CarsSeedDto> cars;

    public CarsRootSeedDto() {
    }

    public CarsRootSeedDto(List<CarsSeedDto> cars) {
        this.cars = cars;
    }

    public List<CarsSeedDto> getCars() {
        return cars;
    }

    public void setCars(List<CarsSeedDto> cars) {
        this.cars = cars;
    }
}
