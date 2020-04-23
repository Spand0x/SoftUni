package entities.ingredients;

import javax.persistence.Column;
import java.math.BigDecimal;

public abstract class BasicChemicalIngredient extends BasicIngredient implements ChemicalIngredient{
    private String chemicalFormula;

    protected BasicChemicalIngredient(){}

    protected BasicChemicalIngredient(String name, BigDecimal price,String chemicalFormula){
        super(name,price);
        setChemicalFormula(chemicalFormula);
    }

    @Override
    @Column(name = "chemical_formula")
    public String getChemicalFormula() {
        return chemicalFormula;
    }

    @Override
    public void setChemicalFormula(String chemicalFormula) {
        this.chemicalFormula = chemicalFormula;
    }
}
