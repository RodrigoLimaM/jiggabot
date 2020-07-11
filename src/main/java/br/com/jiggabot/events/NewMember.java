package br.com.jiggabot.events;

import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.awt.*;

@Slf4j
public class NewMember extends ListenerAdapter {

    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        TextChannel textChannel = event
                .getGuild()
                .getTextChannelsByName("general", true)
                .get(0);

        String memberName = event.getUser().getName();

        MessageEmbed messageEmbed = new EmbedBuilder()
                .setColor(new Color(0x8b008b))
                .setDescription("Bem vindo " +memberName +"! :slight_smile:" )
                .build();

        textChannel.sendMessage(messageEmbed).queue();

        log.info("New member: {}", memberName);
    }




}
