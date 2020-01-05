package spand0x;

import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        boolean length = checkPassLength(password);
        boolean lettersAndDigits = checkLettersAndDigits(password);
        boolean checkDigits = checkAtleastTwoDigits(password);
        if(length && lettersAndDigits && checkDigits){
            System.out.println("Password is valid");
        }
    }
    private static boolean checkPassLength(String password){
        if(password.length()>=6 && password.length()<=10){
            return true;
        }else{
            System.out.println("Password must be between 6 and 10 characters");
            return false;
        }
    }

    private static boolean checkLettersAndDigits(String password){ //fix
        for(int i = 0; i < password.length(); i++) {


            if (!Character.isLetterOrDigit(password.charAt(i))) {
                System.out.println("Password must consist only of letters and digits");
                return false;
            }
        }
        return true;
    }


    private static boolean checkAtleastTwoDigits(String password){
        int countDigits = 0;
        for(int i = 0; i < password.length(); i++){
            if(password.charAt(i)>=48 && password.charAt(i)<=57){
                countDigits++;
            }
        }
        if(countDigits>=2){
            return true;
        }else {
            System.out.println("Password must have at least 2 digits");
            return false;
        }
    }
}
