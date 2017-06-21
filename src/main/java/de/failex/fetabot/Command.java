package de.failex.fetabot;

/**
 * Created by felix on 21.06.17.
 */
public interface Command {

    /**
     * Code to be run when any known command gets executed
     * @param user The user who ran the command
     * @param group Group the user is in (subscriber, follower, mod, owner, normal)
     */
    void run(String user, String group);
}
