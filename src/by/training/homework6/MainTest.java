package by.training.homework6;

import by.training.homework6.dao.impl.BookListDaoImpl;
import by.training.homework6.model.entity.Book;
import by.training.homework6.model.entity.BookLibrary;
import by.training.homework6.exception.UserException;
import by.training.homework6.model.validator.BookValidator;

import java.util.ArrayList;
import java.util.Arrays;

public class MainTest {
    public static void main(String[] args) throws UserException {
        BookValidator validator =  new BookValidator();
        System.out.println(validator.validateAuthor("Igor Nikolaevich"));
        System.out.println(validator.validateAuthor("ig3or Nikolaevich"));
        System.out.println(validator.validateAuthor("igor niko9laevich"));
        //Book book = new Book("gnom", new ArrayList<String>(Arrays.asList("Igor", "Max")), 500, 2020, 160.90);
        //Book book1 = new Book("gosha", new ArrayList<String>(Arrays.asList("Alex", "John")), 700, 2020, 620.90);
        //Book book2 = new Book("lucki", new ArrayList<String>(Arrays.asList("Pizhon", "Egor")), 100, 2020, 1360.90);
        //Book book3 = new Book("ale", new ArrayList<String>(Arrays.asList("Stas", "Grisha")), 10, 2020, 6340.90);
        //Book book4 = new Book("boook", new ArrayList<String>(Arrays.asList("Lena", "Kolya")), 300, 2020, 1160.90);
        //Book book5 = new Book("yax", new ArrayList<String>(Arrays.asList("Petr", "Sasha")), 400, 2020, 61432541.90);
        //BookLibrary bl = BookLibrary.createInstance();
        //bl.addBook(book);
        //bl.addBook(book1);
        //bl.addBook(book2);
        //bl.addBook(book3);
        //bl.addBook(book4);
        //bl.addBook(book5);
        //BookListDaoImpl dao =  new BookListDaoImpl();
//
        //System.out.println(dao.sortByPrice());
    }
}
