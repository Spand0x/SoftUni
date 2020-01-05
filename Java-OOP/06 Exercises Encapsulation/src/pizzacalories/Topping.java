package pizzacalories;

public class Topping {
    private String toppingType;
    private double weight;
    private ToppingType toppingTypeEnum;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    public double calculateCalories(){
        return 2 * weight * this.toppingTypeEnum.getModifier();
    }

    private void setToppingType(String toppingType) {
        boolean contains = false;
        for (ToppingType type :
                ToppingType.values()) {
            if(type.name().equals(toppingType)){
                this.toppingTypeEnum = type;
                contains = true;
            }
        }
        if(contains){
            this.toppingType = toppingType;
        }else {
            throw new IllegalArgumentException("Cannot place "+toppingType+" on top of your pizza.");
        }
    }

    private void setWeight(double weight) {
        if(weight<1 || weight>50){
            throw new IllegalArgumentException(this.toppingType + " weight should be in the range [1..50].");
        }
        this.weight = weight;
    }
}
