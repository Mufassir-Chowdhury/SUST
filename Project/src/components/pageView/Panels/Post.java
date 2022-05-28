package Components.pageView.Panels;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import java.awt.Component;

import Components.Label;
import Constants.Fonts;

public class Post extends JPanel {
    public Post(String title, String date, String totalMarks, String description){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setOpaque(false);
        setAlignmentX(Component.LEFT_ALIGNMENT);
        add(new Label(title, Fonts.TITLE, Component.LEFT_ALIGNMENT));
        add(new Label("Due Date: " + date, Fonts.Body, Component.LEFT_ALIGNMENT));
        add(new Label("Total Marks: " + String.valueOf(totalMarks), Fonts.Body, Component.LEFT_ALIGNMENT));
        add(new JSeparator());
        add(new Label(description, Fonts.BODY_LARGE, Component.LEFT_ALIGNMENT));
        add(Box.createVerticalGlue());

    }
}
