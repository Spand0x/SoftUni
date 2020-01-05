package pizzacalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;
    private FlourType flourTypeEnum;
    private BakingTechnique bakingTechniqueEnum;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    public double calculateCalories(){
        return 2*this.weight * this.flourTypeEnum.getModifier() * this.bakingTechniqueEnum.getModifier();
//        double calories = 0;
//        if(this.floutType.equalsIgnoreCase("White")){
//            calories = (2*this.weight) * 1.5;
//        }else if(this.floutType.equalsIgnoreCase("Wholegrain")){
//            calories = (2*this.weight) * 1.0;
//        }
//        if(this.bakingTechnique.equalsIgnoreCase("Crispy")){
//            calories *= 0.9;
//        }else if (this.bakingTechnique.equalsIgnoreCase("Chewy")){
//            calories *= 1.1;
//        }else if(this.bakingTechnique.equalsIgnoreCase("Homemade")) {
//            calories *= 1.0;
//        }
//
//        return calories;
    }

    private void setFlourType(String flourType) {
        boolean contains = false;
        for (FlourType type :
                FlourType.values()) {
            if(type.name().equals(flourType)){
                this.flourTypeEnum = type;
                contains = true;
            }
        }
        if(!contains){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;


//        if(floutType.equalsIgnoreCase("White") ||
//                floutType.equalsIgnoreCase("Wholegrain")){
//            this.floutType = floutType;
//        }else {
//            throw new IllegalArgumentException("Invalid type of dough.");
//        }
    }

    private void setBakingTechnique(String bakingTechnique) {
        boolean contains = false;
        for (BakingTechnique technique :
                BakingTechnique.values()) {
            if (technique.name().equals(bakingTechnique)){
                this.bakingTechniqueEnum = technique;
                contains = true;
            }
        }

        if(!contains){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;


//        if(bakingTechnique.equalsIgnoreCase("Crispy") ||
//                bakingTechnique.equalsIgnoreCase("Chewy") ||
//                bakingTechnique.equalsIgnoreCase("Homemade")){
//            this.bakingTechnique = bakingTechnique;
//        }else {
//            throw new IllegalArgumentException("Invalid type of dough.");
//        }
    }

    private void setWeight(double weight) {
        if(weight<1 || weight>200){
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }
}
