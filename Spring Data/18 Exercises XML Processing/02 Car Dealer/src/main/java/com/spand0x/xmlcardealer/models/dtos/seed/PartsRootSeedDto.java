package com.spand0x.xmlcardealer.models.dtos.seed;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "parts")
@XmlAccessorType(XmlAccessType.FIELD)
public class PartsRootSeedDto {
    @XmlElement(name = "part")
    private List<PartsSeedDto> parts;

    public PartsRootSeedDto() {
    }

    public PartsRootSeedDto(List<PartsSeedDto> parts) {
        this.parts = parts;
    }

    public List<PartsSeedDto> getParts() {
        return parts;
    }

    public void setParts(List<PartsSeedDto> parts) {
        this.parts = parts;
    }
}
