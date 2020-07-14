package model;

import by.training.homework6.comparator.ComparatorType;
import by.training.homework6.model.entity.Book;
import by.training.homework6.model.entity.BookLibrary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookLibraryDataTest {
    private static BookLibraryDataTest instance;

    private BookLibrary library;

    private Book book = new Book("WouseWork", new ArrayList<String>(Arrays.asList("Bgor Govor", "Max Pan")),
            500, 2000, 160);
    private Book book1 = new Book("Asha", new ArrayList<String>(Arrays.asList("Alex Tolok", "John Peter")),
            110, 2010, 620);
    private Book book2 = new Book("Bucki", new ArrayList<String>(Arrays.asList("Cizhon Same", "Egor Fokin")),
            100, 2007, 1360);
    private Book book3 = new Book("Cle", new ArrayList<String>(Arrays.asList("Dtas Lymda", "Grisha Fin")),
            10, 1970, 6340);
    private Book book4 = new Book("Doook", new ArrayList<String>(Arrays.asList("Fena Ermolova", "Kolya Tokin")),
            300, 2019, 1170);
    private Book book5 = new Book("Tax", new ArrayList<String>(Arrays.asList("Eetr Alexander")),
            400, 2002, 7832);


    private BookLibraryDataTest() {
        library = BookLibrary.createInstance();
        loadLibrary();
    }

    public static BookLibraryDataTest createInstance() {
        if (instance == null) {
            instance = new BookLibraryDataTest();
        }
        return instance;
    }

    public BookLibrary takeBookLibraryTest() {
        return library;
    }

    public List<Book> searchBookById() {
        List<Book> foundBooks = new ArrayList<>();
        foundBooks.add(book);
        return foundBooks;
    }

    public List<Book> searchBookByTitle() {
        List<Book> foundBooks = new ArrayList<>();
        foundBooks.add(book);
        return foundBooks;
    }

    public List<Book> searchBookByAuthor() {
        List<Book> foundBooks = new ArrayList<>();
        foundBooks.add(book);
        return foundBooks;
    }

    public List<Book> searchBookByPages() {
        List<Book> foundBooks = new ArrayList<>();
        foundBooks.add(book);
        return foundBooks;
    }

    public List<Book> searchBookByYear() {
        List<Book> foundBooks = new ArrayList<>();
        foundBooks.add(book);
        return foundBooks;
    }

    public List<Book> searchBookByPrice() {
        List<Book> foundBooks = new ArrayList<>();
        foundBooks.add(book);
        return foundBooks;
    }

    public List<Book> sortedBookListByIdValid() {
        List<Book> ourLibrary = library.getBooks();
        List<Book> sortedList = new ArrayList<>(ourLibrary);
        sortedList.sort((ComparatorType.ID.getComparator()));
        return sortedList;
    }

    public List<Book> sortedBookListByTitleValid() {
        List<Book> sortedList = new ArrayList<>();
        sortedList.add(book1);
        sortedList.add(book2);
        sortedList.add(book3);
        sortedList.add(book4);
        sortedList.add(book5);
        sortedList.add(book);
        return sortedList;
    }

    public List<Book> sortedBookListByAuthorsValid() {
        List<Book> sortedList = new ArrayList<>();
        sortedList.add(book1);
        sortedList.add(book);
        sortedList.add(book2);
        sortedList.add(book3);
        sortedList.add(book5);
        sortedList.add(book4);
        return sortedList;
    }

    public List<Book> sortedBookListByPagesValid() {
        List<Book> sortedList = new ArrayList<>();
        sortedList.add(book3);
        sortedList.add(book2);
        sortedList.add(book1);
        sortedList.add(book4);
        sortedList.add(book5);
        sortedList.add(book);
        return sortedList;
    }

    public List<Book> sortedBookListByYearValid() {
        List<Book> sortedList = new ArrayList<>();
        sortedList.add(book3);
        sortedList.add(book);
        sortedList.add(book5);
        sortedList.add(book2);
        sortedList.add(book1);
        sortedList.add(book4);
        return sortedList;
    }

    public List<Book> sortedBookListByPriceValid() {
        List<Book> sortedList = new ArrayList<>();
        sortedList.add(book);
        sortedList.add(book1);
        sortedList.add(book4);
        sortedList.add(book2);
        sortedList.add(book3);
        sortedList.add(book5);
        return sortedList;
    }

    public List<Book> sortedBookListByIdInvalid() {
        List<Book> sortedList = new ArrayList<>();
        sortedList.add(book3);
        sortedList.add(book2);
        sortedList.add(book1);
        sortedList.add(book4);
        sortedList.add(book5);
        sortedList.add(book);
        return sortedList;
    }

    public List<Book> sortedBookListByTitleInvalid() {
        List<Book> sortedList = new ArrayList<>();
        sortedList.add(book3);
        sortedList.add(book2);
        sortedList.add(book1);
        sortedList.add(book4);
        sortedList.add(book5);
        sortedList.add(book);
        return sortedList;
    }

    public List<Book> sortedBookListByAuthorsInvalid() {
        List<Book> sortedList = new ArrayList<>();
        sortedList.add(book3);
        sortedList.add(book2);
        sortedList.add(book1);
        sortedList.add(book4);
        sortedList.add(book5);
        sortedList.add(book);
        return sortedList;
    }

    public List<Book> sortedBookListByPagesInvalid() {
        List<Book> sortedList = new ArrayList<>();
        sortedList.add(book1);
        sortedList.add(book2);
        sortedList.add(book4);
        sortedList.add(book3);
        sortedList.add(book5);
        sortedList.add(book);
        return sortedList;
    }

    public List<Book> sortedBookListByYearInvalid() {
        List<Book> sortedList = new ArrayList<>();
        sortedList.add(book3);
        sortedList.add(book2);
        sortedList.add(book1);
        sortedList.add(book4);
        sortedList.add(book5);
        sortedList.add(book);
        return sortedList;
    }

    public List<Book> sortedBookListByPriceInvalid() {
        List<Book> sortedList = new ArrayList<>();
        sortedList.add(book3);
        sortedList.add(book2);
        sortedList.add(book1);
        sortedList.add(book4);
        sortedList.add(book5);
        sortedList.add(book);
        return sortedList;
    }

    public void loadLibrary() {
        library.addBook(book);
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);
    }

    public void deleteLibrary() {
        library.deleteBook(book.getId());
        library.deleteBook(book1.getId());
        library.deleteBook(book2.getId());
        library.deleteBook(book3.getId());
        library.deleteBook(book4.getId());
        library.deleteBook(book5.getId());
    }
}
