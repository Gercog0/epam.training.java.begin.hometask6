package by.training.homework6.model.dao;

import by.training.homework6.exception.DaoException;
import by.training.homework6.model.entity.Book;

import java.util.Comparator;
import java.util.List;

public interface BookListDao {
    void add(Book book) throws DaoException;

    void delete(String id) throws DaoException;

    List<Book> sortByTag(Comparator<Book> type) throws DaoException;

    List<Book> searchByTag(Book.Tag tag, String string) throws DaoException;
}
