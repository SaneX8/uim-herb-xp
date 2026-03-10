package com.example;

import net.runelite.client.ui.PluginPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class HerbPanel extends PluginPanel
{


private final DefaultTableModel model;
private final JTable table;
private final JLabel totalXp = new JLabel("Total Herblore XP: 0");
private final JButton scanButton = new JButton("Scan Herbs");

public HerbPanel()
{

    setLayout(new BorderLayout());

    model = new DefaultTableModel(
            new Object[]{"", "H", "", "XP"},
            0
    )
    {
        @Override
        public boolean isCellEditable(int row,int column)
        {
            return false;
        }
    };

    table = new JTable(model);
    table.setTableHeader(null);
    table.setRowHeight(36);
    table.setShowGrid(false);
    table.setIntercellSpacing(new Dimension(0,4));

    // icon renderer
    DefaultTableCellRenderer iconRenderer = new DefaultTableCellRenderer()
    {
        @Override
        protected void setValue(Object value)
        {
            if(value instanceof ImageIcon)
            {
                setIcon((ImageIcon)value);
                setText("");
            }
            else
            {
                setIcon(null);
                super.setValue(value);
            }
        }
    };

    table.getColumnModel().getColumn(0).setCellRenderer(iconRenderer);
    table.getColumnModel().getColumn(2).setCellRenderer(iconRenderer);

    table.getColumnModel().getColumn(0).setMaxWidth(40);
    table.getColumnModel().getColumn(2).setMaxWidth(40);

    JScrollPane scroll = new JScrollPane(table);

    JPanel top = new JPanel(new BorderLayout());
    top.add(scanButton,BorderLayout.CENTER);

    JPanel bottom = new JPanel(new BorderLayout());
    bottom.add(totalXp,BorderLayout.WEST);

    add(top,BorderLayout.NORTH);
    add(scroll,BorderLayout.CENTER);
    add(bottom,BorderLayout.SOUTH);

}

public JButton getScanButton()
{
    return scanButton;
}

public void clear()
{
    model.setRowCount(0);
}

public void addRow(ImageIcon herbIcon,String herb,ImageIcon potionIcon,double xp)
{

    String letter = herb.substring(0,1).toUpperCase();

    String xpText;

    if(xp % 1 == 0)
    {
        xpText = String.valueOf((int)xp);
    }
    else
    {
        xpText = String.format("%.1f",xp);
    }

    model.addRow(new Object[]{
            herbIcon,
            letter,
            potionIcon,
            xpText
    });

}

public void setTotalXp(double xp)
{

    String xpText;

    if(xp % 1 == 0)
    {
        xpText = String.valueOf((int)xp);
    }
    else
    {
        xpText = String.format("%.1f",xp);
    }

    totalXp.setText("Total Herblore XP: " + xpText);

}


}
