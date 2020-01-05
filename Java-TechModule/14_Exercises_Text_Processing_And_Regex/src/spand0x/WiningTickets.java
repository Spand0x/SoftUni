package spand0x;

import java.util.Scanner;

public class WiningTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tickets = scanner.nextLine().split(",\\s+");

        for(String ticket: tickets){
            if(ticket.length()!=20){
                System.out.println("invalid ticket");
            }else{
                String leftHalf = ticket.substring(0,10);
                String rightHalf = ticket.substring(10,20);
                int countLeft = 1;
                int countRight = 1;
                char winningChar = ' ';
                for(int i = 1; i < 10; i++){
                    char currentLeftChar = leftHalf.charAt(i);
                    char previousLeftChar = leftHalf.charAt(i-1);

                    char currentRightChar = rightHalf.charAt(i);
                    char previousRightChar = rightHalf.charAt(i-1);
                    if(currentLeftChar=='@' && previousLeftChar == '@'){
                        countLeft++;
                        winningChar = '@';
                    }else if(currentLeftChar=='#' && previousLeftChar == '#'){
                        countLeft++;
                        winningChar = '#';
                    }else if(currentLeftChar=='$' && previousLeftChar == '$'){
                        countLeft++;
                        winningChar = '$';
                    }else if(currentLeftChar=='^' && previousLeftChar == '^'){
                        countLeft++;
                        winningChar = '^';
                    }
//                    else{
//                        if(countLeft >=6){
//
//                        }
//                    }
                    if(currentRightChar=='@' && previousRightChar == '@'){
                        countRight++;
                    }else if(currentRightChar=='#' && previousRightChar == '#'){
                        countRight++;
                    }else if(currentRightChar=='$' && previousRightChar == '$'){
                        countRight++;
                    }else if(currentRightChar=='^' && previousRightChar == '^'){
                        countRight++;
                    }
                }
                if(countLeft==countRight){
                    if(countLeft==10){
                        System.out.println("ticket \"" + ticket + "\" - " + countLeft + winningChar + "Jackpot!");
                    }else if(countLeft>=6){
                        System.out.println("ticket \"" + ticket + "\" - " + countLeft + winningChar);
                    }else{
                        System.out.println("ticket \"" + ticket + "\" - no match" );
                    }
                }

            }
        }
        System.out.println();

    }
}
