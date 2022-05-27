package pages.pageView.course_information;

import javax.swing.Box;
import java.awt.CardLayout;

import javax.swing.JPanel;

import Components.Card;
import Components.Buttons.AccentButton;
import Components.pageView.Options;
import Components.pageView.TilesPanel;
import Components.pageView.ViewPort;

import java.awt.Component;
import Constants.Icons;
import Server.Datapoints;

public class resources extends ViewPort {
    public resources(){
        super("Resources", new AccentButton("Post New Material"));

        String[] secondOptions = {"Course", "Course 2"};
        add(new Options(Datapoints.getInstance().SEMESTER, secondOptions));
        add(Box.createVerticalStrut(20));

        JPanel resources = new JPanel();
        resources.setAlignmentX(Component.LEFT_ALIGNMENT);
        resources.setOpaque(false);
        resources.setLayout(new CardLayout());

        TilesPanel list = new TilesPanel();
        
        for(String resource: Datapoints.getInstance().RESOURCES)
            list.add(new Card(resource, Icons.RESOURCES));

        resources.add(list);
        add(resources);
    }
}
