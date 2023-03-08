package io.github.itzispyder.funnysentences.commands;

import com.mojang.brigadier.CommandDispatcher;
import io.github.itzispyder.funnysentences.util.ChatUtils;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.command.CommandRegistryAccess;

import static com.mojang.brigadier.Command.SINGLE_SUCCESS;
import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.literal;

/**
 * Command "fs:help"
 */
public class HelpCommand {

    public static void register(CommandDispatcher<FabricClientCommandSource> dispatcher, CommandRegistryAccess registryAccess) {
        dispatcher.register(literal("fs:help").executes(cxt -> {
            ChatUtils.sendMessage("""
                    §           
                    § §7[§bFunny§3Sentences§7]
                    § §f /fs:sent create §7-creates sentence
                    § §f /fs:sent custom §7-custom word count
                    § §f /fs:sent spam   §7-spams sentences
                    § §f /fs:spam        §7-spams messages
                    § §f /fs:help        §7-command help
                    §                        
                    """);
            return SINGLE_SUCCESS;
        }));
    }
}
