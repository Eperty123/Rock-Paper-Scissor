package BE.PLAYER;

import BE.ENUM.Move;
import BE.GAME.IGameState;
import BE.GAME.Result;

import java.util.ArrayList;

public class Ai extends Player {
    private AIBrain brain;

    private void initialize() {
        brain = new AIBrain();
        var moves = new ArrayList<Move>();
        moves.add(Move.Rock);
        moves.add(Move.Paper);
        moves.add(Move.Scissor);
        brain.setMoveList(moves);
    }

    public Ai() {
        super();
        initialize();
    }

    public Ai(String name, String avatarPath) {
        initialize();
        setName(name);
        setAvatarPath(avatarPath);
    }

    public AIBrain getBrain() {
        return brain;
    }

    @Override
    public Move doMove(IGameState state) {

        ArrayList<Result> moveResults = (ArrayList<Result>) state.getMoveResults();

        // Make the ai decide which move it does. DP please elaborate how your AIBrain class works.
        return getBrain().getOptMove();
    }
}
