package spaceStation.models.astronauts;

public class Biologist extends BaseAstronaut {
    private static final double INITIAL_OXYGEN = 70;

    public Biologist(String name) {
        super(name, INITIAL_OXYGEN);
    }

    @Override
    public void breath() {
        if(super.getOxygen()-5<0){
            super.setOxygen(0);
        }else {
            super.setOxygen(super.getOxygen()-5);
        }
    }
}
