package io.github.itzispyder.funnysentences.commands.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import io.github.itzispyder.funnysentences.commands.Command;
import io.github.itzispyder.funnysentences.data.sentences.SentenceConstructor;
import io.github.itzispyder.funnysentences.data.sentences.SentenceFeature;
import io.github.itzispyder.funnysentences.data.sentences.SentenceGenerator;
import io.github.itzispyder.funnysentences.util.ChatUtils;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.command.CommandRegistryAccess;

import static io.github.itzispyder.funnysentences.FunnySentences.starter;

public class SentenceCommand extends Command {

    @Override
    public void onCommand(CommandDispatcher<FabricClientCommandSource> dispatcher, CommandRegistryAccess access) {
        // fs
        dispatcher.register(literal("fs").executes(cxt -> {
            SentenceFeature feature = new SentenceFeature();
            String sentence = SentenceConstructor.generate(SentenceGenerator.NORMAL,feature);
            ChatUtils.sendChatMessage(sentence);
            return SINGLE_SUCCESS;
        }));
        for (SentenceGenerator gen : SentenceGenerator.values()) {
            // fs <type>
            dispatcher.register(literal("fs").then(literal(gen.name().toLowerCase()).executes(cxt -> {
                SentenceFeature feature = new SentenceFeature();
                String sentence = SentenceConstructor.generate(gen, feature);
                ChatUtils.sendChatMessage(sentence);
                return SINGLE_SUCCESS;
            })));
            // fs <type> spam <times>
            dispatcher.register(literal("fs").then(literal(gen.name().toLowerCase()).then(literal("spam").then(argument("times", IntegerArgumentType.integer()).executes(cxt -> {
                int times = cxt.getArgument("times",Integer.class);
                SentenceFeature feature = new SentenceFeature();
                for (int i = 0; i < times; i++) {
                    String sentence = SentenceConstructor.generate(gen, feature);
                    ChatUtils.sendChatMessage(sentence);
                }
                return SINGLE_SUCCESS;
            })))));
            // fs <type> words <count>
            dispatcher.register(literal("fs").then(literal(gen.name().toLowerCase()).then(literal("words").then(argument("count", IntegerArgumentType.integer()).executes(cxt -> {
                int count = cxt.getArgument("count",Integer.class);
                SentenceFeature feature = new SentenceFeature();
                feature.setWordCount(count);
                String sentence = SentenceConstructor.generate(gen, feature);
                ChatUtils.sendChatMessage(sentence);
                return SINGLE_SUCCESS;
            })))));
            // fs <type> words <count> spam <times>
            dispatcher.register(literal("fs").then(literal(gen.name().toLowerCase()).then(literal("words").then(argument("count", IntegerArgumentType.integer()).then(literal("spam").then(argument("times",IntegerArgumentType.integer()).executes(cxt -> {
                int count = cxt.getArgument("count",Integer.class);
                int times = cxt.getArgument("times",Integer.class);
                SentenceFeature feature = new SentenceFeature();
                feature.setWordCount(count);
                for (int i = 0; i < times; i++) {
                    String sentence = SentenceConstructor.generate(gen, feature);
                    ChatUtils.sendChatMessage(sentence);
                }
                return SINGLE_SUCCESS;
            })))))));
        }
        // fs spam <times>
        dispatcher.register(literal("fs").then(literal("spam").then(argument("times",IntegerArgumentType.integer()).then(argument("message", StringArgumentType.greedyString()).executes(cxt -> {
            int times = cxt.getArgument("times",Integer.class);
            String message = cxt.getArgument("message",String.class);
            for (int i = 0; i < times; i++) ChatUtils.sendChatMessage(message);
            return SINGLE_SUCCESS;
        })))));
        // fs help
        dispatcher.register(literal("fs").then(literal("help").executes(cxt -> {
            ChatUtils.sendMessage(
                    "",
                    starter + "§bThe Ultimate Chat Spam Troll",
                    "   §f/fs §8| §7Send random sentence",
                    "   §f/fs §e<type> §8| §7Sends sentences",
                    "   §f/fs §e<type> §fspam §e<times> §8| §7Spams sentences",
                    "   §f/fs §e<type> §fword §e<amount> §8| §7Sends sentences with custom word count",
                    "   §f/fs §e<type> §fword §e<amount> §fspam §e<times> §8| §7Spams sentences with custom word count",
                    "   §f/fs spam §e<times> <message> §8| §7Spams custom message",
                    "   §f/fs help §8| §7Command help",
                    ""
            );
            return SINGLE_SUCCESS;
        })));
    }
}
