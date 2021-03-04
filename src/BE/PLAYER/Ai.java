package BE.PLAYER;

import BE.ENUM.MoveType;
import BE.INTERFACE.IGameState;
import BE.GAME.Result;

import java.util.ArrayList;

public class Ai extends Player {
    private AIBrain brain;

    private void initialize() {
        brain = new AIBrain();
        var moves = new ArrayList<MoveType>();
        moves.add(MoveType.Rock);
        moves.add(MoveType.Paper);
        moves.add(MoveType.Scissor);
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
    public MoveType doMove(IGameState state) {

        ArrayList<Result> moveResults = (ArrayList<Result>) state.getMoveResults();

        // Make the ai decide which move it does. DP please elaborate how your AIBrain class works.
        return getBrain().getOptMove();
    }
}
