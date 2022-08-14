package Components.pageView;

import javax.swing.Box;
import javax.swing.Timer;

import Components.Label;
import Components.pageView.Panels.ListPanel;
import Constants.Fonts;
import java.awt.Component;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrentTime extends ListPanel implements ActionListener {
    public CurrentTime(){
        Timer timer = new Timer(1000, this);
        add(new Label("Current Time", Fonts.SUBTITLE, Component.LEFT_ALIGNMENT));
        add(Box.createVerticalStrut(-10));
        DateTimeFormatter time = DateTimeFormatter.ofPattern("hh:mm a");
        LocalTime localTime = LocalTime.now();
        add(new Label(time.format(localTime), Fonts.SECOND_DISPLAY, Component.LEFT_ALIGNMENT));
        add(Box.createVerticalStrut(-10));
        DateTimeFormatter date = DateTimeFormatter.ofPattern("EEEE,         MMMM dd, u");
        LocalDate localDate = LocalDate.now();
        add(new Label(date.format(localDate), Fonts.BODY, Component.LEFT_ALIGNMENT));
        add(Box.createVerticalGlue());
        timer.start();
    }    
    @Override
    public void actionPerformed(ActionEvent e) {
        DateTimeFormatter time = DateTimeFormatter.ofPattern("hh:mm a");
        LocalTime localTime = LocalTime.now();
        ((Label)getComponent(2)).setText(time.format(localTime));
        DateTimeFormatter date = DateTimeFormatter.ofPattern("EEEE,         MMMM dd, u");
        LocalDate localDate = LocalDate.now();
        ((Label)getComponent(4)).setText(date.format(localDate));
    }
}
