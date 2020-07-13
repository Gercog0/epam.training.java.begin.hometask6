package by.training.homework6.service;

import by.training.homework6.comparator.ComparatorType;
import by.training.homework6.exception.DaoException;
import by.training.homework6.exception.ServiceException;
import by.training.homework6.model.dao.impl.BookListDaoImpl;
import by.training.homework6.model.entity.Book;
import by.training.homework6.validator.BookValidator;

import java.util.List;
import java.util.Optional;

public class BookOperationService {
    private static BookOperationService instance;

    private static final String BLANK = "";

    private BookOperationService() {

    }

    public static BookOperationService createInstance() {
        if (instance == null) {
            instance = new BookOperationService();
        }
        return instance;
    }

    public void addBook(Book book) throws ServiceException {
        if (book == null) {
            throw new ServiceException("Incorrect data...");
        }
        try {
            BookListDaoImpl.createInstance().addBook(book);
        } catch (DaoException exp) {
            throw new ServiceException(exp);
        }
    }

    public void deleteBook(Book book) throws ServiceException {
        if (book == null) {
            throw new ServiceException("Incorrect data...");
        }
        try {
            BookListDaoImpl.createInstance().deleteBook(book);
        } catch (DaoException exp) {
            throw new ServiceException(exp);
        }
    }

    public Optional<Book> findById(String id) throws ServiceException {
        if (id == null) {
            throw new ServiceException("Incorrect data...");
        }
        return BookListDaoImpl.createInstance().findById(id);
    }

    public List<Book> searchByTag(Book.Tag tag, String search) throws ServiceException {
        BookValidator validator = new BookValidator();
        if (tag == null || search == null) {
            throw new ServiceException("Incorrect data");
        }
        if (validator.validateByTag(tag, search)) {
            throw new ServiceException("Error during data validation");
        }
        return BookListDaoImpl.createInstance().searchByTag(tag, search);
    }

    public List<Book> sortByTag(ComparatorType type) throws ServiceException {
        if (type == null) {
            throw new ServiceException("Incorrect data");
        }
        return BookListDaoImpl.createInstance().sortByTag(type);
    }

    //public List<Book> findByTitle(String title) throws ServiceException {
    //    BookValidator validator = new BookValidator();
//
    //    if (title == null || !validator.validateTitle(title)) {
    //        throw new ServiceException("Incorrect data...");
    //    }
    //    return BookListDaoImpl.createInstance().findByTitle(title);
    //}
//
    //public List<Book> findByAuthor(String author) throws ServiceException {
    //    BookValidator validator = new BookValidator();
//
    //    if (author == null || !validator.validateAuthor(author)) {
    //        throw new ServiceException("Incorrect data...");
    //    }
    //    return BookListDaoImpl.createInstance().findByAuthor(author);
    //}
//
    //public List<Book> findByQuantityPages(int quantity) throws ServiceException {
    //    BookValidator validator = new BookValidator();
//
    //    if (!validator.validateQuantityPages(quantity)) {
    //        throw new ServiceException("Incorrect data...");
    //    }
    //    return BookListDaoImpl.createInstance().findByQuantityPages(quantity);
    //}
//
    //public List<Book> findByYear(int year) throws ServiceException {
    //    BookValidator validator = new BookValidator();
//
    //    if (!validator.validateYear(year)) {
    //        throw new ServiceException("Incorrect data...");
    //    }
    //    return BookListDaoImpl.createInstance().findByYear(year);
    //}
//
    //public List<Book> findByPrice(double price) throws ServiceException {
    //    BookValidator validator = new BookValidator();
//
    //    if (!validator.validatePrice(price)) {
    //        throw new ServiceException("Incorrect data...");
    //    }
    //    return BookListDaoImpl.createInstance().findByPrice(price);
    //}
//
    //public List<Book> sortById() {
    //    return BookListDaoImpl.createInstance().sortById();
    //}
//
    //public List<Book> sortByTitle() {
    //    return BookListDaoImpl.createInstance().sortByTitle();
    //}
//
    //public List<Book> sortByAuthor() {
    //    return BookListDaoImpl.createInstance().sortByAuthor();
    //}
//
    //public List<Book> sortByQuantityPages() {
    //    return BookListDaoImpl.createInstance().sortByQuantityPages();
    //}
//
    //public List<Book> sortByYear() {
    //    return BookListDaoImpl.createInstance().sortByYear();
    //}
//
    //public List<Book> sortByPrice() {
    //    return BookListDaoImpl.createInstance().sortByPrice();
    //}
}
