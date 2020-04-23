package com.spand0x.xmlcardealer.models.dtos.queryFour;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarPartListDto {
    @XmlAttribute
    private String make;
    @XmlAttribute
    private String model;
    @XmlAttribute(name = "travelled-distance")
    private String travelledDistance;
    @XmlElement(name = "parts")
    private PartListRootDto parts;

    public CarPartListDto() {
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(String travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    public PartListRootDto getParts() {
        return parts;
    }

    public void setParts(PartListRootDto parts) {
        this.parts = parts;
    }
}
