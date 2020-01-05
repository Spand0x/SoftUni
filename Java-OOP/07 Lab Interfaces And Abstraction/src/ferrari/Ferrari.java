package ferrari;

public class Ferrari implements Car {
    private String driverName;
    private String model = "488-Spider";

    public Ferrari(String driverName) {
        this.driverName = driverName;
    }

    public String gas(){
        return "brum-brum-brum-brrrrr";
    }

    @Override
    public String brakes(){
        return Car.super.brakes();
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s",this.model,brakes(),this.gas(),this.driverName);
    }
}
