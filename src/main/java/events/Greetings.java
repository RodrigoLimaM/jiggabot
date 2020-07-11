package events;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.awt.*;
import java.util.logging.Logger;

public class Greetings extends ListenerAdapter {

    private static final Logger LOGGER = Logger.getLogger(Greetings.class.getName());

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String messageSent = event.getMessage().getContentRaw();

        EmbedBuilder embedBuilder = new EmbedBuilder()
                .setColor(new Color(0x8b008b));

        if (!event.getAuthor().isBot() && isGreetingMessage(messageSent, "BOA NOITE")){
            embedBuilder.setDescription("Boa Noite! :new_moon_with_face:");
            sendMessageToChannel(embedBuilder, messageSent, event);
        }

        if (!event.getAuthor().isBot() && isGreetingMessage(messageSent, "BOA TARDE")){
            embedBuilder.setDescription("Boa Tarde! :sun_with_face:");
            sendMessageToChannel(embedBuilder, messageSent, event);
        }

        if (!event.getAuthor().isBot() && isGreetingMessage(messageSent, "BOM DIA")){
            embedBuilder.setDescription("Bom Dia! :partly_sunny:");
            sendMessageToChannel(embedBuilder, messageSent, event);
        }
    }

    private boolean isGreetingMessage(String messageSent, String greetingMessage) {
        return messageSent.toUpperCase().contains(greetingMessage);
    }

    private void sendMessageToChannel(EmbedBuilder embedBuilder, String messageSent, GuildMessageReceivedEvent event) {
        event.getChannel().sendMessage(embedBuilder.build()).queue();

        LOGGER.info("Message: " +messageSent);
    }
}
