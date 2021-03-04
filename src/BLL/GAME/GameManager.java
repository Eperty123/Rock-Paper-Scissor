package BLL.GAME;

import BE.ENUM.MoveType;
import BE.ENUM.ResultType;
import BE.GAME.GameState;
import BE.GAME.Result;
import BE.INTERFACE.IGameState;
import BE.INTERFACE.IPlayer;

import java.util.ArrayList;

/**
 * Manage game state and rules
 */
public class GameManager {

    private IGameState gameState;
    private IPlayer ai;
    private IPlayer player;
    private static GameManager instance;
    private Result currentRound;

    public static final String avatarPath = "/GUI/Pictures/avatar/";
    public static final String movePath = "/GUI/Pictures/moves/";

    public GameManager() {
        initialize();
    }

    /**
     * Initialize GameManager with IPlayers
     * expects Human vs Bot
     *
     * @param player
     * @param ai
     */
    public GameManager(IPlayer player, IPlayer ai) {
        initialize();
        setAi(ai);
        setPlayer(player);
    }

    private void initialize() {
        gameState = new GameState(new ArrayList<>(), 1);
    }

    /**
     * returns the result of different scenarios of the round
     *
     * @param humanMove
     * @return
     */
    public Result playRound(MoveType humanMove) {
        player.setChosenMove(humanMove);
        MoveType botMove = ai.doMove(gameState);
        ai.setChosenMove(botMove);

        Result result;
        int roundNumber = gameState.getRoundNumber();

        //Rules
        if (humanMove == botMove)
            result = new Result(player, ai, ResultType.Tie, humanMove, botMove, roundNumber);
        else if ((humanMove == MoveType.Rock && botMove == MoveType.Scissor) ||
                (humanMove == MoveType.Scissor && botMove == MoveType.Paper) ||
                (humanMove == MoveType.Paper && botMove == MoveType.Rock)) {
            result = new Result(player, ai, ResultType.Win, humanMove, botMove, roundNumber);
        } else {
            result = new Result(ai, player, ResultType.Win, botMove, humanMove, roundNumber);
        }
        gameState.setRoundNumber(++roundNumber);
        gameState.getMoveResults().add(result);

        currentRound = result;
        return result;
    }

    public IGameState getGameState() {
        return gameState;
    }

    public Result getCurrentRound() {
        return currentRound;
    }

    public void setGameState(IGameState gameState) {
        this.gameState = gameState;
    }

    public IPlayer getAi() {
        return ai;
    }

    public void setAi(IPlayer ai) {
        this.ai = ai;
    }

    public IPlayer getPlayer() {
        return player;
    }

    public void setPlayer(IPlayer human) {
        this.player = human;
    }

    public void start(IPlayer bot, IPlayer human) {
        initialize();
        setAi(bot);
        setPlayer(human);
    }


    /**
     * Get the proper path to the move specified.
     * @param move The chosen move.
     * @return Returns the image path to that move.
     */
    public String getMovePicturePath(MoveType move) {
        String result = null;
        switch (move) {
            case Rock -> result = "rock.png";
            case Paper -> result = "paper.png";
            case Scissor -> result = "scissor.png";
        }
        return movePath + result;
    }

    /**
     * Get the singleton instance.
     * @return  The active instance.
     */
    public static GameManager getInstance() {
        if (instance == null) instance = new GameManager();
        return instance;
    }
}
