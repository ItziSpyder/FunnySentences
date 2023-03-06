package io.github.itzispyder.funnysentences.data;

import java.io.File;
import java.io.IOException;

/**
 * File validation
 */
public abstract class FileValidation {

    /**
     * Validate a file
     * Will create the file if the file does not exist
     * Will create the file parents if the parents do not exist
     * @param file file to validate
     */
    public static void validate(File file) {
        if (file == null) throw new IllegalArgumentException("File is null!");
        try {
            if (!file.getParentFile().exists()) file.getParentFile().mkdirs();
            if (!file.exists()) file.createNewFile();
        }
        catch (IOException ex) {
            throw  new IllegalArgumentException("File cannot be created!");
        }
    }
}
