package pages.pageView.course_information;

import Components.Label;
import Components.pageView.Line;

import java.awt.Component;

import Constants.Fonts;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;

public class ResultList extends ExpandableItem {
    public ResultList(Line listItem){
        super(listItem);
        this.addMouseListener(new MouseAdapter(){
            Box marks = Box.createHorizontalBox();
            Boolean open = false;
            Boolean created = false;
            @Override
            public void mouseClicked(MouseEvent e){
                if(created == false){
                    marks.setAlignmentX(Component.LEFT_ALIGNMENT);
                    marks.add(new Label("ATTENDANCE MARKS", Fonts.Body));
                    marks.add(Box.createHorizontalGlue());
                    marks.add(new Label("EXAM MARKS", Fonts.Body));
                    marks.add(Box.createHorizontalGlue());
                    marks.add(new Label("ASSIGNMENT MARKS", Fonts.Body));
                    created = true;
                }
                if(open == false){
                    add(marks);
                    open = true;
                } else{
                    remove(marks);
                    open = false;
                }
                repaint();
                revalidate();
            }
            
        });
    }
}
