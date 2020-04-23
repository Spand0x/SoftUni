package alararestaurant.domain.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "items")
@XmlAccessorType(XmlAccessType.FIELD)
public class ItemSeedRootDto {
    @XmlElement(name = "item")
    private List<ItemQuantitySeedDto> items;

    public ItemSeedRootDto() {
    }

    public List<ItemQuantitySeedDto> getItems() {
        return items;
    }

    public void setItems(List<ItemQuantitySeedDto> items) {
        this.items = items;
    }
}
