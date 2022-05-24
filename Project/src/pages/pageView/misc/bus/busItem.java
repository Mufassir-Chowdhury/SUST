package pages.pageView.misc.bus;


import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Graphics;

import Components.Card;
import Components.Label;
import Constants.Colors;
import Constants.Fonts;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

public class busItem extends JPanel {
    class Day extends JPanel{
        class IndividualPlace extends JPanel{
            public IndividualPlace(String place){
                setOpaque(false);
                add(new Label(place, Fonts.Body));
            }
            @Override
            protected void paintComponent(Graphics g) {
                g.setColor(new Color(0,120,212, 204));
                g.fillRoundRect(0, 0, getWidth(), getHeight(), 7, 7);
                super.paintComponent(g);
            }
        }
        public Day(String item){
            setOpaque(false);
            setLayout(new GridLayout(16, 1));
            for(int i=0;i<8; i++){
                add(new IndividualPlace("place"));
                add(new Label("", Fonts.BODY_LARGE, Component.CENTER_ALIGNMENT));
            }
        }
        @Override
        protected void paintComponent(Graphics g) {
            g.setColor(Colors.CARD);
            g.fillRoundRect(0, 0, getWidth(), getHeight(), 7, 7);
            super.paintComponent(g);
        }
    }
    public busItem(String item){
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setMaximumSize(new Dimension(1000, 200));
        Box line = Box.createHorizontalBox();
        line.add(new Label("Bus 1", Fonts.SUBTITLE));
        line.add(Box.createHorizontalGlue());
        add(line);
        add(Box.createVerticalStrut(5));
        add(new Day(item));
    }
}
