package by.training.homework6.model.entity;

import by.training.homework6.exception.UserException;

import java.util.ArrayList;
import java.util.List;

public class BookLibrary {
    private List<Book> books;

    private static BookLibrary instance;
    private static final int MAX_CAPACITY = 100;

    private BookLibrary() {
        this.books = new ArrayList<>();
    }

    public static BookLibrary createInstance() {
        if (instance == null) {
            instance = new BookLibrary();
        }
        return instance;
    }

    public List<Book> getBooks() {
        return books;
    }

    public int getSize() {
        return this.books.size();
    }

    public boolean addBook(Book book) throws UserException {
        if (book == null || books.contains(book)) {
            throw new UserException("Incorrect data or book already exist...");
        }

        if (getSize() >= MAX_CAPACITY) {
            return false;
        }

        return this.books.add(book);
    }

    public boolean deleteBook(Book book) throws UserException {
        if (!this.books.contains(book)) {
            throw new UserException("There is no such book...");
        }
        return books.remove(book);
    }
}
