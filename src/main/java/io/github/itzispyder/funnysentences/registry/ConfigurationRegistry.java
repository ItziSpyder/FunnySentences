package io.github.itzispyder.funnysentences.registry;

import io.github.itzispyder.funnysentences.data.Config;
import io.github.itzispyder.funnysentences.data.FileLineReader;
import io.github.itzispyder.funnysentences.data.FileLineWriter;
import io.github.itzispyder.funnysentences.data.FileValidation;
import io.github.itzispyder.funnysentences.data.sentences.SentenceComponent;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Registers configurations
 */
public abstract class ConfigurationRegistry {

    /**
     * Loops through all sentence components and registers
     * them each
     */
    public static void registerAll() {
        for (SentenceComponent component : SentenceComponent.values()) {
            register(component);
        }
    }

    /**
     * Registers a component with its config
     * Creates a new file automatically if it does not exist
     * and the default will be show inside the config.
     * @param component sentence component
     */
    public static void register(SentenceComponent component) {
        String name = component.name().toLowerCase().trim();
        File file = new File("FunnySentences/" + name + ".config");
        FileValidation.validate(file);
        FileLineReader reader = new FileLineReader(file);
        if (reader.readLines().isEmpty()) {
            FileLineWriter writer = new FileLineWriter(file);
            writer.writeLines(component.getDefaults());
        }
        List<String> list = new ArrayList<>();
        reader.readLines().forEach(l -> {
            for (String word : l.split(","))
                list.add(word.trim());
        });
        Config.updateSentenceComponent(component,list);
    }
}
