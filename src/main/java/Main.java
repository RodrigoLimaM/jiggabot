import commands.Sortition;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;

import javax.security.auth.login.LoginException;

public class Main {
    public static void main(String[] args) throws LoginException {
        JDA jda = new JDABuilder("NzMwOTA3MDI0MTYxODk4NjI3.Xwea3w.GLjeyUWKNT7UBy-9yz71ZKj7TaY").build();

        jda.addEventListener(new Sortition());
    }
}
