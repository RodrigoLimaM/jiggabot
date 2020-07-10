package commands;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import service.DrawService;
import service.MessageReceivedService;

import java.awt.*;

public class Draw extends ListenerAdapter {

    MessageReceivedService messageReceivedService = new MessageReceivedService();

    DrawService drawService = new DrawService();

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String messageSent = event.getMessage().getContentRaw();
        if (!event.getAuthor().isBot()
                && messageReceivedService.isCommandMessage(messageSent, "SORTEIO", "DRAW")) {

            String[] teams = drawService.getSortedFields(messageSent);

            EmbedBuilder embedBuilder = new EmbedBuilder()
                    .setTitle(":flag_white:  Sorteio de Times :flag_white:")
                    .addField(new MessageEmbed.Field("TIME 1", teams[0], true))
                    .addField(new MessageEmbed.Field("TIME 2", teams[1], true))
                    .setFooter("https://github.com/RodrigoLimaM/jiggabot", "https://bots.ondiscord.xyz/favicon/android-chrome-256x256.png")
                    .setColor(new Color(0x8b008b));;

            event.getChannel().sendMessage(embedBuilder.build()).queue();
        }
    }

}
