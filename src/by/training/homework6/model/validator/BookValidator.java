package by.training.homework6.model.validator;

import by.training.homework6.exception.UserException;

import java.util.Arrays;

public class BookValidator {
    private static final String SPACE = " ";

    public boolean validateAuthor(String author) throws UserException {
        if (author == null) {
            throw new UserException("Incorrect data...");
        }
        String[] nameSurname = author.split(SPACE);
        for (String part : nameSurname) {
            char[] letters = part.toCharArray();
            System.out.println(Arrays.toString(letters));
            for (char letter : letters) {
                if (!Character.isAlphabetic(letter)) {
                    return false;
                }

            }
        }
        return true;
    }
}
