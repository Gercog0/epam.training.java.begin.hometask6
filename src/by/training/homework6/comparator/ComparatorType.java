package by.training.homework6.comparator;

import by.training.homework6.model.entity.Book;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public enum ComparatorType {
    ID("id", ((book1, book2) -> book1.getId().compareTo(book2.getId()))),
    TITLE("title", ((book1, book2) -> book1.getTitle().compareTo(book2.getTitle()))),
    PAGES("pages", ((book1, book2) -> book1.getQuantityPages() - book2.getQuantityPages())),
    YEAR("year", ((book1, book2) -> book1.getYear() - book2.getYear())),
    PRICE("price", ((book1, book2) -> book1.getPrice() - book2.getPrice())),
    AUTHORS("authors", ((book1, book2) -> book1.getAuthors().get(0).compareTo(book2.getAuthors().get(0))));

    private final Comparator<Book> comparator;
    private final String name;

    ComparatorType(String name, Comparator<Book> type) {
        this.name = name;
        this.comparator = type;
    }

    public Comparator<Book> getComparator() {
        return comparator;
    }

    public String getName() {
        return name;
    }

    private static final Map<String, ComparatorType> LOOKUP_MAP = new HashMap<>();

    static {
        for (ComparatorType element : values()) {
            LOOKUP_MAP.put(element.getName(), element);
        }
    }

    public static ComparatorType getComparatorTypeByName(String name) {
        return LOOKUP_MAP.get(name);
    }
}
