package by.training.homework6.controller;

import by.training.homework6.controller.command.Command;
import by.training.homework6.controller.command.CommandType;
import by.training.homework6.controller.command.impl.EmptyCommand;
import by.training.homework6.exception.UserException;

public class CommandProvider {
    public Command provideCommand(String command) throws UserException {
        Command currentCommand = new EmptyCommand();
        if (command.isEmpty()) {
            return currentCommand;
        }

        try {
            currentCommand = CommandType.valueOf(command.toUpperCase()).getCommand();
        } catch (IllegalArgumentException exp) {
            throw new UserException(exp);
        }
        return currentCommand;
    }
}
