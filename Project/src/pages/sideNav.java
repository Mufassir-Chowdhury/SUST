package pages;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;
import java.awt.Graphics;
import javax.swing.border.EmptyBorder;
import Components.Label;
import Components.InputFields.TextField;
import Components.InputFields.TextField.TYPE;
import Constants.Colors;
import Constants.Fonts;
import Constants.Icons;
import Server.Datapoints;

import javax.swing.DefaultListCellRenderer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Insets;
import java.io.IOException;
import java.util.Vector;

public class sideNav extends JPanel {
    JList<Datapoints.Page> list;
    Vector<String> pageNames;

    public void setSelected(String nameOfPage){
        list.setSelectedIndex(pageNames.indexOf(nameOfPage));
        list.repaint();
    }
    public sideNav(sideNavView view) throws ClassNotFoundException, IOException {
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Box line = Box.createHorizontalBox();
        line.setAlignmentX(Component.LEFT_ALIGNMENT);
        line.add(Box.createHorizontalStrut(5));

        TextField searchField = new TextField("Search", TYPE.PLAIN);
        searchField.addMouseListener(searchField);
        searchField.addFocusListener(searchField);
        searchField.addKeyListener(searchField);
        searchField.setMaximumSize(new Dimension(288, 32));
        line.add(searchField);
        line.add(Box.createHorizontalStrut(5));
        add(line);
        add(Box.createVerticalStrut(10));
        Vector<Datapoints.Page> pageList = new Vector<>();
        pageNames = new Vector<>();
        for(Datapoints.Page[] page: Datapoints.getInstance().getPages()){
            for(Datapoints.Page pair: page){
                pageList.add(pair);
                pageNames.add(pair.name);
            }
        }
        list = new JList<>(pageList);
        list.setAlignmentX(Component.LEFT_ALIGNMENT);
        list.setOpaque(false);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setFixedCellWidth(300);
        list.setCellRenderer(new DefaultListCellRenderer() {
            Color border = null;
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (renderer instanceof JLabel && value instanceof Datapoints.Page) {
                    ((JLabel) renderer).setText(((Datapoints.Page) value).name);
                    ((JLabel) renderer).setFont(Fonts.Body);
                    ((JLabel) renderer).setIcon(((Datapoints.Page) value).icon);
                    ((JLabel) renderer).setOpaque(false);
                    ((JLabel) renderer).setForeground(Colors.PLAIN_TEXT);
                    ((JLabel) renderer).setAlignmentX(Component.LEFT_ALIGNMENT);
                    ((JLabel) renderer).setIconTextGap(20);
                    ((JLabel) renderer).setBorder(new EmptyBorder(new Insets(5, 15, 5, 0)));
                    // ((JLabel) renderer).addMouseListener(new MouseAdapter(){
                    //     public void mouseEntered(MouseEvent e) {
                            
                    //         ((JLabel) renderer).setOpaque(true);
                    //         ((JLabel) renderer).setBackground(new Color(45, 45, 50));
                    //     }
            
                    //     public void mouseExited(MouseEvent e) {
                    //         ((JLabel) renderer).setOpaque(false);
                    //     }
                    // });
                    if(isSelected){
                        border = Colors.ACCENT;
                        ((JLabel) renderer).setOpaque(true);
                        ((JLabel) renderer).setBackground(new Color(45, 45, 45));
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
        list.addListSelectionListener(listener -> {
            if(list.getSelectedIndex() != -1){
                view.changeCard(list.getSelectedValue().name);
            }
        });
        
        add(list);
        add(Box.createVerticalGlue());
        add(new JSeparator());
        Label settings = new Label("Settings", Fonts.Body, Component.LEFT_ALIGNMENT);
        settings.setIcon(Icons.SETTINGS);
        settings.setOpaque(false);
        settings.setIconTextGap(20);
        settings.setBorder(new EmptyBorder(new Insets(5, 0, 5,0)));
        add(settings);
    }
}
