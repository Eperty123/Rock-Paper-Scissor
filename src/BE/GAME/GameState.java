package BE.GAME;


import BE.INTERFACE.IGameState;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Tracking game state and results
 */
public class GameState implements IGameState {

    private ArrayList<Result> moveResults;
    private int roundNumber;

    /**
     * Current game state
     * @param moveResults
     * @param roundNumber
     */
    public GameState(ArrayList<Result> moveResults, int roundNumber) {
        this.moveResults = new ArrayList<>();
        this.roundNumber = roundNumber;
    }

    /**
     * gets the round number
     * @return the round number
     */
    @Override
    public int getRoundNumber() {
        return roundNumber;
    }

    /**
     * sets the round number
     * @return round number
     * @param i
     */
    @Override
    public void setRoundNumber(int i) {
        this.roundNumber = roundNumber;
    }

    /**
     * gets previous results
     * @return list of results
     */
    @Override
    public Collection<Result> getMoveResults() {
        return moveResults;
    }
}
