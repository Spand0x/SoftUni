package com.spand0x.PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Point bottomLeft = new Point(input[0],input[1]);
        Point topRight = new Point(input[2],input[3]);
        Rectangle rectangle = new Rectangle(bottomLeft,topRight);
        int size = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < size; i++) {
            int[] points = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println(rectangle.contains(new Point(points[0], points[1])));
        }
    }
}
