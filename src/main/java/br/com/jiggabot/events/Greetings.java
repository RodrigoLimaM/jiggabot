package br.com.jiggabot.events;

import br.com.jiggabot.service.SendMessageService;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

@Slf4j
public class Greetings extends ListenerAdapter {

    SendMessageService sendMessageService = new SendMessageService();

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String messageSent = event.getMessage().getContentRaw();
        String messageAuthor = event.getAuthor().getName();

        if (!event.getAuthor().isBot() && isGreetingMessage(messageSent, "BOA NOITE")){
            sendMessageToChannel("Boa noite " +messageAuthor +"! :new_moon_with_face:", messageSent, event);
        }

        if (!event.getAuthor().isBot() && isGreetingMessage(messageSent, "BOA TARDE")){
            sendMessageToChannel("Boa tarde "  +messageAuthor +"! :sun_with_face:", messageSent, event);
        }

        if (!event.getAuthor().isBot() && isGreetingMessage(messageSent, "BOM DIA")){
            sendMessageToChannel("Bom dia " +messageAuthor +"! :partly_sunny:", messageSent, event);
        }
    }

    private boolean isGreetingMessage(String messageSent, String greetingMessage) {
        return messageSent.toUpperCase().contains(greetingMessage);
    }

    private void sendMessageToChannel(String description, String messageSent, GuildMessageReceivedEvent event) {
        MessageEmbed messageEmbed = sendMessageService.buildDefaultMessageEmbed(description).build();

        sendMessageService.sendMessage(messageEmbed, event);

        log.info("Message: {}", messageSent);
    }
}
