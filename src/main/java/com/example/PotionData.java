package com.example;

import net.runelite.api.ItemID;
import java.util.HashMap;
import java.util.Map;

public class PotionData
{

    public static class Potion
    {
        public final String name;
        public final double xp;

        public Potion(String name, double xp)
        {
            this.name = name;
            this.xp = xp;
        }
    }

    private static final Map<Integer, Potion> DATA = new HashMap<>();

    static
    {
        DATA.put(ItemID.GRIMY_RANARR_WEED, new Potion("Prayer potion", 87.5));
        DATA.put(ItemID.RANARR_WEED, new Potion("Prayer potion", 87.5));

        DATA.put(ItemID.GRIMY_IRIT_LEAF, new Potion("Super attack", 100));
        DATA.put(ItemID.IRIT_LEAF, new Potion("Super attack", 100));

        DATA.put(ItemID.GRIMY_KWUARM, new Potion("Super strength", 125));
        DATA.put(ItemID.KWUARM, new Potion("Super strength", 125));
    }

    public static Potion getPotion(int itemId)
    {
        return DATA.get(itemId);
    }

}