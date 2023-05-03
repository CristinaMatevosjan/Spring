package aop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Book {
    @Value("Преступление и наказание")
    private String name;
    @Value(" ф м Достоевский")
    private String author;
    @Value("1866")
    private int yarsOfPublication;

    public String getAuthor() {
        return author;
    }

    public int getYarsOfPublication() {
        return yarsOfPublication;
    }

    public String getName() {
        return name;
    }
}
