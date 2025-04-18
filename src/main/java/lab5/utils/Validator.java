package lab5.utils;

import lab5.exceptions.IncorrectIdException;
import lab5.exceptions.MovieWithIdDoesNotExistsException;
import lab5.managers.CollectionManager;

public class Validator {
    public static int parseAndValidateInt(String idString) {
        try {
            if (idString == null || idString.isEmpty()) {
                throw new IncorrectIdException(idString);
            }
            int id = Integer.parseInt(idString);
            return id;
        } catch (NumberFormatException e) {
            throw new IncorrectIdException(idString, e);
        }
    }

    public static boolean movieWithIdExists(CollectionManager collectionManager, String argument) {
        int id = parseAndValidateInt(argument);
        if (collectionManager.getCollection().stream().noneMatch(movie -> movie.getId() == id)) {
            throw new MovieWithIdDoesNotExistsException(String.valueOf(id));
        }
        return true;
    }
}
