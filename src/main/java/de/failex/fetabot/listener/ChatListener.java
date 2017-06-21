package de.failex.fetabot.listener;

import de.failex.fetabot.FetaBot;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.types.GenericMessageEvent;

/**
 * Created by felix on 21.06.17.
 */
public class ChatListener extends ListenerAdapter {

    @Override
    public void onGenericMessage(GenericMessageEvent event) {
        String msg = event.getMessage();
        for (String cmd : FetaBot.cfg.getCommands().keySet()) {
            if (msg.equals(cmd)) {
                FetaBot.cfg.getCommands().get(cmd).run(event.getUser().toString(), FetaBot.getGroup(event.getUser().toString()));
            }
        }
    }

}
