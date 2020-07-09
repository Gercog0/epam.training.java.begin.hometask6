package by.training.homework6.model.reader;

import by.training.homework6.exception.UserException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DataReader {
    public String dataReader(String fileName) throws UserException {
        if (fileName == null) {
            throw new UserException("File name is not correct...");
        }
        File file = new File(fileName);
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            while ((line != null)) {
                builder.append(line).append("\n");
                line = reader.readLine();
            }
        } catch (IOException exp) {
            throw new UserException("File not found...", exp);
        }
        return builder.toString().trim();
    }
}
