package by.training.homework6.controller.command;

import by.training.homework6.exception.UserException;

import java.util.Map;

public interface Command {
    Map<String, String> execute(String... parameters) throws UserException;
}
