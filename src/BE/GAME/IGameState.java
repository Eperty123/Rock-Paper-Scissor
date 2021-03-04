package BE.GAME;

import java.util.Collection;

/**
 * Interface definition for game state
 */
public interface IGameState {
    /**
     * Get the round number
     * @return
     */
    int getRoundNumber();

    /**
     * Sets the round number
     * @param i
     */
    void setRoundNumber(int i);

    /**
     * Return previous results in a collection
     * @return
     */
    Collection<Result> getMoveResults();
}
