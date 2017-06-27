package de.failex.fetabot.gui

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage

/**
 * Created by felix on 26.06.17.
 */


class StartUpGUI : Application() {

    override fun start(primaryStage: Stage?) {

        val loader = FXMLLoader()
        val parent: Parent = loader.load(javaClass.getResourceAsStream("/gui.fxml"))

        primaryStage!!.scene = Scene(parent)
        primaryStage.sizeToScene()
        primaryStage.isResizable = false
        primaryStage.centerOnScreen()
        GuiController(loader.getController(), primaryStage)
        primaryStage.show()
    }
    companion object {
        fun start() {
            launch(StartUpGUI::class.java)
        }
    }
}