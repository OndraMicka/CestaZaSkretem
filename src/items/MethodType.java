package items;

import java.io.Serializable;

/**
 * Some items have spacial effect.
 * Each value represents different effect logic applied in Item.use().
 */
public enum MethodType  implements Serializable {
    HEAL,ATTACK,LUCKY_POTION,BOW,MAGIC_WAND,SILVER_SWORD
}
