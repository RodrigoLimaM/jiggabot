package events;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import service.SortitionService;

public class Sortition extends ListenerAdapter {

    SortitionService sortitionService = new SortitionService();

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String messageSent = event.getMessage().getContentRaw();
        if (isSortitionMessage(messageSent)) {
            event.getChannel().sendMessage(sortitionService.getSortedFields(messageSent));
        }
    }


    private boolean isSortitionMessage(String messageSent) {
        return messageSent.charAt(0) == 0
                && messageSent.toUpperCase().contains("SORTEIO");
    }
}
