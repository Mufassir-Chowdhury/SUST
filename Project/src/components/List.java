package Components;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;

import Common.pages.Page;
import Constants.Colors;
import Constants.Fonts;
import Constants.Padding;
import Constants.Sizes;

import java.awt.Graphics;
import java.awt.Color;
import java.util.Vector;

import java.awt.Component;

public class List<E> extends JList<E> {
    public List(Vector<E> list, boolean hasIcon, int selectionModel) {
        super(list);
        setAlignmentX(Component.LEFT_ALIGNMENT);
        setSelectionMode(selectionModel);
        setOpaque(false);
        setFixedCellWidth(Sizes.LIST_ITEM_WIDTH);
        setCellRenderer(new DefaultListCellRenderer() {
            Color border = null;
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (renderer instanceof JLabel) {
                    ((JLabel) renderer).setText(value.toString());
                    ((JLabel) renderer).setFont(Fonts.BODY);
                    if(hasIcon){
                        ((JLabel) renderer).setIcon(((Page)value).icon);
                    }
                    ((JLabel) renderer).setOpaque(false);
                    ((JLabel) renderer).setForeground(Colors.PLAIN_TEXT);
                    ((JLabel) renderer).setAlignmentX(Component.LEFT_ALIGNMENT);
                    ((JLabel) renderer).setIconTextGap(20);
                    ((JLabel) renderer).setBorder(Padding.LIST);
                    if(isSelected){
                        border = Colors.Theme.ACCENT;
                        ((JLabel) renderer).setOpaque(true);
                        ((JLabel) renderer).setBackground(Colors.LIST_ITEM_HOVER);
                    }
                    if(!isSelected){
                        border = null;
                        repaint();
                    }
                    
                }
                return renderer;
            }
            @Override
            protected void paintBorder(Graphics g) {
                if(border != null){
                    g.setColor(border);
                    g.fillRoundRect(0, 10, 4, getHeight() - 20, 2, 3);
                }
            }
        });
    }
}
