package de.failex.fetabot.gui;

import de.failex.fetabot.Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by felix on 26.06.17.
 */
public class GuiController {

    Controller cnt;

    public GuiController(Controller cnt, Stage stage) {
        this.cnt = cnt;
        cnt.tab1.setText("Overview");
        cnt.tab1.setContent(getFXML("/tab1.fxml"));
        cnt.tab2.setText("Chat");
        cnt.tab2.setContent(getFXML("/tab2.fxml"));
        final Tab cmds = new Tab("Commands");
        cmds.setContent(getFXML("/tab3.fxml"));
        final Tab settings = new Tab("Settings");
        cnt.tabpane.getTabs().add(cmds);
        cnt.tabpane.getTabs().add(settings);
    }

    public Parent getFXML(String name) {
        FXMLLoader loader = new FXMLLoader();
        try {
            return loader.load(getClass().getResourceAsStream(name));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}