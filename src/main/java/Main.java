import commands.Draw;
import commands.Help;
import events.Greetings;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;

import javax.security.auth.login.LoginException;

public class Main {
    public static void main(String[] args) throws LoginException {
        JDA jda = new JDABuilder(AccountType.BOT)
                .setToken(System.getenv("BOT_KEY"))
                .setGame(Game.watching("Jojo Bizarres Adventures"))
                .build();

        jda.addEventListener(new Draw());
        jda.addEventListener(new Help());
        jda.addEventListener(new Greetings());
    }
}
