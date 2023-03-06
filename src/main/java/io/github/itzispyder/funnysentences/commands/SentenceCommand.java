package io.github.itzispyder.funnysentences.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;

import static com.mojang.brigadier.Command.SINGLE_SUCCESS;
import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.literal;

/**
 * Sentence "/?sentence"
 */
public class SentenceCommand {

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, CommandRegistryAccess commandRegistryAccess, CommandManager.RegistrationEnvironment registrationEnvironment) {
        dispatcher.register(literal("?fs").then(literal("send").then(argument("amount",IntegerArgumentType.integer()).executes(context -> {
            ServerPlayerEntity p = context.getSource().getPlayer();
            if (p == null) return SINGLE_SUCCESS;
            return SINGLE_SUCCESS;
        }))));
    }
}
