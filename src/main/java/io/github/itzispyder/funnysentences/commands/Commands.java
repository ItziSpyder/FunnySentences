package io.github.itzispyder.funnysentences.commands;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;

/**
 * Commands registry
 */
public abstract class Commands {

    /**
     * Registers all the commands from this mod
     */
    public static void registerAll() {
        CommandRegistrationCallback.EVENT.register(SentenceCommand::register);
    }
}
