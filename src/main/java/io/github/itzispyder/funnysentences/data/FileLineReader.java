package io.github.itzispyder.funnysentences.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Returns a list array of lines in a file
 */
public class FileLineReader {

    private final File file;

    public FileLineReader(File file) {
        if (file == null || !file.exists())
            throw new IllegalArgumentException("File does not exist!");
        this.file = file;
    }

    /**
     * Returns a list of lines read in the file
     * @return string list
     */
    public List<String> readLines() {
        List<String> lines = new ArrayList<>();
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while (line != null) {
                lines.add(line);
                line = br.readLine();
            }
            br.close();
            return lines;
        }
        catch (IOException ex) {
            return lines;
        }
    }
}
