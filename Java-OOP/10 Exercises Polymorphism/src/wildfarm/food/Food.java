package wildfarm.food;

public abstract class Food {
    private int quantity;

    public Food(int quantity) {
        this.quantity = quantity;
    }

    public int getFoodQuantity() {
        return this.quantity;
    }
}
