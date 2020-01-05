package spand0x;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class HTML {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String title = scanner.nextLine();
        String article = scanner.nextLine();
        List<String> comments = new LinkedList<String>();
        String input = scanner.nextLine();
        while(!"end of comments".equalsIgnoreCase(input)){
            comments.add(input);
            input = scanner.nextLine();

        }

        System.out.println("<h1>");
        System.out.println("    "+title);
        System.out.println("</h1>");
        System.out.println("<article>\n    "+article+"\n</article>");
        for(int i = 0; i < comments.size(); i++){
            System.out.println("<div>\n    "+comments.get(i)+"\n</div>");
        }
    }
}
