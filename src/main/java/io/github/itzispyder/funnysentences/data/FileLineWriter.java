package io.github.itzispyder.funnysentences.data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Writes a list array of lines in a file
 */
public class FileLineWriter {

    private final File file;

    public FileLineWriter(File file) {
        if (file == null || !file.exists())
            throw new IllegalArgumentException("File does not exist!");
        this.file = file;
    }

    /**
     * Writes a list of lines in the file
     * @param lines string list
     */
    public void writeLines(List<String> lines) {
        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            lines.forEach(l -> {
                try {
                    bw.write(l);
                    bw.newLine();
                }
                catch (IOException ignore) {}
            });
            bw.close();
        }
        catch (IOException ignore) {}
    }
}
