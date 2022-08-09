package Common.pages.pageView.administrivia;

import java.awt.Component;

import javax.swing.Box;

import Components.Label;
import Components.Buttons.AccentButton;
import Components.InputFields.ComboBox;
import Components.pageView.Panels.ListPanel;
import Constants.Fonts;
import Constants.Sizes;

public class paymentPage extends ListPanel {
    public paymentPage(){
        add(new Profile());
        String[] semesters = {"1-2", "2-1"};
        ComboBox<String> availableSemesters = new ComboBox<>(semesters);
        availableSemesters.setMaximumSize(Sizes.TEXT_FIELD_SIZE);
        add(availableSemesters);
        add(Box.createVerticalStrut(10));
        add(new Label("Amount: ", Fonts.BODY, Component.LEFT_ALIGNMENT));
        add(Box.createVerticalStrut(10));
        AccentButton proceed = new AccentButton("Proceed");
        proceed.setAlignmentX(Component.LEFT_ALIGNMENT);
        add(proceed);
    }
}
