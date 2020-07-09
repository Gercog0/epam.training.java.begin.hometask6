package by.training.homework6.model.entity;

import by.training.homework6.util.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String id;
    private String title;
    private List<String> authors;
    private int quantityPages;
    private int year;
    private double price;

    private static final String BLANK = "";

    public Book() {
        this.id = IdGenerator.createId();
        this.title = BLANK;
        this.authors = new ArrayList<>();
    }

    public Book(String title, ArrayList<String> authors,
                int quantityPages, int year, double price) {
        this.id = IdGenerator.createId();
        this.title = title;
        this.authors = authors;
        this.quantityPages = quantityPages;
        this.year = year;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public int getQuantityPages() {
        return quantityPages;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Book book = (Book) o;

        if (quantityPages != book.quantityPages || year != book.year ||
                Double.compare(book.price, price) != 0 ||
                (id != null ? !id.equals(book.id) : book.id != null) ||
                (title != null ? !title.equals(book.title) : book.title != null)) {
            return false;
        }
        return authors != null ? authors.equals(book.authors) : book.authors == null;
    }

    @Override
    public int hashCode() {
        int result;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (authors != null ? authors.hashCode() : 0);
        result = 31 * result + quantityPages;
        result = 31 * result + year;
        result = 31 * result + (int) price;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book:\n");
        sb.append("ID: ").append(id).append("\n");
        sb.append("Title: ").append(title).append("\n");
        sb.append("Authors: ").append(authors).append("\n");
        sb.append("QuantityPages: ").append(quantityPages).append("\n");
        sb.append("Year: ").append(year).append("\n");
        sb.append("Price: ").append(price).append("\n");
        return sb.toString();
    }
}
