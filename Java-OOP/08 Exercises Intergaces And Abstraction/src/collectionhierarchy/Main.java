package collectionhierarchy;

import collectionhierarchy.models.AddCollection;
import collectionhierarchy.models.AddRemoveCollection;
import collectionhierarchy.models.MyListImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyListImpl myList = new MyListImpl();

        String[] elements = scanner.nextLine().split(" ");

        for (String element : elements) {
            System.out.print(addCollection.add(element) + " ");
        }
        System.out.println();

        for (String element : elements) {
            System.out.print(addRemoveCollection.add(element) + " ");
        }
        System.out.println();

        for (String element : elements) {
            System.out.print(myList.add(element) + " ");
        }
        System.out.println();

        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {
            System.out.print(addRemoveCollection.remove() + " ");
        }
        System.out.println();
        for (int i = 0; i < count; i++) {
            System.out.print(myList.remove() + " ");
        }

    }
}
