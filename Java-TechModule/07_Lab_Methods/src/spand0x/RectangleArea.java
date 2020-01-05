package spand0x;

import java.util.Scanner;

public class RectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int area = calculArea(a, b);
        System.out.println(area);
    }

    private static int calculArea(int a, int b) {
        return a*b;
    }
}
