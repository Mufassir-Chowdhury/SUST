package Common.pages.pageView.administrivia;

import java.awt.Component;

import javax.swing.Box;

import Components.Label;
import Components.Buttons.AccentButton;
import Components.InputFields.ComboBox;
import Components.InputFields.TextField;
import Components.InputFields.TextField.TYPE;
import Components.pageView.Panels.ListPanel;
import Constants.Fonts;
import Constants.Sizes;

public class paymentPage extends ListPanel {
    public paymentPage(){
        add(new Label("Mufassir Ahmad Chowdhury", Fonts.TITLE, Component.LEFT_ALIGNMENT));
        add(Box.createVerticalStrut(5));
        add(new Label("2019331071", Fonts.SUBTITLE, Component.LEFT_ALIGNMENT));
        add(Box.createVerticalStrut(5));
        add(new Label("Computer Science and Engineering", Fonts.BODY_LARGE, Component.LEFT_ALIGNMENT));
        add(Box.createVerticalStrut(5));
        add(new Label("2019-20", Fonts.BODY_LARGE, Component.LEFT_ALIGNMENT));
        add(Box.createVerticalStrut(5));
        add(new Label("01771144308", Fonts.BODY_LARGE, Component.LEFT_ALIGNMENT));
        add(Box.createVerticalStrut(5));
        add(new Label("mac22214u@gmail.com", Fonts.BODY_LARGE, Component.LEFT_ALIGNMENT));
        add(Box.createVerticalStrut(15));
        String[] semesters = {"1-2", "2-1"};
        ComboBox<String> availableSemesters = new ComboBox<>(semesters);
        availableSemesters.setMaximumSize(Sizes.TEXT_FIELD_SIZE);
        availableSemesters.setAlignmentX(Component.LEFT_ALIGNMENT);
        add(availableSemesters);
        add(Box.createVerticalStrut(10));
        TextField amount = new TextField("Amount", TYPE.PLAIN);
        add(amount);
        add(Box.createVerticalStrut(10));
        amount.setAlignmentX(Component.LEFT_ALIGNMENT);
        AccentButton proceed = new AccentButton("Proceed");
        proceed.setAlignmentX(Component.LEFT_ALIGNMENT);
        add(proceed);
    }
}
