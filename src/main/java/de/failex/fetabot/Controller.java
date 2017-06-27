package de.failex.fetabot;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

/**
 * Created by felix on 26.06.17.
 */
public class Controller {

    /**
     * Main (Parent) GUI
     */
    @FXML
    public Tab tab1;

    @FXML
    public Tab tab2;

    @FXML
    public TabPane tabpane;

    /**
     * Overview Tab GUI (tab1)
     */

    @FXML
    public AnchorPane tab1pane;

    @FXML
    public Label lbl_status;

    @FXML
    public Button btn_start;

    @FXML
    public Button btn_stop;

    /**
     * Chat Tab GUI (tab2)
     */

    @FXML
    public AnchorPane tab2pane;

    @FXML
    public TextArea tb_chat;

    /**
     * Commands Tab GUI (tab3)
     */

    @FXML
    public AnchorPane tab3pane;

    @FXML
    public ListView lv_cmds;

    @FXML
    public Label lbl_title_cmds;

    @FXML
    public Button btn_edit_cmds;

    @FXML
    public Button btn_del_cmds;

    @FXML
    public Label lbl_title_cmds_add;

    @FXML
    public Button btn_add_cmds;

    @FXML
    public TextField tb_cmdsname;

}
