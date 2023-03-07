package io.github.itzispyder.funnysentences.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import io.github.itzispyder.funnysentences.data.sentences.SentenceConstructor;
import io.github.itzispyder.funnysentences.data.sentences.SentenceFeature;
import io.github.itzispyder.funnysentences.data.sentences.SentenceGenerator;
import io.github.itzispyder.funnysentences.util.ChatUtils;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.command.CommandRegistryAccess;

import static com.mojang.brigadier.Command.SINGLE_SUCCESS;
import static io.github.itzispyder.funnysentences.FunnySentences.starter;
import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.argument;
import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.literal;

/**
 * Command "fs:sentence"
 */
public class SentenceCommand {

    public static void register(CommandDispatcher<FabricClientCommandSource> dispatcher, CommandRegistryAccess registryAccess) {
        dispatcher.register(literal("fs:sent").executes(cxt -> {
            String sentence = SentenceConstructor.generate(SentenceGenerator.NORMAL,new SentenceFeature());
            ChatUtils.sendChatMessage(sentence);
            return SINGLE_SUCCESS;
        }));
        for (SentenceGenerator gen : SentenceGenerator.values()) {
            dispatcher.register(literal("fs:sent").then(literal("create").then(literal(gen.name().toLowerCase()).executes(cst -> {
                String sentence = SentenceConstructor.generate(gen,new SentenceFeature());
                ChatUtils.sendChatMessage(sentence);
                return SINGLE_SUCCESS;
            }))));
            dispatcher.register(literal("fs:sent").then(literal("spam").then(argument("amount", IntegerArgumentType.integer()).then(literal(gen.name().toLowerCase()).executes(cst -> {
                int amount = cst.getArgument("amount",Integer.class);
                if (amount >= 100) amount = 100;
                ChatUtils.sendMessage(starter + "§cYour amount was set to 100 due to being too high for safety reasons!");
                for (int i = 0; i < amount; i ++) {
                    String sentence = SentenceConstructor.generate(gen,new SentenceFeature());
                    ChatUtils.sendChatMessage(sentence);
                }
                return SINGLE_SUCCESS;
            })))));
            dispatcher.register(literal("fs:sent").then(literal("custom").then(argument("wordCount",IntegerArgumentType.integer()).then(literal(gen.name().toLowerCase()).executes(cxt -> {
                int count = cxt.getArgument("wordCount",Integer.class);
                if (count >= 100) count = 100;
                ChatUtils.sendMessage(starter + "§cYour count was set to 100 due to being too high for safety reasons!");
                SentenceFeature feature = new SentenceFeature(count,1,10);
                String sentence = SentenceConstructor.generate(gen,feature);
                ChatUtils.sendChatMessage(sentence);
                return SINGLE_SUCCESS;
            })))));
        }
    }
}
