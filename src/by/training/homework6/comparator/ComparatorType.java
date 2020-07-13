package by.training.homework6.comparator;

import by.training.homework6.model.entity.Book;

import java.util.Comparator;

public enum ComparatorType {
    TITLE(new BookTitleComparator()),
    PAGES(new BookPagesComparator()),
    YEAR(new BookYearComparator()),
    PRICE(new BookPriceComparator()),
    AUTHOR(new BookAuthorComparator());

    private final Comparator<Book> comparator;

    ComparatorType(Comparator<Book> type) {
        this.comparator = type;
    }

    public Comparator<Book> getComparator() {
        return comparator;
    }

}
