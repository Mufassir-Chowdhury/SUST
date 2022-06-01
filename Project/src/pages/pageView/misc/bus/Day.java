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
        private Color color;

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
            add(new IndividualPlace("place", "", "", Colors.ACCENT_FILL));
            add(new Label("", Fonts.BODY_LARGE, Component.CENTER_ALIGNMENT));
        }
    }
    public Day(String item){
        super(9, 1, 0);
        add(new IndividualPlace("Class", "G2", " ", Colors.ACCENT_FILL));
        add(new Label("", Fonts.BODY_LARGE, Component.CENTER_ALIGNMENT));
        add(new Label("", Fonts.BODY_LARGE, Component.CENTER_ALIGNMENT));
        add(new IndividualPlace("Class", "G2", "EXAM", Colors.ACCENT_FILL));
        add(new Label("", Fonts.BODY_LARGE, Component.CENTER_ALIGNMENT));
        Box Line = Box.createHorizontalBox();
        Line.add(new IndividualPlace("Class", "303", "Assignment", Colors.ACCENT_FILL));
        if(item == "2")
            Line.add(new IndividualPlace("Class", "303", " ",Colors.SECONDARY));
        add(Line);
    }
    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Colors.CARD);
        g.fillRoundRect(0, 0, getWidth(), getHeight(), 7, 7);
        super.paintComponent(g);
    }
}
