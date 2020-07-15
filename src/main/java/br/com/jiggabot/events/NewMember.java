package br.com.jiggabot.events;

import br.com.jiggabot.service.SendMessageService;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

@Slf4j
public class NewMember extends ListenerAdapter {

    SendMessageService sendMessageService = new SendMessageService();

    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        String memberName = event.getUser().getName();

        MessageEmbed messageEmbed = sendMessageService.buildDefaultMessageEmbed(
                "Bem vindo "
                +memberName +"! :slight_smile:")
                .build();

        sendMessageService.sendMessageToGeneral(messageEmbed, event);

        log.info("New member: {}", memberName);
    }




}
