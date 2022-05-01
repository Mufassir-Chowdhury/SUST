package mainView;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.GridBagLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;

import Constants.Colors;
import Constants.Padding;
import Constants.Sizes;

class DashBoard extends JPanel {
    public DashBoard(){
        setOpaque(false);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = .5;
        gbc.gridheight = 1;

        add(new Profile(), gbc);

        gbc.gridy = 1;
        gbc.gridheight = 1;

        add(new Due(), gbc);
        
        gbc.gridy = 2;
        gbc.gridheight = 1;

        add(new Registrations(), gbc);

        gbc.gridy = 3;
        gbc.weighty = 1;
        gbc.gridheight = 2;

        add(new Notifications(), gbc);
    }

    class Profile extends JPanel{
        public Profile(){
            setOpaque(false);
            setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
            JLabel title = new JLabel("Profile");
            title.setForeground(Colors.PLAIN_TEXT);
            add(title);
            title.setAlignmentX(Component.LEFT_ALIGNMENT);
            add(Box.createHorizontalGlue());
            Box line = Box.createVerticalBox();
            line.add(Box.createVerticalGlue());
            JLabel name = new JLabel("Mufassir Ahmad Chowdhury");
            name.setHorizontalAlignment(JLabel.RIGHT);
            name.setForeground(Colors.PLAIN_TEXT);
            name.setAlignmentX(Component.RIGHT_ALIGNMENT);
            line.add(name);
            line.add(Box.createVerticalGlue());
            JLabel id = new JLabel("Student");
            id.setHorizontalAlignment(SwingConstants.RIGHT);
            id.setForeground(Colors.PLAIN_TEXT);
            id.setAlignmentX(Component.RIGHT_ALIGNMENT);
            line.add(id);
            JLabel dept = new JLabel("Computer Sciend and Engineering");
            dept.setHorizontalAlignment(JLabel.RIGHT);
            dept.setForeground(Colors.PLAIN_TEXT);
            dept.setAlignmentX(Component.RIGHT_ALIGNMENT);

            line.add(dept);
            JLabel semester = new JLabel("2nd year 1st semester");
            semester.setHorizontalAlignment(SwingConstants.RIGHT);
            semester.setForeground(Colors.PLAIN_TEXT);
            semester.setAlignmentX(Component.RIGHT_ALIGNMENT);

            line.add(semester);
            line.add(Box.createVerticalGlue());
            line.setAlignmentX(Component.RIGHT_ALIGNMENT);
            add(line);
        }
    }
    class Due extends JPanel {
        public Due(){
            setBackground(Colors.ACCENT_BUTTON_HOVER);
        }
    }
    class Registrations extends JPanel {
        public Registrations(){
            setBackground(Colors.PLAIN_TEXT);
        }
    }
    class Notifications extends JPanel {
        public Notifications(){
            setBackground(Colors.TEXT_FIELD_BACKGROUND);
        }
    }
}
