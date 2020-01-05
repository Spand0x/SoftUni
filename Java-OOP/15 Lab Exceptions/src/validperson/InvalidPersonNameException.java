package validperson;

public class InvalidPersonNameException extends RuntimeException {

    public InvalidPersonNameException(String message) {
        super(message);
    }

    public InvalidPersonNameException() {
        this("Student name cannot contain numbers or special symbols!");
    }
}
