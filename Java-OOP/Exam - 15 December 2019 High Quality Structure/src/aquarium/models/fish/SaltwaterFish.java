package aquarium.models.fish;

public class SaltwaterFish extends BaseFish {
    private static final int SIZE = 5;

    public SaltwaterFish(String name, String species, double price) {
        super(name, species, price);
        super.setSize(SIZE);
    }

    @Override
    public void eat() {
        super.setSize(super.getSize()+2);
    }
}
