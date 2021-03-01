package GUI.CONTROLLER;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class MainMenu implements Initializable {

    @FXML
    Button vsPlayerBtn;

    @FXML
    Button vsComputerBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void startVsPlayer() {
        System.out.println("TODO: Start vs player scene.");
    }

    @FXML
    private void startVsComputer() {
        System.out.println("TODO: Start vs computer scene.");
    }
}
