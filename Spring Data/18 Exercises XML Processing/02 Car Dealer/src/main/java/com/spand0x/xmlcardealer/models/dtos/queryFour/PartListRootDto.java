package com.spand0x.xmlcardealer.models.dtos.queryFour;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "parts")
@XmlAccessorType(XmlAccessType.FIELD)
public class PartListRootDto {
    @XmlElement(name = "parts")
    private List<PartListDto> parts;

    public PartListRootDto() {
    }

    public PartListRootDto(List<PartListDto> parts) {
        this.parts = parts;
    }

    public List<PartListDto> getParts() {
        return parts;
    }

    public void setParts(List<PartListDto> parts) {
        this.parts = parts;
    }
}
