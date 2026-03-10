package com.example;

import net.runelite.api.ItemID;
import java.util.HashMap;
import java.util.Map;

public class HerbData
{


public static class HerbInfo
{
    int itemId;
    String herb;
    String potion;
    double xp;
    int potionItemId;

    public HerbInfo(int itemId,String herb,String potion,double xp,int potionItemId)
    {
        this.itemId = itemId;
        this.herb = herb;
        this.potion = potion;
        this.xp = xp;
        this.potionItemId = potionItemId;
    }
}

public static final Map<Integer,HerbInfo> DATA = new HashMap<>();

static
{

    DATA.put(ItemID.GRIMY_RANARR_WEED,
            new HerbInfo(
                    ItemID.RANARR_WEED,
                    "Ranarr weed",
                    "Prayer potion",
                    87.5,
                    ItemID.PRAYER_POTION4
            ));

    DATA.put(ItemID.RANARR_WEED,
            new HerbInfo(
                    ItemID.RANARR_WEED,
                    "Ranarr weed",
                    "Prayer potion",
                    87.5,
                    ItemID.PRAYER_POTION4
            ));

    DATA.put(ItemID.GRIMY_KWUARM,
            new HerbInfo(
                    ItemID.KWUARM,
                    "Kwuarm",
                    "Super strength",
                    125,
                    ItemID.SUPER_STRENGTH4
            ));

    DATA.put(ItemID.KWUARM,
            new HerbInfo(
                    ItemID.KWUARM,
                    "Kwuarm",
                    "Super strength",
                    125,
                    ItemID.SUPER_STRENGTH4
            ));

    DATA.put(ItemID.GRIMY_DWARF_WEED,
            new HerbInfo(
                    ItemID.DWARF_WEED,
                    "Dwarf weed",
                    "Ranging potion",
                    162.5,
                    ItemID.RANGING_POTION4
            ));

    DATA.put(ItemID.DWARF_WEED,
            new HerbInfo(
                    ItemID.DWARF_WEED,
                    "Dwarf weed",
                    "Ranging potion",
                    162.5,
                    ItemID.RANGING_POTION4
            ));

    DATA.put(ItemID.GRIMY_LANTADYME,
            new HerbInfo(
                    ItemID.LANTADYME,
                    "Lantadyme",
                    "Antifire potion",
                    157.5,
                    ItemID.ANTIFIRE_POTION4
            ));

    DATA.put(ItemID.LANTADYME,
            new HerbInfo(
                    ItemID.LANTADYME,
                    "Lantadyme",
                    "Antifire potion",
                    157.5,
                    ItemID.ANTIFIRE_POTION4
            ));

    DATA.put(ItemID.GRIMY_CADANTINE,
            new HerbInfo(
                    ItemID.CADANTINE,
                    "Cadantine",
                    "Super defence",
                    150,
                    ItemID.SUPER_DEFENCE4
            ));

    DATA.put(ItemID.CADANTINE,
            new HerbInfo(
                    ItemID.CADANTINE,
                    "Cadantine",
                    "Super defence",
                    150,
                    ItemID.SUPER_DEFENCE4
            ));

}


}
