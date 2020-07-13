package by.training.homework6.controller.command;


import by.training.homework6.controller.command.impl.*;

public enum CommandType {
    ADD_BOOK {
        {
            this.command = new AddBookCommand();
        }
    },
    DELETE_BOOK {
        {
            this.command = new DeleteBookCommand();
        }
    },
    FIND_BY_ID {
        {
            this.command = new FindByIdCommand();
        }
    },
    SEARCH_BY_TAG {
        {
            this.command = new SearchByTagCommand();
        }
    },
    SORT_BY_TAG {
        {
            this.command = new SortByTagCommand();
        }
    };

    Command command;
    public Command getCommand() {
        return command;
    }
}
