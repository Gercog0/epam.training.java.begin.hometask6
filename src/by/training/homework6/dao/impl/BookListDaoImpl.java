package by.training.homework6.dao.impl;

import by.training.homework6.dao.BookListDao;
import by.training.homework6.model.entity.Book;
import by.training.homework6.model.entity.BookLibrary;
import by.training.homework6.exception.UserException;

import java.util.*;

public class BookListDaoImpl implements BookListDao {
    @Override
    public Optional<Book> findById(String id){
        List<Book> books = BookLibrary.createInstance().getBooks();
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return Optional.of(book);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Book> findByTitle(String title){
        List<Book> books = BookLibrary.createInstance().getBooks();
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                books.add(book);
            }
        }
        return books;
    }

    @Override
    public List<Book> findByAuthor(String author){
        List<Book> books = BookLibrary.createInstance().getBooks();
        for (Book book : books) {
            ArrayList<String> authors = (ArrayList<String>) book.getAuthors();
            for (String currentAuthor : authors) {
                if (currentAuthor.equals(author)) {
                    books.add(book);
                    break;
                }
            }
        }
        return books;
    }

    @Override
    public List<Book> findByQuantityPages(int quantity) {
        List<Book> books = BookLibrary.createInstance().getBooks();
        for (Book book : books) {
            if (book.getQuantityPages() == quantity) {
                books.add(book);
            }
        }
        return books;
    }

    @Override
    public List<Book> findByYear(int year) {
        List<Book> books = BookLibrary.createInstance().getBooks();
        for (Book book : books) {
            if (book.getYear() == year) {
                books.add(book);
            }
        }
        return books;
    }

    @Override
    public List<Book> findByPrice(double price) {
        List<Book> books = BookLibrary.createInstance().getBooks();
        for (Book book : books) {
            if (Double.compare(book.getPrice(), price) == 0) {
                books.add(book);
            }
        }
        return books;
    }

    @Override
    public List<Book> sortById() {
        List<Book> books = BookLibrary.createInstance().getBooks();
        books.sort(Comparator.comparing(Book::getId));
        return books;
    }

    @Override
    public List<Book> sortByTitle() {
        List<Book> books = BookLibrary.createInstance().getBooks();
        books.sort(Comparator.comparing(Book::getTitle));
        return books;
    }

    @Override
    public List<Book> sortByAuthor() {
        List<Book> books = BookLibrary.createInstance().getBooks();
        books.sort(Comparator.comparing(object -> object.getAuthors().get(0)));
        return books;
    }

    @Override
    public List<Book> sortByQuantityPages() {
        List<Book> books = BookLibrary.createInstance().getBooks();
        books.sort(Comparator.comparing(Book::getQuantityPages));
        return books;
    }

    @Override
    public List<Book> sortByYear() {
        List<Book> books = BookLibrary.createInstance().getBooks();
        books.sort(Comparator.comparing(Book::getYear));
        return books;
    }

    @Override
    public List<Book> sortByPrice() {
        List<Book> books = BookLibrary.createInstance().getBooks();
        books.sort(Comparator.comparing(Book::getPrice));
        return books;
    }
}
