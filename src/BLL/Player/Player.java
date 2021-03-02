package BLL.Player;
import BE.ENUM.Move;
import BLL.Game.IGameState;
import BLL.Game.Result;

import java.util.ArrayList;

public class Player implements IPlayer{

    private String name;
    private PlayerType type;

    public Player(String name, PlayerType type){
        this.name = name;
        this.type = type;
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
     * @param state contains game state, with previous results
     * @return Next move
     */
    @Override
    public Move doMove(IGameState state) {

        ArrayList<Result> moveResults = (ArrayList<Result>) state.getMoveResults();

        return Move.Rock;

    }
}
