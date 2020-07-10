package events;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.awt.*;

public class Greetings extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String messageSent = event.getMessage().getContentRaw();

        EmbedBuilder eb = new EmbedBuilder()
                .setColor(new Color(0x8b008b));;

        if (messageSent.toUpperCase().contains("BOA NOITE") && !event.getAuthor().isBot()){
            eb.setDescription("Boa Noite! :new_moon_with_face:");
            event.getChannel().sendMessage(eb.build()).queue();
        }

        if (messageSent.toUpperCase().contains("BOA TARDE") && !event.getAuthor().isBot()){
            eb.setDescription("Bom Tarde! :sun_with_face:");
            event.getChannel().sendMessage(eb.build()).queue();
        }

        if (messageSent.toUpperCase().contains("BOM DIA") && !event.getAuthor().isBot()){
            eb.setDescription("Bom Dia! :partly_sunny:");
            event.getChannel().sendMessage(eb.build()).queue();
        }
    }
}
