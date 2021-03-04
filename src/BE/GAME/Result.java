package BE.GAME;


import BE.ENUM.Move;
import BE.INTERFACE.IPlayer;

/**
 * defining the result of a game
 */
public class Result {

    private ResultType type;
    private Move winnerMove;
    private Move loserMove;
    private IPlayer winnerPlayer;
    private IPlayer loserPlayer;
    private int roundNumber;

    public Result() {
    }

    /**
     * New result with winner, loser + moves and type
     *
     * @param winnerPlayer
     * @param loserPlayer
     * @param type
     * @param winnerMove
     * @param loserMove
     * @param roundNumber
     */
    public Result(IPlayer winnerPlayer, IPlayer loserPlayer, ResultType type, Move winnerMove, Move loserMove, int roundNumber) {
        this.winnerPlayer = winnerPlayer;
        this.loserPlayer = loserPlayer;
        this.type = type;
        this.winnerMove = winnerMove;
        this.loserMove = loserMove;
        this.roundNumber = roundNumber;
    }

    public ResultType getType() {
        return type;
    }

    public Move getWinnerMove() {
        return winnerMove;
    }

    public Move getLoserMove() {
        return loserMove;
    }

    public IPlayer getWinnerPlayer() {
        return winnerPlayer;
    }

    public IPlayer getLoserPlayer() {
        return loserPlayer;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public void setType(ResultType type) {
        this.type = type;
    }

    public void setWinnerMove(Move winnerMove) {
        this.winnerMove = winnerMove;
    }

    public void setLoserMove(Move loserMove) {
        this.loserMove = loserMove;
    }

    public void setWinnerPlayer(IPlayer winnerPlayer) {
        this.winnerPlayer = winnerPlayer;
    }

    public void setLoserPlayer(IPlayer loserPlayer) {
        this.loserPlayer = loserPlayer;
    }

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }
}
