package br.com.jiggabot.controller;

import br.com.jiggabot.JiggabotInitializer;
import br.com.jiggabot.service.SendMessageService;
import net.dv8tion.jda.core.entities.TextChannel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/bot")
public class JiggabotController {

    SendMessageService sendMessageService = new SendMessageService();

    private static final String CHANNEL_NAME = "general";

    @PostMapping("/message")
    public ResponseEntity<String> sendMessage(@RequestParam String message) throws URISyntaxException {
        //TODO make null safe
        TextChannel textChannel = new JiggabotInitializer()
                .getJda()
                .getTextChannelsByName(CHANNEL_NAME, true)
                .get(0);

        sendMessageService.sendMessageToSpecificChannel(
                sendMessageService.buildDefaultMessageEmbed("@everyone " +message).build(),
                textChannel
        );

        return ResponseEntity.created(new URI("/bot/message")).build();
    }

}
