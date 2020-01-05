package squareroot;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        try {
            double sqr = square(n);
            System.out.println(sqr);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }finally {
            System.out.println("Good bye");
        }

    }

    private static double square(int n) {
        if(n<=0){
            throw new IllegalArgumentException("Invalid number");
        }else{
            return Math.sqrt(n);
        }
    }
}
