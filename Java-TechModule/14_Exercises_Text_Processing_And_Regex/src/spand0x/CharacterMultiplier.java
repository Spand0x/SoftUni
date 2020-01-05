package spand0x;

import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int sum = sumChar(input[0],input[1]);
        System.out.println(sum);

    }

    public static int sumChar(String a,String b){
        int sum = 0;
        if(a.length()>b.length()){

            for(int i = 0; i < b.length();i++){
                int temp = (int)(a.charAt(i)*b.charAt(i));
                sum+=temp;
            }

            for(int i = b.length(); i<a.length();i++){
                sum+=a.charAt(i);
            }

        }else if(b.length()>a.length()){

            for(int i = 0; i < a.length();i++){
                int temp = (int)(a.charAt(i)*b.charAt(i));
                sum+=temp;
            }

            for(int i = a.length(); i<b.length();i++){
                sum+=b.charAt(i);
            }
        }else{
            for(int i = 0; i < a.length();i++){
                int temp = (int)(a.charAt(i)*b.charAt(i));
                sum+=temp;
            }
        }
        return sum;
    }
}
