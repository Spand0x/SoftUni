package entities.shampoos;

import entities.Size;
import entities.labels.BasicLabel;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "Pink Panther")
public class PinkPanther extends BasicShampoo {
    private static final String BRAND = "Pink Panther";

    private static final BigDecimal PRICE = new BigDecimal("8.50");
    public static final Size SIZE = Size.MEDIUM;

    public PinkPanther() {
    }

    public PinkPanther(BasicLabel classicalLabel){
        super(BRAND,PRICE,SIZE,classicalLabel);
    }
}
