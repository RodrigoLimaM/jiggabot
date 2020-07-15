package br.com.jiggabot;

import br.com.jiggabot.commands.Draw;
import br.com.jiggabot.commands.Help;
import br.com.jiggabot.events.Greetings;
import br.com.jiggabot.events.NewMember;
import lombok.SneakyThrows;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;

public class JiggabotInitializer {

    static JDA jda;

    @SneakyThrows
    public static void run() {
        jda = new JDABuilder(AccountType.BOT)
                .setToken(System.getenv("BOT_KEY"))
                .setGame(Game.watching("Jojo Bizarres Adventures"))
                .build();

        jda.addEventListener(new Draw());
        jda.addEventListener(new Help());
        jda.addEventListener(new Greetings());
        jda.addEventListener(new NewMember());
//        jda.addEventListener(new NicknameChange());
    }

    public JDA getJda(){
        return jda;
    }
}
