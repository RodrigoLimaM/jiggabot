package br.com.jiggabot.events;

import br.com.jiggabot.service.SendMessageService;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.events.guild.member.GuildMemberNickChangeEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

@Slf4j
public class NicknameChange extends ListenerAdapter {

    SendMessageService sendMessageService = new SendMessageService();

    @Override
    public void onGuildMemberNickChange(GuildMemberNickChangeEvent event) {
        String previousNick = event.getPrevNick() == null ? event.getUser().getName() : event.getPrevNick();
        String newNick = event.getNewNick();

        MessageEmbed messageEmbed = sendMessageService.buildDefaultMessageEmbed(
                previousNick
                +" trocou o apelido para: "
                +newNick +". :scream:")
                .build();

        sendMessageService.sendMessageToGeneral(messageEmbed, event);

        log.info("Previous nickname: {} | New nickname: {}", previousNick, newNick);
    }
}
