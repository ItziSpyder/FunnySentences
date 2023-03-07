package io.github.itzispyder.funnysentences;

import io.github.itzispyder.funnysentences.commands.Commands;
import io.github.itzispyder.funnysentences.registry.ConfigurationRegistry;
import io.github.itzispyder.funnysentences.scheduler.ScheduledTask;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;

/**
 * Mod initializer and main class
 */
public final class FunnySentences implements ModInitializer {

    public static final String prefix = "[FunnySentences] ";
    public static final String starter = "§7[§bFunny§3Sentences§7] ";
    public static final String modId = "fs";
    public static final MinecraftClient mc = MinecraftClient.getInstance();

    @Override
    public void onInitialize() {
        // Mod startup logic
        System.out.println(prefix + "Enabling and Initializing...");
        new ScheduledTask(() -> {
            Commands.registerAll();
            ConfigurationRegistry.registerAll();
        }).runTask();

    }
}
