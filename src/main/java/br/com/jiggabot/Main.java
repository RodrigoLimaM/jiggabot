package br.com.jiggabot;

import br.com.jiggabot.commands.Draw;
import br.com.jiggabot.commands.Help;
import br.com.jiggabot.events.Greetings;
import br.com.jiggabot.events.NewMember;
import br.com.jiggabot.events.NickameChange;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import javax.security.auth.login.LoginException;

@SpringBootApplication
@EnableAutoConfiguration
@EnableFeignClients
public class Main {
    public static void main(String[] args) throws LoginException {
        SpringApplication.run(Main.class, args);
        JDA jda = new JDABuilder(AccountType.BOT)
                .setToken(System.getenv("BOT_KEY"))
                .setGame(Game.watching("Jojo Bizarres Adventures"))
                .build();

        jda.addEventListener(new Draw());
        jda.addEventListener(new Help());
        jda.addEventListener(new Greetings());
        jda.addEventListener(new NewMember());
        jda.addEventListener(new NickameChange());
    }
}
