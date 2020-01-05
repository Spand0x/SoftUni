package shoppingspree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] peopleAndMoney = scanner.nextLine().split(";");
        String[] prodAndCost = scanner.nextLine().split(";");
        Map<String,Person> people = new LinkedHashMap<>();
        Map<String,Product> products = new LinkedHashMap<>();
        for (String personAndMoney :
                peopleAndMoney) {
            String personInput = personAndMoney.split("=")[0];
            double money = Double.parseDouble(personAndMoney.split("=")[1]);
            try{
                Person person = new Person(personInput,money);
                people.put(personInput,person);
            }catch (Exception ex){
                System.out.println(ex.getMessage());
                return;
            }
        }

        for (String productAndCost :
                prodAndCost) {
            String productInput = productAndCost.split("=")[0];
            double cost = Double.parseDouble(productAndCost.split("=")[1]);
            try{
                Product product = new Product(productInput,cost);
                products.put(productInput,product);
            }catch (Exception ex){
                System.out.println(ex.getMessage());
                return;
            }
        }

        String input = scanner.nextLine();
        while (!"END".equalsIgnoreCase(input)){
            String inputPerson = input.split(" ")[0];
            String inputProduct = input.split(" ")[1];
            try{
                people.get(inputPerson).buyProduct(products.get(inputProduct));
                System.out.println(inputPerson + " bought " + inputProduct);
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }
            input = scanner.nextLine();
        }
        for (Map.Entry<String,Person> person :
                people.entrySet()) {
            System.out.println(person.getValue());
        }
    }
}
