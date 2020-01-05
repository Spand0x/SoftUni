import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        String usernameReverse = "";
        String password = scanner.nextLine();
        int count = 0;

        for (int i = 1; i <= username.length(); i++) {
            usernameReverse = usernameReverse + username.charAt(username.length() - i);
        }
        while (!password.equals(usernameReverse)) {
            if (count == 3) {
                System.out.println("User " + username + " blocked!");
                break;
            }
            System.out.println("Incorrect password. Try again.");
            password = scanner.nextLine();
            count++;
        }
        if (password.equals(usernameReverse)) {
            System.out.println("User " + username + " logged in.");
        }
    }
}
