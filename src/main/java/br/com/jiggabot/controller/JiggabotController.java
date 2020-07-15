package br.com.jiggabot.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bot")
public class JiggabotController {

    //TODO
    @PostMapping
    public String sendMessage(){
        return "teste";
    }

}
