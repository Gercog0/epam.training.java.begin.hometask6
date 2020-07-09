package by.training.homework6.dao;

import by.training.homework6.model.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookListDao {
    Optional<Book> findById(String id);

    List<Book> findByTitle(String title);

    List<Book> findByAuthor(String author);

    List<Book> findByQuantityPages(int quantity);

    List<Book> findByYear(int year);

    List<Book> findByPrice(double price);

    List<Book> sortById();

    List<Book> sortByTitle();

    List<Book> sortByAuthor();

    List<Book> sortByQuantityPages();

    List<Book> sortByYear();

    List<Book> sortByPrice();
}
