package BE.PLAYER;

import BE.ENUM.Move;
import BE.GAME.GameManager;
import BE.GAME.IGameState;
import BE.GAME.Result;
import BE.ENUM.PlayerType;
import BE.INTERFACE.IPlayer;

import java.util.ArrayList;

public class Player implements IPlayer {

    private String name;
    private PlayerType type;
    private String avatarPath;
    private Move chosenMove;

    public Player() {

    }

    public Player(String name, PlayerType type) {
        setName(name);
        setType(type);
    }

    public Player(String name, PlayerType type, String avatarPath) {
        setName(name);
        setType(type);
        setAvatarPath(avatarPath);
    }

    @Override
    public String getPlayerName() {
        return name;
    }

    @Override
    public PlayerType getPlayerType() {
        return type;
    }

    /**
     * Decides the next move
     *
     * @param state contains game state, with previous results
     * @return Next move
     */
    @Override
    public Move doMove(IGameState state) {

        ArrayList<Result> moveResults = (ArrayList<Result>) state.getMoveResults();

        return Move.Rock;
    }

    @Override
    public String getAvatarPath() {
        return avatarPath;
    }

    @Override
    public void setAvatarPath(String avatarPath) {
        this.avatarPath = GameManager.avatarPath + avatarPath;
    }

    @Override
    public Move getChosenMove() {
        return chosenMove;
    }

    @Override
    public void setChosenMove(Move chosenMove) {
        this.chosenMove = chosenMove;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(PlayerType type) {
        this.type = type;
    }
}
