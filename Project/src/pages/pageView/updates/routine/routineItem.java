package pages.pageView.updates.routine;

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

public class routineItem extends JPanel {
    class Day extends JPanel{
        class IndividualClass extends JPanel{
            private Color color;
            public IndividualClass(String classroom, String special, Color color){
                this.color = color;
                setOpaque(false);
                setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
                setBorder(new EmptyBorder(new Insets(5, 10, 5, 10)));
                add(Box.createVerticalGlue());
                add(new Label("Class", Fonts.Body, Component.LEFT_ALIGNMENT));
                add(Box.createVerticalGlue());
                Box line = Box.createHorizontalBox();
                line.setAlignmentX(Component.LEFT_ALIGNMENT);
                line.add(new Label(classroom, Fonts.CAPTION));
                line.add(Box.createHorizontalGlue());
                line.add(new Label(special, Fonts.CAPTION));
                add(line);
                add(Box.createVerticalGlue());
            }
            @Override
            protected void paintComponent(Graphics g) {
                g.setColor(color);
                g.fillRoundRect(0, 0, getWidth(), getHeight(), 7, 7);
                super.paintComponent(g);
            }
        }
        public Day(String item){
            setOpaque(false);
            setLayout(new GridLayout(9, 1));
            add(new IndividualClass("G2", " ", new Color(0,120,212, 204)));
            add(new Label("", Fonts.BODY_LARGE, Component.CENTER_ALIGNMENT));
            add(new Label("", Fonts.BODY_LARGE, Component.CENTER_ALIGNMENT));
            add(new IndividualClass("G2", "EXAM", new Color(0,120,212, 204)));
            add(new Label("", Fonts.BODY_LARGE, Component.CENTER_ALIGNMENT));
            Box Line = Box.createHorizontalBox();
            Line.add(new IndividualClass("303", "Exam", new Color(0,120,212, 204)));
            if(item == "2")
                Line.add(new IndividualClass("303", " ", new Color(120,121,241)));
            add(Line);
        }
        @Override
        protected void paintComponent(Graphics g) {
            g.setColor(Colors.CARD);
            g.fillRoundRect(0, 0, getWidth(), getHeight(), 7, 7);
            super.paintComponent(g);
        }
    }
    public routineItem(String item){
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setMaximumSize(new Dimension(1000, 200));
        Box line = Box.createHorizontalBox();
        line.add(new Label("Tuesday", Fonts.SUBTITLE));
        line.add(Box.createHorizontalGlue());
        line.add(new Label("date", Fonts.Body));
        add(line);
        add(Box.createVerticalStrut(5));
        add(new Day(item));
    }
}
