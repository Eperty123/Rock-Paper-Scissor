package BE.PLAYER;

import BE.ENUM.MoveType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AIBrain {
    /**
     * The random instance
     */
    Random r = new Random();

    /**
     * The percentage of randomness
     */
    double randomness = 0;

    /**
     * A list of the opponents moves
     */
    List<MoveType> moveList = new ArrayList<>();

    /**
     * Creates a brain with an empty list of moves
     * with 0 randomness
     */
    public AIBrain() {
        this.randomness = randomness;
    }

    /**
     * Creates a brain with an empty list of moves
     * and a given randomness
     *
     * @param randomness the randomness percentage
     */
    public AIBrain(double randomness) {
        this.randomness = randomness;
    }

    /**
     * Creates a Brain with a list of played moves
     * And a given randomness percentage
     *
     * @param randomness the randomness percentage
     * @param moveList A list of the opponents moves
     */
    public AIBrain(List<MoveType> moveList, double randomness) {
        this.moveList = moveList;
        this.randomness = randomness;
    }

    /**
     * Gets the randomness
     *
     * @return the randomness percentage
     */
    public double getRandomness() {
        return randomness;
    }

    /**
     * sets the randomness
     *
     * @param randomness the randomness percentage
     */
    public void setRandomness(double randomness) {
        this.randomness = randomness;
    }

    /**
     * Gets the list of moves in the Brain
     *
     * @return a list of moves
     */
    public List<MoveType> getMoveList() {
        return moveList;
    }

    /**
     * Sets the list of the opponents moves in the Brain
     *
     * @param moveList the moves
     */
    public void setMoveList(List<MoveType> moveList) {
        this.moveList = moveList;
    }

    /**
     * Gets a random move
     *
     * @return a random move
     */
    private MoveType getRandomMove() {
        switch (r.nextInt(3)) {
            case (1) -> {
                return MoveType.Rock;
            }
            case (2) -> {
                return MoveType.Scissor;
            }
            default -> {
                return MoveType.Paper;
            }
        }
    }

    /**
     * If the list of opponents moves is empty it picks a random move
     * otherwise it picks a random move to counter
     * If a specific move often is played that move has a higher change of getting countered, since that move will be more frequent in the list
     *
     * @return a countermove
     */
    public MoveType getOptMove() {
        if (moveList.isEmpty() || randomness / r.nextInt(100) > 1) {
            return getRandomMove();
        } else {
            var rep = lookForRepetition(4, moveList);
            if (rep != null)
                return rep;
            return counterMove(moveList.get(r.nextInt(moveList.size())));
        }
    }

    /**
     * If the list of moves is empty it picks a random move
     * otherwise it picks a random move to counter
     * If a specific move often is played that move has a higher change of getting countered, since that move will be more frequent in the list
     *
     * @param moveList the list of the opponents moves
     * @return a countermove
     */
    public MoveType getOptMove(List<MoveType> moveList) {
        int random = r.nextInt(3) + 1;
        if (moveList.isEmpty() || randomness / r.nextInt(100) > 1) {
            return getRandomMove();
        } else {
            var rep = lookForRepetition(4, moveList);
            if (rep != null)
                return rep;
            return counterMove(moveList.get(r.nextInt(moveList.size())));
        }
    }

    /**
     * Gets the counter to a move
     *
     * @param moveToCounter the move to counter
     * @return A move that beats the moveToCounter
     */
    public MoveType counterMove(MoveType moveToCounter) {
        if (moveToCounter.equals(MoveType.Rock))
            return MoveType.Paper;
        else if (moveToCounter.equals(MoveType.Scissor))
            return MoveType.Rock;
        else
            return MoveType.Scissor;
    }

    /**
     * Looks for repetitions in the moveList
     *
     * @param minSize  The minimal size of moveList for it to look for repetitions
     * @param moveList A list of the opponents moves
     * @return A counter move or null if no repetitions
     */
    public MoveType lookForRepetition(int minSize, List<MoveType> moveList) {
        if (moveList.size() >= minSize) {
            //Shifts the end point
            for (int i = minSize / 2; i < moveList.size() / 2; i++) {
                //Shifts the starting point
                for (int j = 0; j < i; j++) {
                    //Checks for matches
                    if (moveList.subList(j, i).equals(moveList.subList(i + j, 2 * i))) {
                        return counterMove(moveList.get(j));
                    }
                }
            }
        }
        return null;
    }
}
