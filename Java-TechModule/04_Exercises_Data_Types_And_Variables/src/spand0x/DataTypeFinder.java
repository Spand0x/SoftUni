package spand0x;

import java.util.Scanner;

public class DataTypeFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while(!"END".equals(input)){
            try{
            Integer.parseInt(input);
                System.out.println(input + " is integer type");
                input = scanner.nextLine();
                continue;
            }catch (Exception ignored){
            }
            try {
                Double.parseDouble(input);
                System.out.println(input + " is floating point type");
                input = scanner.nextLine();
                continue;
            }catch (Exception ignored){

            }
            if(input.toLowerCase().equals("true") || input.toLowerCase().equals("false")){
                System.out.println(input + " is boolean type");
            }else if(input.length() == 1){
                System.out.println(input + " is character type");
            }else{
                System.out.println(input + " is string type");
            }
            input = scanner.nextLine();


        }
    }
}
