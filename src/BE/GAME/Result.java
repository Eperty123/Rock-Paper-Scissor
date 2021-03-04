package BE.GAME;


import BE.ENUM.MoveType;
import BE.ENUM.ResultType;
import BE.INTERFACE.IPlayer;

/**
 * defining the result of a game
 */
public class Result {

    private ResultType type;
    private MoveType winnerMove;
    private MoveType loserMove;
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
    public Result(IPlayer winnerPlayer, IPlayer loserPlayer, ResultType type, MoveType winnerMove, MoveType loserMove, int roundNumber) {
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

    public MoveType getWinnerMove() {
        return winnerMove;
    }

    public MoveType getLoserMove() {
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

    public void setWinnerMove(MoveType winnerMove) {
        this.winnerMove = winnerMove;
    }

    public void setLoserMove(MoveType loserMove) {
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
