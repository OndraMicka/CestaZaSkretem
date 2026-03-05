package items;

import characters.GameCharacter;

import java.io.Serializable;
import java.util.Random;
/**
 * Represents usable game item.
 * Item can heal, deal damage or apply special effects depending on MethodType.
 * Each item has durability, represents how many times can player item use.
 */
public class Item implements Serializable {
    private String name;
    private ItemType type;
    private MethodType method;
    private int healthAmount;
    private String id;
    private String info;
    private int durability;

    /**
     * Creates copy of item.
     * @return new Item instance with the same values
     */
    public Item copyOfItem() {
        Item newItem = new Item();
        newItem.name = this.name;
        newItem.type = this.type;
        newItem.method = this.method;
        newItem.healthAmount = this.healthAmount;
        newItem.id = this.id;
        newItem.info = this.info;
        newItem.durability = this.durability;
        return newItem;

    }
    /**
     * Returns formatted string used for printing item in console.
     * @return printable item info or null if something wrong
     */
    public String getPrintInfo() {
        try {
            if (getType() == ItemType.HEAL) {
                return getDurability() + "x " + getInfo();
            } else {
                return getInfo() + ", životnost: " + getDurability();
            }
        } catch (NullPointerException _) {
            return null;
        }
    }


     /**
     * Uses item and applies its effect.
     * Effect depends on MethodType.
     *
     * @param attacker Game character who is attacking
     * @param attacked Game character who is attacked
     */

    public void use(GameCharacter attacker, GameCharacter attacked) {
        Random rd = new Random();
        switch (method) {
            case HEAL -> attacker.setHealth(attacker.getHealth() + healthAmount);
            case ATTACK -> attacked.setHealth(attacked.getHealth() - healthAmount);
            case BOW -> {
                // 2/3 chance to hit
                if (!(rd.nextInt(3) == 0)) {
                    attacked.setHealth(attacked.getHealth() - healthAmount);
                }
            }
            case MAGIC_WAND -> {
                // 1/3 chance to hurt attacker instead
                if (rd.nextInt(3) == 0) {
                    attacker.setHealth(attacker.getHealth() - healthAmount);
                } else {
                    attacked.setHealth(attacked.getHealth() - healthAmount);
                }
            }
            case LUCKY_POTION -> {
                // 50% heal / 50% damage self
                if (rd.nextBoolean()) {
                    attacker.setHealth(attacker.getHealth() + healthAmount);
                } else {
                    attacker.setHealth(attacker.getHealth() - healthAmount);
                }
            }
            case SILVER_SWORD -> {
                // bonus damage to goblin
                if (attacked.getName().equals("Skřet")) {
                    attacked.setHealth(attacked.getHealth() - 40);
                } else {
                    attacked.setHealth(attacked.getHealth() - healthAmount);
                }
            }
            default -> throw new IllegalArgumentException("invalid method: " + method);
        }
    }


    public String getInfo() {
        return info;
    }

    public String getName() {
        return name;
    }

    public ItemType getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }


    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", id='" + id + '\'' +
                ", info='" + info + '\'' +
                ", durability=" + durability +
                '}';
    }

    public MethodType getMethod() {
        return method;
    }

    public void setMethod(MethodType method) {
        this.method = method;
    }

    public int getHealthAmount() {
        return healthAmount;
    }

    public void setHealthAmount(int healthAmount) {
        this.healthAmount = healthAmount;
    }

    public void setName(String name) {
        this.name = name;
    }
}
