package pages.pageView.misc.bus;

import java.awt.Graphics;

import Components.Label;
import Components.pageView.Box.Title;
import Components.pageView.Panels.ListPanel;
import Components.pageView.Panels.TilesPanel;
import Constants.Colors;
import Constants.Fonts;

import java.awt.Color;
import java.awt.Component;
import javax.swing.Box;

public class Day extends TilesPanel {
    class IndividualPlace extends ListPanel{
        private Color color = new Color(0,120,212, 204);

        public IndividualPlace(String className, String classroom, String special, Color color){
            super(new Label(className, Fonts.Body, Component.LEFT_ALIGNMENT),
                new Title(classroom, Fonts.CAPTION, new Label(special, Fonts.CAPTION))
            );
            this.color = color;
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
            add(new IndividualPlace("place", "", "", new Color(0,120,212, 204)));
            add(new Label("", Fonts.BODY_LARGE, Component.CENTER_ALIGNMENT));
        }
    }
    public Day(String item){
        super(9, 1, 0);
        add(new IndividualPlace("Class", "G2", " ", new Color(0,120,212, 204)));
        add(new Label("", Fonts.BODY_LARGE, Component.CENTER_ALIGNMENT));
        add(new Label("", Fonts.BODY_LARGE, Component.CENTER_ALIGNMENT));
        add(new IndividualPlace("Class", "G2", "EXAM", new Color(0,120,212, 204)));
        add(new Label("", Fonts.BODY_LARGE, Component.CENTER_ALIGNMENT));
        Box Line = Box.createHorizontalBox();
        Line.add(new IndividualPlace("Class", "303", "Assignment", new Color(0,120,212, 204)));
        if(item == "2")
            Line.add(new IndividualPlace("Class", "303", " ", new Color(120,121,241)));
        add(Line);
    }
    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Colors.CARD);
        g.fillRoundRect(0, 0, getWidth(), getHeight(), 7, 7);
        super.paintComponent(g);
    }
}
