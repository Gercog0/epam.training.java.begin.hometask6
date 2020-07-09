package by.training.homework6.model.service;

import by.training.homework6.dao.impl.BookListDaoImpl;
import by.training.homework6.model.entity.Book;

import java.util.List;

public class SortBookService {
    public List<Book> sortById() {
        return new BookListDaoImpl().sortById();
    }

    public List<Book> sortByTitle() {
        return new BookListDaoImpl().sortByTitle();
    }

    public List<Book> sortByAuthor() {
        return new BookListDaoImpl().sortByAuthor();
    }

    public List<Book> sortByQuantityPages() {
        return new BookListDaoImpl().sortByQuantityPages();
    }

    public List<Book> sortByYear() {
        return new BookListDaoImpl().sortByYear();
    }

    public List<Book> sortByPrice() {
        return new BookListDaoImpl().sortByPrice();
    }
}
