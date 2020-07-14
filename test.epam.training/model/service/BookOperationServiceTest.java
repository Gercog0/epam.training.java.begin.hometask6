package model.service;

import by.training.homework6.comparator.ComparatorType;
import by.training.homework6.exception.ServiceException;
import by.training.homework6.model.entity.Book;
import by.training.homework6.model.service.BookOperationService;
import model.BookLibraryDataTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.testng.Assert.*;
import static org.testng.Assert.fail;

public class BookOperationServiceTest {
    BookOperationService service;
    BookLibraryDataTest testData;

    @BeforeClass
    public void setUp() {
        service = BookOperationService.createInstance();
        testData = BookLibraryDataTest.createInstance();
    }

    @DataProvider(name = "dataSortValid")
    public Object[][] dataSortTestValid() {
        return new Object[][]{
                {ComparatorType.ID.getComparator(), testData.sortedBookListByIdValid()},
                {ComparatorType.TITLE.getComparator(), testData.sortedBookListByTitleValid()},
                {ComparatorType.AUTHORS.getComparator(), testData.sortedBookListByAuthorsValid()},
                {ComparatorType.PAGES.getComparator(), testData.sortedBookListByPagesValid()},
                {ComparatorType.YEAR.getComparator(), testData.sortedBookListByYearValid()},
                {ComparatorType.PRICE.getComparator(), testData.sortedBookListByPriceValid()},
        };
    }

    @DataProvider(name = "dataSortInvalid")
    public Object[][] dataSortTestInvalid() {
        return new Object[][]{
                {ComparatorType.ID.getComparator(), testData.sortedBookListByIdInvalid()},
                {ComparatorType.TITLE.getComparator(), testData.sortedBookListByTitleInvalid()},
                {ComparatorType.AUTHORS.getComparator(), testData.sortedBookListByAuthorsInvalid()},
                {ComparatorType.PAGES.getComparator(), testData.sortedBookListByPagesInvalid()},
                {ComparatorType.YEAR.getComparator(), testData.sortedBookListByYearInvalid()},
                {ComparatorType.PRICE.getComparator(), testData.sortedBookListByPriceInvalid()},
        };
    }

    @DataProvider(name = "dataSearchValid")
    public Object[][] dataSearchTestValid() {
        return new Object[][]{
                {Book.Tag.ID, testData.takeBookLibraryTest().getBooks().get(0).getId(), testData.searchBookById()},
                {Book.Tag.AUTHORS, "Bgor", testData.searchBookById()},
                {Book.Tag.PAGES, "500", testData.searchBookByPages()},
                {Book.Tag.YEAR, "2000", testData.searchBookByYear()},
                {Book.Tag.TITLE, "WouseWork", testData.searchBookByTitle()},
                {Book.Tag.PRICE, "160", testData.searchBookByPrice()},
        };
    }

    @DataProvider(name = "dataSearchInvalid")
    public Object[][] dataSearchTestInvalid() {
        return new Object[][]{
                {Book.Tag.ID, testData.takeBookLibraryTest().getBooks().get(1).getId(), testData.searchBookById()},
                {Book.Tag.AUTHORS, "Alex", testData.searchBookById()},
                {Book.Tag.PAGES, "110", testData.searchBookByPages()},
                {Book.Tag.YEAR, "2010", testData.searchBookByYear()},
                {Book.Tag.TITLE, "Cle", testData.searchBookByTitle()},
                {Book.Tag.PRICE, "1170", testData.searchBookByPrice()},
        };
    }

    @Test(dataProvider = "dataSortValid")
    public void sortByTagTestValid(Comparator<Book> type, List<Book> expected) {
        try {
            List<Book> actual = service.sortByTag(type);
            assertEquals(expected, actual);
        } catch (ServiceException exp) {
            fail("ServiceException...");
        }
    }

    @Test(dataProvider = "dataSortInvalid")
    public void sortByTagTestInvalid(Comparator<Book> type, List<Book> expected) {
        try {
            List<Book> actual = service.sortByTag(type);
            assertNotEquals(expected, actual);
        } catch (ServiceException exp) {
            fail("ServiceException...");
        }
    }

    @Test(expectedExceptions = ServiceException.class)
    public void sortByTagTestException() throws ServiceException {
        service.sortByTag(null);
    }

    @Test(dataProvider = "dataSearchValid")
    public void searchByTagTestValid(Book.Tag tag, String string, List<Book> expected) {
        try {
            List<Book> actual = service.searchByTag(tag, string);
            assertEquals(expected, actual);
        } catch (ServiceException exp) {
            fail("ServiceException" + exp);
        }
    }

    @Test(dataProvider = "dataSearchInvalid")
    public void searchByTagTestInvalid(Book.Tag tag, String string, List<Book> expected) {
        try {
            List<Book> actual = service.searchByTag(tag, string);
            assertNotEquals(expected, actual);
        } catch (ServiceException exp) {
            fail("ServiceException");
        }
    }

    @Test(expectedExceptions = ServiceException.class)
    public void searchByTagTestException() throws ServiceException {
        service.searchByTag(Book.Tag.AUTHORS, null);
    }


    @Test(expectedExceptions = ServiceException.class)
    public void addBookTestException() throws ServiceException {
        service.addBook("Hello", new ArrayList<>(), 0, 0, 90);
    }

    @Test(expectedExceptions = ServiceException.class)
    public void deleteBookTestException() throws ServiceException {
        service.deleteBook(null);
    }

    @AfterClass
    public void tierDown() {
        service = null;
        testData = null;
    }
}
