package spand0x;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ArticlesVersionTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<ArticleTwo> articleList = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        for(int i = 0; i < n; i++){
            String[] data = scanner.nextLine().split(", ");
            ArticleTwo article = new ArticleTwo(data[0],data[1],data[2]);
            articleList.add(article);
        }
        String input = scanner.nextLine();
        switch (input){
            case "title":
                articleList.stream().sorted(Comparator.comparing(ArticleTwo::getTitle))
                        .forEach(element -> System.out.printf("%s - %s: %s\n",element.getTitle(),element.getContent(),element.getAuthor()));
                break;
            case "content":
                articleList.stream().sorted(Comparator.comparing(ArticleTwo::getContent))
                        .forEach(element -> System.out.printf("%s - %s: %s\n",element.getTitle(),element.getContent(),element.getAuthor()));
                break;
            case "author":
                articleList.stream().sorted(Comparator.comparing(ArticleTwo::getAuthor))
                        .forEach(element -> System.out.printf("%s - %s: %s\n",element.getTitle(),element.getContent(),element.getAuthor()));
                break;
        }


    }
}

class ArticleTwo{
    private String title;
    private String content;
    private String author;

    public ArticleTwo(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }
}
