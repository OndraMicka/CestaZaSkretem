package core;

import commands.Command;
import features.ChestManager;

import java.util.Scanner;

public class ChestCommand implements Command {
    private ChestManager chestManager;

    public ChestCommand(ChestManager chestManager) {
        this.chestManager = chestManager;
    }
    @Override
    public String execute() {
        //todo
        return "neni hotovo";
    }
}
