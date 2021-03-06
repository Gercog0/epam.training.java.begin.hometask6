package by.training.homework6.controller;

import by.training.homework6.controller.command.Command;
import by.training.homework6.controller.command.CommandType;
import by.training.homework6.controller.command.impl.EmptyCommand;
import by.training.homework6.exception.UserException;

public class CommandProvider {
    public Command provideCommand(String command) throws UserException {
        if (command == null) {
            throw new UserException("Incorrect data...");
        }
        Command currentCommand;
        if (command.isEmpty()) {
            return new EmptyCommand();
        }

        try {
            currentCommand = CommandType.valueOf(command.toUpperCase()).getCommand();
        } catch (IllegalArgumentException exp) {
            throw new UserException(exp);
        }
        return currentCommand;
    }
}
