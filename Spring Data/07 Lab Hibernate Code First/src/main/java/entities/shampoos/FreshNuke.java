package entities.shampoos;

import entities.Size;
import entities.labels.BasicLabel;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "Fresh Nuke")
public class FreshNuke extends BasicShampoo {
    private static final String BRAND = "Fresh Nuke";

    private static final BigDecimal PRICE = new BigDecimal("9.33");
    public static final Size SIZE = Size.LARGE;

    public FreshNuke() {
    }

    public FreshNuke(BasicLabel classicalLabel){
        super(BRAND,PRICE,SIZE,classicalLabel);
    }
}
