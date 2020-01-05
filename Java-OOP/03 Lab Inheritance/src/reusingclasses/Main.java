package reusingclasses;

public class Main {
    public static void main(String[] args) {
//        RandomArrayList<Integer> arrayList = new RandomArrayList<>();
//        arrayList.add(1);
//        arrayList.add(2);
//        arrayList.add(3);
//        arrayList.add(4);
//        System.out.println(arrayList.getRandomElement());

        StackOfStrings stackOfStrings = new StackOfStrings();
        stackOfStrings.push("one");
        stackOfStrings.push("two");
        stackOfStrings.push("three");

        System.out.println(stackOfStrings.isEmpty());
        System.out.println(stackOfStrings.peek());

        System.out.println(stackOfStrings.pop());
        System.out.println(stackOfStrings.pop());
        System.out.println(stackOfStrings.pop());
    }
}
