package by.training.homework6.controller.command.impl;

import by.training.homework6.comparator.ComparatorType;
import by.training.homework6.controller.command.Command;
import by.training.homework6.exception.ServiceException;
import by.training.homework6.exception.UserException;
import by.training.homework6.model.entity.Book;
import by.training.homework6.model.service.BookOperationService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortByTagCommand implements Command {
    private static final int QUANTITY_PARAMETERS_TO_SORT = 1;
    private static final String SUCCESSFUL_REPLY = "SUCCESSFUL SORT";
    private static final String UNSUCCESSFUL_REPLY = "UNSUCCESSFUL SORT";

    @Override
    public Map<String, String> execute(String... parameters) throws UserException {
        if (parameters == null || parameters.length != QUANTITY_PARAMETERS_TO_SORT) {
            throw new UserException("Incorrect data...");
        }
        BookOperationService service = BookOperationService.createInstance();
        Map<String, String> reply = new HashMap<>();

        String comparatorTypeName = parameters[0];
        ComparatorType currentComparator =
                ComparatorType.getComparatorTypeByName(comparatorTypeName);

        try {
            List<Book> sortedList = service.sortByTag(currentComparator.getComparator());
            reply.put(SUCCESSFUL_REPLY, sortedList.toString());
        } catch (ServiceException exp) {
            reply.put(exp.getMessage(), UNSUCCESSFUL_REPLY);
        }
        return reply;
    }
}
