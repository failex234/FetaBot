package de.failex.fetabot;

import com.google.gson.Gson;
import de.failex.fetabot.listener.ChatListener;
import org.pircbotx.Configuration;
import org.pircbotx.PircBotX;
import org.pircbotx.exception.IrcException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FetaBot {

    static File config = new File("config.json");
    static Gson gson = new Gson();
    static ConfigManager cfg;

    static final String PRGNAME = "FeTaBot";
    static final String VERSION = "1.0-SNAPSHOT";
    static final String AUTHOR = "failex234";

    public static void main(String[] args) {
        if (args.length == 0) {
            if (config.exists()) {
                log("Config found, loading...");
                try {
                    Scanner in = new Scanner(new FileReader(config));
                    StringBuilder temp = new StringBuilder();

                    while (in.hasNext()) {
                        temp.append(in.next());
                    }
                    in.close();

                    cfg = gson.fromJson(temp.toString(), ConfigManager.class);

                    log("Config loaded!");

                } catch (Exception e) {
                    log("Something went wrong! Unable to continue, exiting now...");
                    e.printStackTrace();
                    System.exit(1);
                }

            } else {
                log("No config found and no arguments found! Please re-run this program with the following arguments:");
                log("fetabot.jar <user> <oauth-key> <channel> <owner>");
                log("You only have to do this once, all settings will be saved in a config file!");
                log("Program will now exit!");
                System.exit(1);
            }
        } else {
            if (config.exists()) {
                log("Config found but also arguments found. Overwriting config...");
                cfg = new ConfigManager();
                if (args.length != 4) {
                    log("Too few arguments! Please restart with enough arguments!");
                    System.exit(1);
                } else {
                    cfg.setUser(args[0]);
                    cfg.setOauth(args[1]);
                    cfg.setChannel(args[2]);
                    cfg.setOwner(args[3]);

                    log("Overwriting config but copying mods and commands...");
                    try {
                        PrintWriter writer = new PrintWriter(config);
                        ConfigManager temp = cfg;

                        Scanner in = new Scanner(new FileReader(config));
                        StringBuilder tempsb = new StringBuilder();

                        while (in.hasNext()) {
                            tempsb.append(in.next());
                        }
                        in.close();

                        temp = gson.fromJson(temp.toString(), ConfigManager.class);

                        cfg.setMods(temp.getMods());
                        cfg.setCommands(temp.getCommands());

                        config.delete();

                        writer.write(gson.toJson(cfg));

                        writer.close();

                    } catch (Exception e) {
                        log("Something went wrong! Unable to continue, exiting now...");
                        e.printStackTrace();
                        System.exit(1);
                    }

                }
            } else {
                log("Config not found but found arguments. Creating config...");

                cfg = new ConfigManager();

                cfg.setUser(args[0]);
                cfg.setOauth(args[1]);
                cfg.setChannel(args[2]);
                cfg.setOwner(args[3]);
                try {
                    PrintWriter writer = new PrintWriter(config);
                    writer.write(gson.toJson(cfg));
                    writer.close();
                    log("Config written!");
                } catch (Exception e) {
                    log("Something went wrong! Unable to continue, exiting now...");
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }

        log(PRGNAME + " Version " + VERSION + " by " + AUTHOR + " starting up...");

        Configuration configuration = new Configuration.Builder()
                .setName(cfg.getUser())
                .setServerPassword(cfg.getOauth())
                .addServer("irc.twitch.tv")
                .addAutoJoinChannel("#" + cfg.getChannel())
                .addListener(new ChatListener())
                .buildConfiguration();

        PircBotX bot = new PircBotX(configuration);

        log("Connecting to Twitch as " + cfg.getUser() + " to Channel " + cfg.getChannel() + " and " + cfg.getOwner() + " as the owner");

        try {
            bot.startBot();
        } catch (IOException e) {
            e.printStackTrace();
            log("Something went wrong! Unable to continue, exiting now...");
        } catch (IrcException e) {
            e.printStackTrace();
            log("Something went wrong! Unable to continue, exiting now...");
        }
    }

    public static void log(String msg) {
        System.out.println("[FeTaBot] " + msg);
    }
}
