package mainView;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Components.Label;
import Components.pageView.Panels.ListPanel;

import java.awt.Graphics;
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
import Server.Datapoints;

class DashBoard extends JPanel {
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
        add(new DashBoardItem("Due Registrations", Datapoints.getInstance().REGISTRATION), gbc);

        gbc.gridy = 3;
        gbc.weighty = 1;
        gbc.gridheight = 2;
        add(new DashBoardItem("Notifications", Datapoints.getInstance().NOTIFICATION), gbc);
    }

    class Profile extends JPanel{
        public Profile(){
            setOpaque(false);
            setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

            JLabel title = new JLabel(Icons.DP);
            title.setForeground(Colors.PLAIN_TEXT);
            title.setAlignmentX(Component.LEFT_ALIGNMENT);
            
            add(title);
            add(Box.createHorizontalGlue());
            
            Box line = Box.createVerticalBox();
            line.add(Box.createVerticalGlue());
            for(int i=0; i<Datapoints.getInstance().DETAILS.length; i++){
                line.add(new Label(Datapoints.getInstance().DETAILS[i], Fonts.PLAIN_TEXT, Component.RIGHT_ALIGNMENT));
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
            add(new DashBoardItem("Upcoming Exams", Datapoints.getInstance().EXAM));
            add(new DashBoardItem("Due Assignments", Datapoints.getInstance().ASSIGNMENT));
        }
    }

    class DashBoardItem extends JPanel {
        class Title extends JPanel{
            public Title(String title){
                setOpaque(false);
                setLayout(new BorderLayout());
                setBorder(new EmptyBorder(new Insets(5, 5, 5, 5)));
                add(new Label(title, Fonts.BODY_LARGE, SwingConstants.CENTER));
            }
            @Override
            protected void paintComponent(Graphics g) {
                g.setColor(new Color(84, 84, 84, 163));
                g.fillRoundRect(0, 0, getWidth(), getHeight()+7, 7, 7);
                super.paintComponent(g);
            }
        }
        class DashBoardInfo extends ListPanel {
            class DashBoardInfoCard extends JPanel {
                Datapoints.Notification.Severity severity;
                public DashBoardInfoCard(Datapoints.Notification notification){
                    setLayout(new BorderLayout());
                    setOpaque(false);
                    this.severity = notification.severity;
                    setMaximumSize(new Dimension(1000, 40));
                    setBorder(new EmptyBorder(new Insets(5, 5, 5, 5)));
                    add(new JLabel(Icons.INFO), BorderLayout.WEST);
                    Label title = new Label(notification.title, Fonts.Body);
                    title.setBorder(new EmptyBorder(5, 10, 5, 10));
                    add(title, BorderLayout.CENTER);
                    Label date = new Label(notification.date, Fonts.CAPTION, SwingConstants.LEADING);
                    if(notification.dismissable)
                        date.setIcon(Icons.CLOSE);
                    add(date, BorderLayout.EAST);
                }
                @Override
                protected void paintComponent(Graphics g) {
                    if(severity == Datapoints.Notification.Severity.INFORMATIONAL)
                        g.setColor(new Color(80, 70, 70, 255));
                    else if(severity == Datapoints.Notification.Severity.SUCCESS)
                        g.setColor(new Color(57, 61, 27, 255));
                    else if(severity == Datapoints.Notification.Severity.WARNING)
                        g.setColor(new Color(67, 53, 25, 255));
                    else if(severity == Datapoints.Notification.Severity.CRITICAL)
                        g.setColor(new Color(68, 39, 38, 255));
                    g.fillRoundRect(0, 0, getWidth(), getHeight()+7, 7, 7);
                    super.paintComponent(g);
                }
            }
            public DashBoardInfo(Datapoints.Notification[] notifications){
                setBorder(new EmptyBorder(new Insets(5, 5, 5, 5)));
                for(int i=0; i<notifications.length; i++){
                    add(new DashBoardInfoCard(notifications[i]));
                    if(i != notifications.length -1 )
                        add(Box.createVerticalStrut(10));
                }
            }
        }
        public DashBoardItem(String title, Datapoints.Notification[] notifications){
            setLayout(new BorderLayout());
            setOpaque(false);
            add(new Title(title), BorderLayout.PAGE_START);
            add(new DashBoardInfo(notifications), BorderLayout.CENTER);
        }
        @Override
        protected void paintComponent(Graphics g) {
            g.setColor(new Color(84, 84, 84, 163));
            g.fillRoundRect(0, 0, getWidth(), getHeight(), 7, 7);
            super.paintComponent(g);
        }
    }
}
