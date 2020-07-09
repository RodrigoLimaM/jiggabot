import events.Sortition;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;

import javax.security.auth.login.LoginException;

public class Main {
    public static void main(String[] args) throws LoginException {
        JDA jda = new JDABuilder("NzMwOTA3MDI0MTYxODk4NjI3.XweURg.J6AWCl6GNmCpkFpVl39sr9NATrI").build();

        jda.addEventListener(new Sortition());
    }
}
