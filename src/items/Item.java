package items;

import characters.GameCharacter;

import java.util.Random;

public class Item {
    private String name;
    private ItemType type;
    private MethodType method;
    private int healthAmount;
    private String id;
    private String info;
    private int durability;


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

    /**
     *
     * @param attacker Game character who is attacking
     * @param attacked Game character who is attacked
     */

    public void use(GameCharacter attacker,GameCharacter attacked) {
        Random rd = new Random();
        switch (method){
            case HEAL -> attacker.setHealth(attacker.getHealth()+healthAmount);
            case ATTACK -> attacked.setHealth(attacked.getHealth()-healthAmount);
            case BOW -> {
                if(!(rd.nextInt(3)==0)){
                    attacked.setHealth(attacked.getHealth()-healthAmount);
                }
            }
            case MAGIC_WAND -> {
                if(rd.nextInt(3)==0){
                    attacker.setHealth(attacker.getHealth()-healthAmount);
                }else {
                    attacked.setHealth(attacked.getHealth()-healthAmount);
                }
            }
            case LUCKY_POTION -> {
                if(rd.nextBoolean()){
                    attacker.setHealth(attacker.getHealth()+healthAmount);
                }else {
                    attacker.setHealth(attacker.getHealth()-healthAmount);
                }
            }
            case SILVER_SWORD -> {
                if(attacked.getName().equals("Skřet")){
                    attacked.setHealth(attacked.getHealth()-40);
                }else {
                    attacked.setHealth(attacked.getHealth()-healthAmount);
                }
            }
            default -> throw new IllegalArgumentException("invalid method: " + method);
        }
    }


}
