package entities.ingredients;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "AM")
public class AmmoniumChloride extends BasicChemicalIngredient {
    private static final String NAME = "Mint";
    private static final BigDecimal PRICE = new BigDecimal("3.54");
    private static final String FORMULA = "NH4Cl";

    public AmmoniumChloride(){
        super(NAME,PRICE,FORMULA);
    }
}
