package by.training.homework6.model.service;

import by.training.homework6.dao.impl.BookListDaoImpl;
import by.training.homework6.exception.UserException;
import by.training.homework6.model.entity.Book;

import java.util.List;
import java.util.Optional;

public class SearchBookService {
    public Optional<Book> findById(String id) throws UserException {
        if (id == null) {
            throw new UserException("Incorrect data...");
        }
        return new BookListDaoImpl().findById(id);
    }

    public List<Book> findByTitle(String title) throws UserException {
        if (title == null) {
            throw new UserException("Incorrect data...");
        }
        return new BookListDaoImpl().sortByTitle();
    }

    public List<Book> findByAuthor(String author) throws UserException {
        if (author == null) {
            throw new UserException("Incorrect data...");
        }
        return new BookListDaoImpl().sortByAuthor();
    }
}
