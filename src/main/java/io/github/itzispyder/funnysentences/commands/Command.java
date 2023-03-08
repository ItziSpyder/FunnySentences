package io.github.itzispyder.funnysentences.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.command.CommandRegistryAccess;

/**
 * Command
 */
public abstract class Command {

    public static final int SINGLE_SUCCESS = 1;
    public static final int COMMAND_FAIL = -1;
    public static final int COMMAND_PASS = 0;

    /**
     * On command run
     * @param dispatcher command dispatcher
     * @param access accessor
     */
    public abstract void onCommand(CommandDispatcher<FabricClientCommandSource> dispatcher, CommandRegistryAccess access);

    /**
     * Command literal argument builder
     * @param name name
     * @return argument builder
     */
    public static LiteralArgumentBuilder<FabricClientCommandSource> literal(String name) {
        return LiteralArgumentBuilder.literal(name);
    }

    /**
     * Command required argument builder
     * @param name name
     * @param type argument type
     * @return argument builder
     * @param <T> argument object
     */
    public static <T> RequiredArgumentBuilder<FabricClientCommandSource,T> argument(String name, ArgumentType<T> type) {
        return RequiredArgumentBuilder.argument(name, type);
    }
}
