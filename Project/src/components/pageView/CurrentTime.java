package Components.pageView;

import javax.swing.Box;

import Components.Label;
import Components.pageView.Panels.ListPanel;
import Constants.Fonts;
import java.awt.Component;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CurrentTime extends ListPanel {
    public CurrentTime(){
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
    }    
}
