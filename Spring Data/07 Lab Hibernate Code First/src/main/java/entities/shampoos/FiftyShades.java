package entities.shampoos;

import entities.Size;
import entities.labels.BasicLabel;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "Fifty Shades")
public class FiftyShades extends BasicShampoo {
    private static final String BRAND = "Fifty Shades";

    private static final BigDecimal PRICE = new BigDecimal("6.69");
    public static final Size SIZE = Size.SMALL;

    public FiftyShades() {
    }

    public FiftyShades(BasicLabel classicalLabel){
        super(BRAND,PRICE,SIZE,classicalLabel);
    }
}
