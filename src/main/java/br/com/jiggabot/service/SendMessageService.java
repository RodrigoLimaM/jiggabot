package br.com.jiggabot.service;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.guild.GenericGuildEvent;
import net.dv8tion.jda.core.events.message.guild.GenericGuildMessageEvent;

import java.awt.Color;

public class SendMessageService {

    public void sendMessage(MessageEmbed messageEmbed, GenericGuildMessageEvent event) {
        event.getChannel().sendMessage(messageEmbed).queue();
    }

    public void sendMessageToGeneral(MessageEmbed messageEmbed, GenericGuildEvent event) {
        //TODO Make null safe
        TextChannel textChannel = event
                .getGuild()
                .getTextChannelsByName("general", true)
                .get(0);

        textChannel.sendMessage(messageEmbed).queue();
    }

    public EmbedBuilder buildDefaultMessageEmbed(String description){
        return new EmbedBuilder()
                .setColor(new Color(0x8b008b))
                .setDescription(description);
    }
}
