package mainView;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Component;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Dimension;

import Constants.Colors;
import Constants.Fonts;
import Constants.Icons;

class DashBoard extends JPanel {
    class Notification{
        String title, date;
        Severity severity;
        Boolean dismissable;
        enum Severity{
            CRITICAL, INFORMATIONAL, SUCCESS, WARNING
        }
        public Notification(Severity severity, String title, String date, Boolean dismissable){
            this.severity = severity;
            this.title = title;
            this.date = date;
            this.dismissable = dismissable;
        }
    }
    private String[] details = {
        "Mufassir Ahmad Chowdhury",
        "Student",
        "Computer Science and Engineering",
        "2nd year 1st semester"
    };
    private Notification[] exams = {
        new Notification(Notification.Severity.CRITICAL, "STAT", "Today", false),
        new Notification(Notification.Severity.INFORMATIONAL, "Algo", "9th April", false),
    };
    private Notification[] assignment = {
        new Notification(Notification.Severity.INFORMATIONAL, "Algo", "Tuesday", false),
    };
    private Notification[] registration = {
        new Notification(Notification.Severity.CRITICAL, "Fee Overdue", "Contact with register office today!", false),
        new Notification(Notification.Severity.SUCCESS, "Registration", "Registration successful!", false),
    };
    private Notification[] notifications = {
        new Notification(Notification.Severity.INFORMATIONAL, "Class Routine", "Class Routine is just updated", true),
        new Notification(Notification.Severity.WARNING, "Exam", "New Exam Posted", true),
        new Notification(Notification.Severity.INFORMATIONAL, "Resources", "Someone uploaded a resource", true),
        new Notification(Notification.Severity.CRITICAL, "Fee Overdue", "Contact with register office today!", true),
    };
    
    public DashBoard(){
        setOpaque(false);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 0, 5, 0);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = .5;
        gbc.gridheight = 1;
        add(new Profile(), gbc);

        gbc.gridy = 1;
        add(new Due(), gbc);
        
        gbc.gridy = 2;
        add(new DashBoardItem("Due Registrations", registration), gbc);

        gbc.gridy = 3;
        gbc.weighty = 1;
        gbc.gridheight = 2;
        add(new DashBoardItem("Notifications", notifications), gbc);
    }

    class Profile extends JPanel{
        public Profile(){
            setOpaque(false);
            setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

            JLabel title = new JLabel("Profile");
            title.setForeground(Colors.PLAIN_TEXT);
            title.setAlignmentX(Component.LEFT_ALIGNMENT);
            add(title);
            add(Box.createHorizontalGlue());
            
            Box line = Box.createVerticalBox();
            line.add(Box.createVerticalGlue());
            for(int i=0; i<details.length; i++){
                JLabel detail = new JLabel(details[i]);
                detail.setForeground(Colors.PLAIN_TEXT);
                detail.setAlignmentX(Component.RIGHT_ALIGNMENT);
                line.add(detail);
                if(i == 0)
                    line.add(Box.createVerticalGlue());
            }
            line.add(Box.createVerticalGlue());
            line.setAlignmentX(Component.RIGHT_ALIGNMENT);
            add(line);
        }
    }
    class Due extends JPanel {
        public Due(){
            setLayout(new GridLayout(1, 2, 10, 0));
            setOpaque(false);
            add(new DashBoardItem("Upcoming Exams", exams));
            add(new DashBoardItem("Due Assignments", assignment));
        }
    }

    class DashBoardItem extends JPanel {
        class Title extends JPanel{
            public Title(String title){
                setBackground(new Color(80, 75, 75));
                setLayout(new BorderLayout());
                setBorder(new EmptyBorder(new Insets(5, 5, 5, 5)));
                JLabel label = new JLabel(title);
                label.setForeground(Colors.PLAIN_TEXT);
                label.setFont(Fonts.BODY_LARGE);
                label.setHorizontalAlignment(SwingConstants.CENTER);
                add(label);
            }
        }
        class DashBoardInfo extends JPanel {
            class DashBoardInfoCard extends JPanel {
                public DashBoardInfoCard(Notification notification){
                    setLayout(new BorderLayout());
                    if(notification.severity == Notification.Severity.INFORMATIONAL)
                        setBackground(new Color(80, 70, 70));
                    else if(notification.severity == Notification.Severity.SUCCESS)
                        setBackground(new Color(57, 61, 27));
                    else if(notification.severity == Notification.Severity.WARNING)
                        setBackground(new Color(67, 53, 25));
                    else if(notification.severity == Notification.Severity.CRITICAL)
                        setBackground(new Color(68, 39, 38));
                    setMaximumSize(new Dimension(1000, 40));
                    setBorder(new EmptyBorder(new Insets(5, 5, 5, 5)));
                    add(new JLabel(Icons.INFO), BorderLayout.WEST);
                    JLabel title = new JLabel(notification.title);
                    title.setForeground(Colors.PLAIN_TEXT);
                    title.setBorder(new EmptyBorder(5, 10, 5, 10));
                    title.setFont(Fonts.Body);
                    add(title, BorderLayout.CENTER);
                    JLabel date = new JLabel(notification.date);
                    date.setForeground(Colors.PLAIN_TEXT);
                    date.setFont(Fonts.CAPTION);
                    if(notification.dismissable)
                        date.setIcon(Icons.CLOSE);
                    date.setHorizontalTextPosition(SwingConstants.LEADING);
                    add(date, BorderLayout.EAST);
                }
            }
            public DashBoardInfo(Notification[] notifications){
                setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
                setOpaque(false);
                setBorder(new EmptyBorder(new Insets(5, 5, 5, 5)));
                for(int i=0; i<notifications.length; i++){
                    add(new DashBoardInfoCard(notifications[i]));
                    if(i != notifications.length -1 )
                        add(Box.createVerticalStrut(10));
                }
            }
        }
        public DashBoardItem(String title, Notification[] notifications){
            setLayout(new BorderLayout());
            add(new Title(title), BorderLayout.PAGE_START);
            add(new DashBoardInfo(notifications), BorderLayout.CENTER);
            setBackground(new Color(70, 65, 65));
        }
    }
}
