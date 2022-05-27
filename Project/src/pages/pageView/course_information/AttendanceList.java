package pages.pageView.course_information;

import Components.pageView.Line;

import Components.Label;
import Constants.Fonts;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AttendanceList extends ExpandableItemList{
    public AttendanceList(Line listItem){
        super(listItem);
        this.addMouseListener(new MouseAdapter(){
            Label attendance = new Label("Attendance", Fonts.Body);
            Boolean open = false;
            @Override
            public void mouseClicked(MouseEvent e){
                if(open == false){
                    add(attendance);
                    open = true;
                } else{
                    remove(attendance);
                    open = false;
                }
                repaint();
                revalidate();
            }
            
        });
    }
}
