package GUI.CONTROLLER;

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
import javafx.scene.text.Text;


import java.net.URL;
import java.util.ResourceBundle;

public class VSAiMoveResultController implements Initializable {
    @FXML
    Text aiMoveResultText;
    @FXML
    Text playerMoveResultText;

    @FXML
    ImageView aiMoveResultImage;
    @FXML
    ImageView playerMoveResultImage;

    @FXML
    ImageView aiAvatarImage;
    @FXML
    ImageView playerAvatarImage;

    @FXML
    Button nextRoundBtn;
    @FXML
    Button mainMenuBtn;

    @FXML
    Text winnerText;

    @FXML
    Label aiNameLbl;
    @FXML
    Label playerNameLbl;

    Main main = Main.getInstance();
    GameManager gameManager = main.getGameManager();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setupUi();
        handleButtons();
        handleResult();
    }

    /**
     * Setup the ui.
     */
    private void setupUi() {
        aiNameLbl.setText(gameManager.getAi().getPlayerName());
        playerNameLbl.setText(gameManager.getPlayer().getPlayerName());
    }

    /**
     * Handle the different buttons.
     */
    private void handleButtons() {
        nextRoundBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, (x) -> {
            if (x.getButton() == MouseButton.PRIMARY) {
                try {
                    int roundNumber = gameManager.getCurrentRoundNumber();

                    var correctTitle = roundNumber > 0 ? String.format("Pick Your Move - round: %d", roundNumber) : "Pick Your Move";
                    main.changeStage("/GUI/FXML/PlayerMoveSelection.fxml", correctTitle);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        mainMenuBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, (x) -> {
            if (x.getButton() == MouseButton.PRIMARY) {
                try {
                    main.getGameManager().reset();
                    main.changeStage("/GUI/FXML/MainMenu.fxml", "Main Menu");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Set the result move image based on the player type.
     */
    private void setResultImages() {
        aiMoveResultImage.setImage(new Image(gameManager.getMovePicturePath(gameManager.getAi().getChosenMove())));
        playerMoveResultImage.setImage(new Image(gameManager.getMovePicturePath(gameManager.getPlayer().getChosenMove())));
    }

    /**
     * Handle the result for ai and player.
     */
    private void handleResult() {
        setResultImages();
        getAiResult();
        getPlayerResult();
        getRoundResult();
    }

    /**
     * Handle ai result.
     */
    private void getAiResult() {
        aiAvatarImage.setImage(new Image(gameManager.getAi().getAvatarPath()));
        if (gameManager.getAi().getChosenMove() != null)
            aiMoveResultText.setText(gameManager.getAi().getChosenMove().toString());
    }

    /**
     * Handle player result.
     */
    private void getPlayerResult() {
        playerAvatarImage.setImage(new Image(gameManager.getPlayer().getAvatarPath()));
        if (gameManager.getPlayer().getChosenMove() != null)
            playerMoveResultText.setText(gameManager.getPlayer().getChosenMove().toString());
    }

    /**
     * Get the round result.
     */
    private void getRoundResult() {
        winnerText.setText(gameManager.getCurrentRound().getWinnerPlayer().getPlayerName());
    }
}
