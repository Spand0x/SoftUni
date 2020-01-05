package com.spand0x.HotelReservation;

public class PriceCalculator {

    enum Season{
        Autumn(1),Spring(2),Winter(3),Summer(4);

        private int value;

        Season(int value){
            this.value = value;
        }

        public int getValue(){
            return this.value;
        }
    }

    enum Discount{
        VIP(20),SecondVisit(10),None(0);

        private int value;

        Discount(int value){
            this.value = value;
        }
        public int getValue(){
            return this.value;
        }
    }

    public static double calculatePrice(double pricePerDay, int days, Season season, Discount discount){
        double price = 0;
        int multiplier = season.getValue();
        double discounted = discount.getValue() / 100.0;
        price = pricePerDay * days * multiplier;
        double afterDiscount = price * discounted;
        return price - afterDiscount;
    }


}
