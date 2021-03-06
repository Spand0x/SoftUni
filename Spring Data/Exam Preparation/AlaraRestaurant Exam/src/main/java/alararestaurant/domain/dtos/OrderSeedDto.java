package alararestaurant.domain.dtos;

import alararestaurant.util.LocalDateTimeAdapter;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;
import java.util.List;

@XmlRootElement(name = "order")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderSeedDto {
    @XmlElement
    private String customer;
    @XmlElement
    private String employee;
    @XmlElement(name = "date-time")
    @XmlJavaTypeAdapter(value = LocalDateTimeAdapter.class,type = LocalDateTimeAdapter.class)
    private LocalDateTime dateTime;
    @XmlElement
    private String type;
    @XmlElement(name = "items")
    private ItemSeedRootDto items;

    public OrderSeedDto() {
    }

    @NotNull
    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    @NotNull
    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    @NotNull
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @NotNull
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ItemSeedRootDto getItems() {
        return items;
    }

    public void setItems(ItemSeedRootDto items) {
        this.items = items;
    }
}

