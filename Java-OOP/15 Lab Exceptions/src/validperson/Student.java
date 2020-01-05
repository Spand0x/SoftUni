package validperson;

public class Student {
    private String name;
    private String email;

    public Student(String name, String email) {
        this.setName(name);
        this.setEmail(email);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        char[] charName = name.toCharArray();
        for (int i = 0; i < charName.length; i++) {
            if(Character.isLetter(charName[i])){
                throw new InvalidPersonNameException();
            }
        }
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
