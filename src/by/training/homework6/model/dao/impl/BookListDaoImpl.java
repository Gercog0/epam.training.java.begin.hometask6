package by.training.homework6.model.dao.impl;

import by.training.homework6.exception.DaoException;
import by.training.homework6.model.dao.BookListDao;
import by.training.homework6.model.entity.Book;
import by.training.homework6.model.entity.BookLibrary;

import java.util.*;
import java.util.stream.Collectors;

public class BookListDaoImpl implements BookListDao {
    private static BookListDaoImpl instance;

    private BookListDaoImpl() {
    }

    public static BookListDaoImpl createInstance() {
        if (instance == null) {
            instance = new BookListDaoImpl();
        }
        return instance;
    }

    @Override
    public void add(Book book) throws DaoException {
        BookLibrary library = BookLibrary.createInstance();
        if (library.getBooks().contains(book)) {
            throw new DaoException("The book already exists...");
        }

        if (library.getSize() == BookLibrary.getMaxCapacity()) {
            throw new DaoException("No library space...");
        }
        library.addBook(book);
    }

    @Override
    public void delete(String id) throws DaoException {
        BookLibrary library = BookLibrary.createInstance();
        if (!library.getBooks().contains(searchByTag(Book.Tag.ID, id).get(0))) {
            throw new DaoException("There is no such book...");
        }
        library.deleteBook(id);
    }

    @Override
    public List<Book> sortByTag(Comparator<Book> type) throws DaoException {
        List<Book> books = BookLibrary.createInstance().getBooks();
        List<Book> sortedList = books.stream().sorted(type).collect(Collectors.toList());
        if (sortedList.isEmpty()) {
            throw new DaoException("Books not found...");
        }
        return sortedList;
    }

    @Override
    public List<Book> searchByTag(Book.Tag tag, String string) throws DaoException {
        List<Book> books = BookLibrary.createInstance().getBooks();
        List<Book> foundBooks = books.stream().
                filter(b -> b.getParameter(tag).contains(string)).collect(Collectors.toList());
        if (foundBooks.isEmpty()) {
            throw new DaoException("Nothing was found for the query...");
        }
        return foundBooks;
    }
}
