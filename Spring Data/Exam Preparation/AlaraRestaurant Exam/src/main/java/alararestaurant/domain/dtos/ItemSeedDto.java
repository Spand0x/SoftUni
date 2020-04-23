package alararestaurant.domain.dtos;

import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ItemSeedDto {
    @Expose
    private String name;
    @Expose
    private BigDecimal price;
    @Expose
    private String category;

    public ItemSeedDto() {
    }

    @Length(min = 3,max = 30)
    @NotNull
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @DecimalMin(value = "0.01")
    @NotNull
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Length(min = 3,max = 30)
    @NotNull
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
