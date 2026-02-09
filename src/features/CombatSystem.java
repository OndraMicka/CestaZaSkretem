package features;

import characters.Enemy;
import characters.Player;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CombatSystem {
    private Player player;
    private Enemy enemy;

    public CombatSystem(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    public boolean startFight() {
        while (player.getHealth() > 0 & enemy.getHealth() > 0) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\n"+player.getName()+": " + player.getHealth());
            System.out.println(enemy.getName() + ": " + enemy.getHealth() + "\n");
            System.out.println(player.getInventory());
            System.out.println("Zadej číslo předmětu, který chceš použít.");
            int choice = 0;
            do {
                System.out.print(">>");
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                } catch (Exception _) {}
            }while (!player.getInventory().use(choice - 1, player, enemy));

            if (enemy.getHealth() > 0) {
                if (enemy.getHealth() > 40) {
                    enemy.getInventory().use(enemy.getInventory().getSize()-1, enemy, player);
                }else {
                    enemy.getInventory().use(0, enemy, player);
                }

            } else {
                System.out.println("Porazil jsi stvůru.");
                return true;
            }
        }
        System.out.println("Umřel jsi.");
        return false;
    }
}
