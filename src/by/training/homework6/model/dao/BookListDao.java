package by.training.homework6.model.dao;

import by.training.homework6.comparator.ComparatorType;
import by.training.homework6.exception.DaoException;
import by.training.homework6.exception.UserException;
import by.training.homework6.model.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookListDao {
    void addBook(Book book) throws DaoException;

    void deleteBook(Book book) throws DaoException;

    Optional<Book> findById(String id);

    List<Book> sortByTag(ComparatorType type);
    List<Book> searchByTag(Book.Tag tag, String string);

   //List<Book> findByTitle(String title);

   //List<Book> findByAuthor(String author);

   //List<Book> findByQuantityPages(int quantity);

   //List<Book> findByYear(int year);

   //List<Book> findByPrice(double price);

   //List<Book> sortById();

   //List<Book> sortByTitle();

   //List<Book> sortByAuthor();

   //List<Book> sortByQuantityPages();

   //List<Book> sortByYear();

   //List<Book> sortByPrice();
}
