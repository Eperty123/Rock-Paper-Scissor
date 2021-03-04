package BE.PLAYER;

import BE.ENUM.MoveType;
import BLL.GAME.GameManager;
import BE.INTERFACE.IGameState;
import BE.ENUM.PlayerType;
import BE.INTERFACE.IPlayer;
import java.util.ArrayList;
import java.util.List;

public class Player implements IPlayer {

    private String name;
    private PlayerType type;
    private String avatarPath;
    private MoveType chosenMove;
    private List<MoveType> moves = new ArrayList<>();

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
     * @return Next move
     */
    @Override
    public MoveType doMove(IGameState gameState) {
        return chosenMove;
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
    public MoveType getChosenMove() {
        return chosenMove;
    }

    @Override
    public void setChosenMove(MoveType chosenMove) {
        this.chosenMove = chosenMove;
        moves.add(chosenMove);
    }

    @Override
    public List<MoveType> getMoves() {
        return moves;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(PlayerType type) {
        this.type = type;
    }
}
