package br.com.jiggabot;

import br.com.jiggabot.commands.Draw;
import br.com.jiggabot.commands.Help;
import br.com.jiggabot.events.Greetings;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JiggabotApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JiggabotApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		JDA jda = new JDABuilder(System.getenv("BOT_KEY")).build();

		jda.addEventListener(new Draw());
		jda.addEventListener(new Help());
		jda.addEventListener(new Greetings());
	}
}
