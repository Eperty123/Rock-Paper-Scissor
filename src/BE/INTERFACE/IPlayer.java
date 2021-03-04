package BE.INTERFACE;
//Imports

import BE.ENUM.MoveType;
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
    public MoveType getChosenMove();

    /**
     * Set the current move
     * @param chosenMove
     */
    public void setChosenMove(MoveType chosenMove);

    /**
     * Makes a move
     *
     * @param state
     * @return a move
     */
    public MoveType doMove(IGameState state);
}
