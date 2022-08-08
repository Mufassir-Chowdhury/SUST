package Common.pages.pageView.updates.routine;

import Components.Label;
import Components.Buttons.AccentButton;
import Components.pageView.Box.Title;
import Components.pageView.Panels.Column;
import Components.pageView.Panels.GridBagPanel;
import Components.pageView.Panels.InformationPanel;
import Components.pageView.Panels.ScrollPane;
import Components.pageView.Panels.ViewPort;
import Constants.Fonts;
import Constants.Margins;
import Server.Datapoints;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import Common.pages.pageView.misc.bus.Day;

public class routine extends ViewPort{
    public routine(){
        super("Class Routine", null);

        GridBagPanel list = new GridBagPanel();
        
        list.add(
            new InformationPanel("Your Courses", new AccentButton("Manage Courses") , Datapoints.getInstance().COURSES), 
            GridBagPanel.GetConstant(1, 0, 0, 1, 1, 2, 1, Margins.INFORMATION_PANEL)
        );

        list.add(
            new timeline(), 
            GridBagPanel.GetConstant(1, 2, 0, .5, 1, 1, 1, null)
        );

        for(int i=0; i<3; i++){
            list.add(
                new Column(
                    new Title(
                        new Label(
                            DateTimeFormatter.ofPattern("EEEE")
                                                .format(LocalDate.now()
                                                                .plusDays(i)), 
                            Fonts.SUBTITLE
                        ), 
                        new Label(
                            DateTimeFormatter.ofPattern("dd/MM")
                                                .format(LocalDate.now()
                                                                .plusDays(i))
                        )
                    ), 
                    new Day(i%2 == 1 ? "2": "1")
                ), 
                GridBagPanel.GetConstant(1, 2*i+3, 0, 1, 1, 2, 1, Margins.COLUMN)
            );
        }
        
        add(new ScrollPane(list));
    }
}
