package commands;

import core.Game;
import rooms.FightRoom;

/**
 * implements Command, method execute to go to next room
 */
public class MoveCommand implements Command {
    private final Game game;

    public MoveCommand(Game game) {
        this.game = game;
    }

    /**
     * Go to next room.
     * If player is in fight room and the enemy is dead, he can go.
     * If player is in item room, he can go to the next room.
     *
     * @return message for player if he can skip.
     */
    @Override
    public String execute() {
        if (game.getCurrentRoom().getClass() == FightRoom.class) {
            FightRoom fightRoom = (FightRoom) game.getCurrentRoom();
            if (fightRoom.getEnemy().getHealth() > 0) {
                return "*První musiš zabít příšeru.";
            }
        }
        game.goToNextRoom();
        return "*Jdeš dál.";
    }
}
