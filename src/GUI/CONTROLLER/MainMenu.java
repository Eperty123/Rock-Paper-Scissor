package GUI.CONTROLLER;

import GUI.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainMenu implements Initializable {

    @FXML
    Button vsPlayerBtn;

    @FXML
    Button vsComputerBtn;

    Main main = Main.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void startVsPlayer() {
        System.out.println("TODO: Start vs player scene.");
    }

    @FXML
    private void startVsComputer() throws IOException {
        try {
            //main.changeStage("/GUI/FXML/VSAiMoveResult.fxml", "VS Ai");
            main.changeStage("/GUI/FXML/PlayerMoveSelection.fxml", "Pick Your Move");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("TODO: Start vs computer scene.");
    }
}
