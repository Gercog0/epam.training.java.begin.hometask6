package by.training.homework6.util;

import java.util.UUID;

public class IdGenerator {
    private static UUID newId;

    private IdGenerator() {
    }

    public static String createId() {
        newId = UUID.randomUUID();
        return newId.toString();
    }
}
