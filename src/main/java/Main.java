import commands.Sortition;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;

import javax.security.auth.login.LoginException;

public class Main {
    public static void main(String[] args) throws LoginException {
        Dotenv dotenv = Dotenv.load();

        JDA jda = new JDABuilder(dotenv.get("BOT_KEY")).build();

        jda.addEventListener(new Sortition());
    }
}
