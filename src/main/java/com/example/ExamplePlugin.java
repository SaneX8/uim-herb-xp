package com.example;

import com.google.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;




@PluginDescriptor(name = "UIM Herb XP")
public class ExamplePlugin extends Plugin
{


@Inject
private Client client;

@Inject
private ClientThread clientThread;

@Inject
private ClientToolbar clientToolbar;

@Inject
private ItemManager itemManager;

private HerbPanel panel;
private NavigationButton navButton;

@Override
protected void startUp() throws Exception
{

    panel = new HerbPanel();

    panel.getScanButton().addActionListener(e ->
            clientThread.invoke(this::scan)
    );

    BufferedImage icon = ImageIO.read(
        getClass().getResourceAsStream("/com/example/icon.png")
);

    navButton = NavigationButton.builder()
            .tooltip("UIM Herb XP")
            .icon(icon)
            .panel(panel)
            .build();

    clientToolbar.addNavigation(navButton);

}



private void scan()
{

    Map<String,Integer> counts = new HashMap<>();
    Map<String,HerbData.HerbInfo> herbInfo = new HashMap<>();

    ItemContainer inv = client.getItemContainer(InventoryID.INVENTORY);

    if(inv != null)
    {
        for(Item item : inv.getItems())
        {
            process(item.getId(), item.getQuantity(), counts, herbInfo);
        }
    }

    Widget bag = client.getWidget(WidgetInfo.LOOTING_BAG_CONTAINER);

    if(bag != null)
    {
        for(Widget item : bag.getDynamicChildren())
        {
            process(item.getItemId(), item.getItemQuantity(), counts, herbInfo);
        }
    }

    panel.clear();

    double total = 0;

    for(String herb : counts.keySet())
    {

        int qty = counts.get(herb);
        HerbData.HerbInfo info = herbInfo.get(herb);

        double xp = qty * info.xp;

        ImageIcon icon = new ImageIcon(
                itemManager.getImage(info.itemId)
        );

        ImageIcon herbIcon = new ImageIcon(itemManager.getImage(info.itemId));
ImageIcon potionIcon = new ImageIcon(itemManager.getImage(info.potionItemId));

panel.addRow(herbIcon, info.herb, potionIcon, xp);

        total += xp;

    }

    panel.setTotalXp(total);

}

private void process(
        int id,
        int qty,
        Map<String,Integer> counts,
        Map<String,HerbData.HerbInfo> herbInfo
)
{

    HerbData.HerbInfo info = HerbData.DATA.get(id);

    if(info == null)
    {
        return;
    }

    counts.put(
            info.herb,
            counts.getOrDefault(info.herb,0) + qty
    );

    herbInfo.put(info.herb, info);

}

@Override
protected void shutDown()
{
    clientToolbar.removeNavigation(navButton);
}


}
