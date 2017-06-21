package de.failex.fetabot.listener;

import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.types.GenericMessageEvent;

/**
 * Created by felix on 21.06.17.
 */
public class ChatListener extends ListenerAdapter {

    @Override
    public void onGenericMessage(GenericMessageEvent event) {
        String cmd = event.getMessage();
    }
}
