package br.com.jiggabot.commands;

import br.com.jiggabot.service.DrawService;
import br.com.jiggabot.service.MessageReceivedService;
import br.com.jiggabot.service.SendMessageService;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

@Slf4j
public class Draw extends ListenerAdapter {

    MessageReceivedService messageReceivedService = new MessageReceivedService();

    DrawService drawService = new DrawService();

    SendMessageService sendMessageService = new SendMessageService();

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String messageSent = event.getMessage().getContentRaw();
        if (!event.getAuthor().isBot()
                && messageReceivedService.isCommandMessage(messageSent, "SORTEIO", "DRAW")) {

            String[] teams = drawService.getSortedFields(messageSent);

            MessageEmbed messageEmbed = sendMessageService.buildDefaultMessageEmbed(null)
                    .setTitle(":flag_white:  Sorteio de Times :flag_white:")
                    .addField(new MessageEmbed.Field("TIME 1", teams[0], true))
                    .addField(new MessageEmbed.Field("TIME 2", teams[1], true))
                    .setFooter("https://github.com/RodrigoLimaM/jiggabot", "https://bots.ondiscord.xyz/favicon/android-chrome-256x256.png")
                    .build();

            log.info("Message: {}" , messageSent);

            sendMessageService.sendMessage(messageEmbed, event);
        }
    }

}
