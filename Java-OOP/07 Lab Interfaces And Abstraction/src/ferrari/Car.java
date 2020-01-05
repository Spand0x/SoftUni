package ferrari;

public interface Car {
    default String brakes(){
        return "Brakes!";
    }

    default String gas(){
        return "Zadu6avam sA!";
    }
}
