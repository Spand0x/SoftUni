import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double amountOfMoney = Double.parseDouble(scanner.nextLine());
        int countStudents = Integer.parseInt(scanner.nextLine());
        double priceLightsaber = Double.parseDouble(scanner.nextLine());
        double priceRobes = Double.parseDouble(scanner.nextLine());
        double priceBelts = Double.parseDouble(scanner.nextLine());
        double totalPrice = 0;
        int bonusLightSaber = countStudents + (int) Math.ceil((countStudents * 0.1));
        int countFreeBelts = 0;
        for (int i = 1; i <= countStudents; i++) {
            if (i % 6 == 0) {
                countFreeBelts++;
            }
        }
        totalPrice = ((bonusLightSaber * priceLightsaber) + (countStudents * priceRobes) + (countStudents - countFreeBelts) * priceBelts);
        if (totalPrice <= amountOfMoney) {
            System.out.printf("The money is enough - it would cost %.2flv.", totalPrice);
        } else {
            double rest = totalPrice - amountOfMoney;
            System.out.printf("Ivan Cho will need %.2flv more.", rest);
        }

    }
}
