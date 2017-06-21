package de.failex.fetabot;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class FetaBot {

    static File config = new File("config.json");
    static Gson gson = new Gson();
    static ConfigManager cfg;

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

                    cfg = gson.fromJson(temp.toString(), ConfigManager.class);#

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
            }
        }
    }

    public static void log(String msg) {
        System.out.println("[FeTaBot] " + msg);
    }
}
