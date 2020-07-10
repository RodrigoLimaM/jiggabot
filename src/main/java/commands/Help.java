package commands;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import service.MessageReceivedService;

import java.awt.Color;

public class Help extends ListenerAdapter {

    MessageReceivedService messageReceivedService = new MessageReceivedService();

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String messageSent = event.getMessage().getContentRaw();
        if (!event.getAuthor().isBot()
                && messageReceivedService.isCommandMessage(messageSent, "AJUDA", "HELP", "COMANDOS", "COMMANDS")) {

            EmbedBuilder embedBuilder = new EmbedBuilder()
                    .setTitle(":robot: Comando do JiggaBot :robot:")
                    .setDescription("**!ajuda, !help, !comandos ou !commands** - Mostra todos os comandos do bot;\n" +
                            "**!sorteio ou !draw** - Realiza sorteio para criação de dois times.")
                    .setFooter("https://github.com/RodrigoLimaM/jiggabot", "https://bots.ondiscord.xyz/favicon/android-chrome-256x256.png")
                    .setColor(new Color(0x8b008b));


            event.getChannel().sendMessage(embedBuilder.build()).queue();
        }
    }
}
