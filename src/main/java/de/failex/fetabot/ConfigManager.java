package de.failex.fetabot;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by felix on 21.06.17.
 */
public class ConfigManager {

    private String user = "";
    private String oauth = "";
    private String channel = "";
    private String owner = "";
    private ArrayList<String> mods = new ArrayList<String>();
    private HashMap<String, Command> commands = new HashMap<String, Command>();

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getOauth() {
        return oauth;
    }

    public void setOauth(String oauth) {
        this.oauth = oauth;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public ArrayList<String> getMods() {
        return mods;
    }

    public void setMods(ArrayList<String> mods) {
        this.mods = mods;
    }

    public HashMap<String, Command> getCommands() {
        return commands;
    }

    public void setCommands(HashMap<String, Command> commands) {
        this.commands = commands;
    }

    public boolean isCorrectlySetUp() {
        if (!user.isEmpty() && !oauth.isEmpty() && !channel.isEmpty() && !owner.isEmpty()) return true;
        return false;
    }
}
