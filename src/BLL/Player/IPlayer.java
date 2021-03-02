package BLL.Player;
//Imports
import BE.ENUM.Move;
import BLL.Game.IGameState;


/**
 * Determines the player and its strategy
 */
public interface IPlayer {

    /**
     * Get the player name
     * @return the player name
     */
    public String getPlayerName();

    /**
     * Get the player type
     * @return player type
     */
    public PlayerType getPlayerType();

    /**
     * Makes a move
     * @param state
     * @return a move
     */
    public Move doMove(IGameState state);
}
