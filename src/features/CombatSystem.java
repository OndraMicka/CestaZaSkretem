package features;

import characters.Enemy;
import characters.Player;

import java.util.Scanner;

/**
 * Controls fight of player and enemy.
 * Called in FightCommand.
 */
public class CombatSystem {
    private Player player;
    private Enemy enemy;

    public CombatSystem(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    /**
     * Controls fighting.
     * Prints health of both player and enemy, lets player chose item to use, enemy uses item.
     * If enemy or player dies ends loop.
     * @return Info if player won or died.
     */
    public boolean startFight() {
        player.setHealth(player.getMaxHealth());
        while (player.getHealth() > 0 & enemy.getHealth() > 0) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\n" + player.getName() + ": " + player.getHealth());
            System.out.println(enemy.getName() + ": " + enemy.getHealth() + "\n");
            System.out.println(player.getInventory());
            System.out.println("Zadej číslo předmětu, který chceš použít(0 = nepoužít nic).");
            int choice = 0;
            do {
                System.out.print(">>");
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                } catch (Exception _) {
                }
            } while (choice==0||!player.getInventory().use(choice - 1, player, enemy));

            if (enemy.getHealth() > 0) {
                if (enemy.getHealth() > 40) {
                    enemy.getInventory().use(enemy.getInventory().getSize() - 1, enemy, player);
                } else {
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
