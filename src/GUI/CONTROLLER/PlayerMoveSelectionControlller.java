package GUI.CONTROLLER;

import BE.ENUM.MoveType;
import BLL.GAME.GameManager;
import GUI.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class PlayerMoveSelectionControlller implements Initializable {
    @FXML
    Button rockButton;
    @FXML
    Button paperButton;
    @FXML
    Button scissorButton;
    @FXML
    ImageView avatarImageView;
    @FXML
    Label playerNameLbl;

    Main main = Main.getInstance();
    GameManager gameManager = main.getGameManager();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setupPlayer();
        handleChosenMove();
    }

    /**
     * Setup the player.
     */
    private void setupPlayer() {
        avatarImageView.setImage(new Image(gameManager.getPlayer().getAvatarPath()));
        playerNameLbl.setText(gameManager.getPlayer().getPlayerName());
    }

    /**
     * Set the result.
     */
    private void seeResult() {
        try {
            main.changeStage("/GUI/FXML/VSAiMoveResult.fxml", "Move Result");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Handle the player's chosen element.
     */
    private void handleChosenMove() {
        rockButton.addEventHandler(MouseEvent.MOUSE_PRESSED, (x) -> {
            if (x.getButton() == MouseButton.PRIMARY) {
                gameManager.playRound(MoveType.Rock);
                seeResult();
            }
        });

        paperButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (x) -> {
            if (x.getButton() == MouseButton.PRIMARY) {
                gameManager.playRound(MoveType.Paper);
                seeResult();
            }
        });

        scissorButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (x) -> {
            if (x.getButton() == MouseButton.PRIMARY) {
                gameManager.playRound(MoveType.Scissor);
                seeResult();
            }
        });
    }

}
