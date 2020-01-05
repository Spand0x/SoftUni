package com.spand0x.HotelReservation;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        double pricePerDay = Double.parseDouble(input[0]);
        int days = Integer.parseInt(input[1]);
        PriceCalculator.Season season = PriceCalculator.Season.valueOf(input[2]);
        PriceCalculator.Discount discount = PriceCalculator.Discount.valueOf(input[3]);
        NumberFormat formatter = new DecimalFormat("#0.00");

        System.out.println(formatter.format(PriceCalculator.calculatePrice(pricePerDay,days,season,discount)));
    }
}
