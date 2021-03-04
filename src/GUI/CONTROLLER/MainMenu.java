package GUI.CONTROLLER;

import BE.ENUM.PlayerType;
import BLL.GAME.GameManager;
import BE.INTERFACE.IPlayer;
import BE.PLAYER.Ai;
import BE.PLAYER.Player;
import GUI.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class MainMenu implements Initializable {

    @FXML
    Button vsPlayerBtn;

    @FXML
    Button vsComputerBtn;

    Main main = Main.getInstance();
    GameManager gameManager = main.getGameManager();

    IPlayer player;
    IPlayer ai;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setupPlayers();
        setupButtons();
    }

    /**
     * Start playing against another player.
     */
    private void startVsPlayer() {
        System.out.println("TODO: Start vs player scene.");
    }

    /**
     * Setup the buttons.
     */
    private void setupButtons() {
        vsComputerBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, (x) -> {
            if (x.getButton() == MouseButton.PRIMARY) {
                try {
                    startVsComputer();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        vsPlayerBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, (x) -> {
            if (x.getButton() == MouseButton.PRIMARY) {
                try {
                    startVsPlayer();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Start playing against the computer.
     */
    private void startVsComputer() {
        try {
            startGame();

            int roundNumber = 0;
            if (gameManager.getCurrentRound() != null)
                roundNumber = gameManager.getCurrentRound().getRoundNumber();

            var correctTitle = roundNumber > 0 ? String.format("Pick Your Move - round: %d", roundNumber) : "Pick Your Move";
            main.changeStage("/GUI/FXML/PlayerMoveSelection.fxml", correctTitle);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Setup the players.
     */
    private void setupPlayers() {
        ai = new Ai("Sophie (Ai)", "ai.png");
        player = new Player("Joker (Player)", PlayerType.Player, "player.png");

        gameManager.setAi(ai);
        gameManager.setPlayer(player);
    }

    /**
     * Start the game.
     */
    private void startGame() {
        gameManager.start(ai, player);
    }
}
