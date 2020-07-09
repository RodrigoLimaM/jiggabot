package commands;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import service.SortitionService;

public class Sortition extends ListenerAdapter {

    SortitionService sortitionService = new SortitionService();

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent command) {
        String messageSent = command.getMessage().getContentRaw();
        if (!command.getAuthor().isBot() && isSortitionMessage(messageSent)) {
            String[] teams = sortitionService.getSortedFields(messageSent);
            EmbedBuilder embedBuilder = new EmbedBuilder()
                    .setTitle(":flag_white:  Sorteio de Times :flag_white:")
                    .addField(new MessageEmbed.Field("TIME 1", teams[0], true))
                    .addField(new MessageEmbed.Field("TIME 2", teams[1], true));
            command.getChannel().sendMessage(embedBuilder.build()).queue();
        }
    }

    private boolean isSortitionMessage(String messageSent) {
        return messageSent.charAt(0) == '!'
                && messageSent
                    .replace("!", "")
                    .toUpperCase()
                    .contains("SORTEIO ");
    }
}
