package io.github.itzispyder.funnysentences.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import io.github.itzispyder.funnysentences.scheduler.ScheduledTask;
import io.github.itzispyder.funnysentences.util.ChatUtils;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.command.CommandRegistryAccess;

import static com.mojang.brigadier.Command.SINGLE_SUCCESS;
import static io.github.itzispyder.funnysentences.FunnySentences.starter;
import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.argument;
import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.literal;

/**
 * Command "fs:spam"
 */
public class SpamCommand {

    public static void register(CommandDispatcher<FabricClientCommandSource> dispatcher, CommandRegistryAccess registryAccess) {
        dispatcher.register(literal("fs:spam").then(argument("amount",IntegerArgumentType.integer()).then(argument("message", StringArgumentType.greedyString()).executes(cxt -> {
            String message = cxt.getArgument("message",String.class);
            int amount = cxt.getArgument("amount",Integer.class);
            if (amount >= 100) amount = 100;
            ChatUtils.sendMessage(starter + "§cYour amount was set to 100 due to being too high for safety reasons!");
            new ScheduledTask(() -> {
                ChatUtils.sendChatMessage(message);
            }).runRepeatingTask(amount,1);
            return SINGLE_SUCCESS;
        }))));
    }
}
