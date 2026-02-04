package commands;

import core.Game;
import features.CombatSystem;
import rooms.FightRoom;
import rooms.ItemRoom;

public class FightCommand implements Command {
    private Game game;
    private boolean exit = false;
    private CombatSystem combatSystem;

    public FightCommand(Game game) {
        this.game = game;
    }

    @Override
    public String execute() {
        if (game.getCurrentRoom().getClass().equals(FightRoom.class)) {
            FightRoom room = (FightRoom) game.getCurrentRoom();
            if (room.getEnemy().getHealth()>0) {
                combatSystem =new CombatSystem(game.getPlayer(), ((FightRoom) game.getCurrentRoom()).getEnemy());
                exit = !combatSystem.startFight();
                return "";
            } else {
                return "*Už jsi stvůru zabil.";
            }
        } else {
            return "*Nemáš s kým bojovat..";
        }
    }

    @Override
    public boolean exit() {
        return exit;
    }

}
