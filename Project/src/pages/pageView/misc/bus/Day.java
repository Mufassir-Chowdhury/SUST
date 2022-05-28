package pages.pageView.misc.bus;

import javax.swing.JPanel;

import java.awt.Graphics;

import Components.Label;
import Components.pageView.Panels.TilesPanel;
import Constants.Colors;
import Constants.Fonts;

import java.awt.Color;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.border.EmptyBorder;
import java.awt.Insets;

public class Day extends TilesPanel {
    class IndividualPlace extends JPanel{
        private Color color = new Color(0,120,212, 204);

        public IndividualPlace(String place){
            setOpaque(false);
            add(new Label(place));
        }
        public IndividualPlace(String classroom, String special, Color color){
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

    
    public Day(){
        super(16, 1, 0);
        for(int i=0;i<8; i++){
            add(new IndividualPlace("place"));
            add(new Label("", Fonts.BODY_LARGE, Component.CENTER_ALIGNMENT));
        }
    }
    public Day(String item){
        super(9, 1, 0);
        add(new IndividualPlace("G2", " ", new Color(0,120,212, 204)));
        add(new Label("", Fonts.BODY_LARGE, Component.CENTER_ALIGNMENT));
        add(new Label("", Fonts.BODY_LARGE, Component.CENTER_ALIGNMENT));
        add(new IndividualPlace("G2", "EXAM", new Color(0,120,212, 204)));
        add(new Label("", Fonts.BODY_LARGE, Component.CENTER_ALIGNMENT));
        Box Line = Box.createHorizontalBox();
        Line.add(new IndividualPlace("303", "Exam", new Color(0,120,212, 204)));
        if(item == "2")
            Line.add(new IndividualPlace("303", " ", new Color(120,121,241)));
        add(Line);
    }
    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Colors.CARD);
        g.fillRoundRect(0, 0, getWidth(), getHeight(), 7, 7);
        super.paintComponent(g);
    }
}
