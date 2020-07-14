package controller.command;

import by.training.homework6.controller.command.impl.SortByTagCommand;
import by.training.homework6.exception.UserException;
import by.training.homework6.model.entity.Book;
import model.BookLibraryDataTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.*;

public class SortByTagCommandTest {
    SortByTagCommand command;
    BookLibraryDataTest dataTest;

    @BeforeClass
    public void setUp() {
        command = new SortByTagCommand();
        dataTest = BookLibraryDataTest.createInstance();
    }

    @Test
    public void executeTestValid() {
        try {
            List<Book> expectedSortList = dataTest.sortedBookListByIdValid();
            Map<String, String> expected = new HashMap<>();
            expected.put("SUCCESSFUL SORT", expectedSortList.toString());
            Map<String, String> actual = command.execute("id");
            assertEquals(expected, actual);
        } catch (UserException exp) {
            fail("UserException" + exp);
        }
    }

    @Test
    public void executeTestInvalid() {
        try {
            List<Book> expectedSortList = dataTest.sortedBookListByIdInvalid();
            Map<String, String> expected = new HashMap<>();
            expected.put("SUCCESSFUL SORT", expectedSortList.toString());
            Map<String, String> actual = command.execute("id");
            assertNotEquals(expected, actual);
        } catch (UserException exp) {
            fail("UserException" + exp);
        }
    }

    @Test(expectedExceptions = UserException.class)
    public void executeTestException() throws UserException {
        command.execute("id", "title");
    }

    @AfterClass
    public void tierDown() {
        command = null;
        dataTest = null;
    }
}
