package BE.PLAYER;

import BE.ENUM.MoveType;
import BE.INTERFACE.IGameState;
import BE.GAME.Result;
import BE.INTERFACE.IPlayer;

import java.util.*;

public class Ai extends Player {
    private AIBrain brain;

    public Ai() {
        super();
    }

    public Ai(String name, String avatarPath, IPlayer opponent) {
        setName(name);
        setAvatarPath(avatarPath);
        brain = new AIBrain(opponent.getMoves(),0);
    }

    public AIBrain getBrain() {
        return brain;
    }

    @Override
    public MoveType doMove(IGameState state) {
        return getBrain().getOptMove();
    }
}
