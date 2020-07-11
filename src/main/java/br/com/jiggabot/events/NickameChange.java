package br.com.jiggabot.events;

import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.guild.member.GuildMemberNickChangeEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.awt.*;

@Slf4j
public class NickameChange extends ListenerAdapter {

    @Override
    public void onGuildMemberNickChange(GuildMemberNickChangeEvent event) {

        //TODO Make null safe
        TextChannel textChannel = event
                .getGuild()
                .getTextChannelsByName("general", true)
                .get(0);

        String previousNick = event.getPrevNick() == null ? event.getUser().getName() : event.getPrevNick();
        String newNick = event.getNewNick();

        MessageEmbed messageEmbed = new EmbedBuilder()
                .setColor(new Color(0x8b008b))
                .setDescription(previousNick +" trocou o apelido para: " +newNick +". :scream:")
                .build();

        textChannel.sendMessage(messageEmbed).queue();

        log.info("Previous nickname: {} | New nickname: {}", previousNick, newNick);
    }
}
