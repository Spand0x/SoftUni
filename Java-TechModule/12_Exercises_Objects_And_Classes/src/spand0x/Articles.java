package spand0x;

import java.util.Scanner;

public class Articles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] rawArticle = scanner.nextLine().split(", ");
        Article article = new Article(rawArticle[0], rawArticle[1], rawArticle[2]);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(": ");
            switch (input[0]) {
                case "Edit":
                    article.edit(input[1]);
                    break;
                case "ChangeAuthor":
                    article.changeAuthor(input[1]);
                    break;
                case "Rename":
                    article.rename(input[1]);
                    break;
            }

        }
        System.out.println(article.toString());

    }
}

class Article {
    private String title;
    private String content;
    private String author;

    public Article(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void edit(String newContent) {
        this.content = newContent;
    }

    public void changeAuthor(String newAuthor) {
        this.author = newAuthor;
    }

    public void rename(String newTitile) {
        this.title = newTitile;
    }

    @Override
    public String toString() {
        String print = this.title + " - " + this.content + ": " + this.author;
        return print;
    }
}
