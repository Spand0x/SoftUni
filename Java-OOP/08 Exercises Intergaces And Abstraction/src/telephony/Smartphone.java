package telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        for (String site :
                urls) {
            if (!site.matches("[^\\d]+")) {
                sb.append("Invalid URL!");
            } else {
                sb.append(Browsable.super.browse()).append(site).append("!");
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        for (String number :
                numbers) {
            if (!number.matches("[^\\D]+")) {
                sb.append("Invalid number!");
            } else {
                sb.append(Callable.super.call()).append(number);
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
