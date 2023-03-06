package io.github.itzispyder.funnysentences;

import net.fabricmc.api.ModInitializer;

/**
 * Mod initializer and main class
 */
public final class FunnySentences implements ModInitializer {

    public static final String starter = "[FunnySentences] ";

    @Override
    public void onInitialize() {
        // Mod startup logic
        System.out.println(starter + "Enabling and Initializing...");
    }
}
