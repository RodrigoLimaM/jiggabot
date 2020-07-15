package br.com.jiggabot.commands;

import br.com.jiggabot.service.MessageReceivedService;
import br.com.jiggabot.service.SendMessageService;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

@Slf4j
public class Help extends ListenerAdapter {

    MessageReceivedService messageReceivedService = new MessageReceivedService();

    SendMessageService sendMessageService = new SendMessageService();

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String messageSent = event.getMessage().getContentRaw();
        if (!event.getAuthor().isBot()
                && messageReceivedService.isCommandMessage(messageSent, "AJUDA", "HELP", "COMANDOS", "COMMANDS")) {

            MessageEmbed messageEmbed = sendMessageService.buildDefaultMessageEmbed(
                    "**!ajuda, !help, !comandos ou !br.com.jiggabot.commands** - Mostra todos os comandos do bot; \n"
                    +"**!sorteio ou !draw** - Realiza sorteio para criação de dois times.")
                    .setTitle(":robot: Comando do JiggaBot :robot:")
                    .setFooter("https://github.com/RodrigoLimaM/jiggabot", "https://bots.ondiscord.xyz/favicon/android-chrome-256x256.png")
                    .build();

            log.info("Message: {}" , messageSent);

            sendMessageService.sendMessage(messageEmbed, event);
        }
    }
}
