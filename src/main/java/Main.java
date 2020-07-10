import commands.Draw;
import commands.Help;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;

import javax.security.auth.login.LoginException;

public class Main {
    public static void main(String[] args) throws LoginException {
        JDA jda = new JDABuilder(System.getenv("BOT_KEY")).build();

        jda.addEventListener(new Draw());
        jda.addEventListener(new Help());
    }
}
