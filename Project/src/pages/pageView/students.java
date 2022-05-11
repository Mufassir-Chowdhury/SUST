package pages.pageView;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Insets;

import Constants.Colors;
import Constants.Datapoints;
import Constants.Fonts;

public class students extends JPanel {
    public students(){
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(new Insets(10, 0, 50, 40)));
        Box title = Box.createHorizontalBox();
        title.setAlignmentX(Component.LEFT_ALIGNMENT);
        JLabel titleLabel = new JLabel("Students");
        titleLabel.setFont(Fonts.DISPLAY);
        titleLabel.setForeground(Colors.PLAIN_TEXT);
        title.add(titleLabel);
        add(title);
        add(Box.createVerticalStrut(20));
        JPanel list = new JPanel();
        list.setOpaque(false);
        list.setLayout(new BoxLayout(list, BoxLayout.Y_AXIS));
        for(Datapoints.Student student: Datapoints.STUDENTS){
            Box line = Box.createHorizontalBox();
            JLabel registration = new JLabel(student.registration.substring(student.registration.length() - 3));
            registration.setForeground(Colors.PLAIN_TEXT);
            registration.setFont(Fonts.BODY_LARGE);
            line.add(registration);
            line.add(Box.createHorizontalStrut(5));
            JPanel info = new JPanel();
            info.setBackground(new Color(52, 50, 52));
            info.setLayout(new BoxLayout(info, BoxLayout.X_AXIS));
            info.setBorder(new EmptyBorder(new Insets(5, 5, 5, 5)));
            Box congestedInfo = Box.createVerticalBox();
            JLabel name = new JLabel(student.name);
            name.setForeground(Colors.PLAIN_TEXT);
            name.setFont(Fonts.Body);
            congestedInfo.add(name);
            JLabel blood = new JLabel(student.blood + " | " + student.birthDay + " | " + student.hometown);
            blood.setForeground(Colors.PLAIN_TEXT);
            blood.setFont(Fonts.CAPTION);
            congestedInfo.add(blood);
            info.add(congestedInfo);

            info.add(Box.createHorizontalGlue());
            JLabel email = new JLabel(student.email);
            email.setFont(Fonts.PLAIN_TEXT);
            email.setForeground(Colors.PLAIN_TEXT);
            email.setHorizontalTextPosition(SwingConstants.RIGHT);
            info.add(email);
            info.add(Box.createHorizontalStrut(20));
            JLabel number = new JLabel("+880" + student.number);
            number.setFont(Fonts.PLAIN_TEXT);
            number.setForeground(Colors.PLAIN_TEXT);
            info.add(number);
            line.add(info);
            list.add(line);
            list.add(Box.createVerticalStrut(10));
        }
        JScrollPane scroll = new JScrollPane(list);
        scroll.setAlignmentX(Component.LEFT_ALIGNMENT);
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);
        scroll.setBorder(null);
        add(scroll);

    }
}
