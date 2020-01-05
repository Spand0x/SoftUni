package animals;

public class Kitten extends Cat {
    private final String gender = "Female";


    public Kitten(String name, int age) {
        super(name, age, "Female");
    }

    @Override
    public String produceSound() {
        return "Meow";
    }
}
