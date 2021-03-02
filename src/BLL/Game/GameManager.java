package BLL.Game;

import BE.ENUM.Move;
import BLL.Player.IPlayer;
import java.util.ArrayList;

/**
 * Manage game state and rules
 */
public class GameManager {

    private IGameState gameState;
    private IPlayer bot;
    private IPlayer human;

    /**
     * Initialize GameManager with IPlayers
     * expects Human vs Bot
     *
     * @param human
     * @param bot
     */
    public GameManager(IPlayer human, IPlayer bot) {
        gameState = new GameState(new ArrayList<>(), 1);
        this.human = human;
        this.bot = bot;
    }

    /**
     * returns the result of different scenarios of the round
     * @param humanMove
     * @return
     */
    public Result playRound(Move humanMove) {
        Move botMove = bot.doMove((GameState) gameState);
        Result result;
        int roundNumber = gameState.getRoundNumber();

        //Rules
        if (humanMove == botMove)
            result = new Result(human, bot,ResultType.Tie, humanMove, botMove,roundNumber);
        else if ((humanMove == Move.Rock && botMove == Move.Scissor)||
                (humanMove == Move.Scissor && botMove == Move.Paper)||
                (humanMove == Move.Paper && botMove == Move.Rock)) {
            result = new Result(human, bot, ResultType.Win, humanMove, botMove, roundNumber);
        }else {
            result = new Result(bot, human, ResultType.Win, botMove, humanMove, roundNumber);
        }
        gameState.setRoundNumber(++roundNumber);
        gameState.getMoveResults().add(result);

        return result;
    }
    public IGameState getGameState(){
        return gameState;
    }

}
