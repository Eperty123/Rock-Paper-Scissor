package GUI.CONTROLLER;

import GUI.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PlayerMoveSelectionControlller {
    @FXML
    Button rockButton;
    @FXML
    Button paperButton;
    @FXML
    Button scissorButton;

    Main main = Main.getInstance();

    @FXML
    private void choose() {
        try {
            //main.changeStage("/GUI/FXML/VSAiMoveResult.fxml", "VS Ai");
            handleChosenMove();
            main.changeStage("/GUI/FXML/VSAiMoveResult.fxml", "Move Result");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handleChosenMove() {
        // TODO: Add listener and logic to button click.
    }
}
