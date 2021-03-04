package BE.INTERFACE;
//Imports

import BE.ENUM.Move;
import BE.GAME.IGameState;
import BE.ENUM.PlayerType;


/**
 * Determines the player and its strategy
 */
public interface IPlayer {

    /**
     * Get the player name
     *
     * @return the player name
     */
    public String getPlayerName();

    /**
     * Get the player type
     *
     * @return player type
     */
    public PlayerType getPlayerType();

    /**
     * Get the avatar path
     * @return
     */
    public String getAvatarPath();

    /**
     * Set the avatar path
     * @param avatarPath
     */
    public void setAvatarPath(String avatarPath);

    /**
     * Get the chosen move
     * @return
     */
    public Move getChosenMove();

    /**
     * Set the current move
     * @param chosenMove
     */
    public void setChosenMove(Move chosenMove);

    /**
     * Makes a move
     *
     * @param state
     * @return a move
     */
    public Move doMove(IGameState state);
}
