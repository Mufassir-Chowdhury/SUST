package pages.pageView.course_information;

import javax.swing.Box;
import java.awt.CardLayout;

import javax.swing.JPanel;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.border.EmptyBorder;

import Components.Card;
import Components.Buttons.AccentButton;
import Components.pageView.Options;
import Components.pageView.ViewPort;

import java.awt.Component;
import Constants.Icons;
import Server.Datapoints;

public class resources extends ViewPort {
    public resources(){
        super("Resources", new AccentButton("Post New Material"));

        String[] firstOptions = {"Semester", "Semester 2"};
        String[] secondOptions = {"Course", "Course 2"};
        add(new Options(firstOptions, secondOptions));
        add(Box.createVerticalStrut(20));

        JPanel resources = new JPanel();
        resources.setAlignmentX(Component.LEFT_ALIGNMENT);
        resources.setOpaque(false);
        resources.setLayout(new CardLayout());

        JPanel list = new JPanel();
        list.setBorder(new EmptyBorder(new Insets(50, 50, 50, 50)));
        list.setOpaque(false);
        list.setLayout(new GridLayout(2, 3, 50, 50));
        
        for(String resource: Datapoints.getInstance().RESOURCES)
            list.add(new Card(resource, Icons.RESOURCES));

        resources.add(list);
        add(resources);
    }
}
