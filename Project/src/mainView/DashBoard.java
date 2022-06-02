package mainView;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Components.Card;
import Components.Label;
import Components.pageView.Panels.ListPanel;

import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Component;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;

import Constants.Colors;
import Constants.Fonts;
import Constants.Icons;
import Constants.Margins;
import Constants.Padding;
import Constants.Sizes;
import Server.Datapoints;

class DashBoard extends JPanel {
    public DashBoard(){
        setOpaque(false);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = Margins.DASHBOARD;
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

            Card card = new Card(Icons.DP, (int)Sizes.DP.getWidth(), Sizes.DP);
            add(card);
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
            setLayout(new GridLayout(1, 2, Padding.CARD_SPACING, 0));
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
                setBorder(Padding.TITLE);
                add(new Label(title, Fonts.BODY_LARGE, SwingConstants.CENTER));
            }
            @Override
            protected void paintComponent(Graphics g) {
                g.setColor(Colors.DASHBOARD_TITLE_BACKGROUND);
                g.fillRoundRect(0, 0, getWidth(), getHeight()+7, Sizes.BORDER_RADIUS, Sizes.BORDER_RADIUS);
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
                    setMaximumSize(Sizes.NOTIFICATION_SIZE);
                    setBorder(Padding.NOTIFICATION);
                    add(new JLabel(Icons.INFO), BorderLayout.WEST);
                    Label title = new Label(notification.title);
                    title.setBorder(Padding.LIST_PANEL);
                    add(title, BorderLayout.CENTER);
                    Label date = new Label(notification.date, Fonts.CAPTION, SwingConstants.LEADING);
                    if(notification.dismissable)
                        date.setIcon(Icons.CLOSE);
                    add(date, BorderLayout.EAST);
                }
                @Override
                protected void paintComponent(Graphics g) {
                    if(severity == Datapoints.Notification.Severity.INFORMATIONAL)
                        g.setColor(Colors.NOTIFICATION_TOAST_INFORMATIONAL);
                    else if(severity == Datapoints.Notification.Severity.SUCCESS)
                        g.setColor(Colors.NOTIFICATION_TOAST_SUCCESS);
                    else if(severity == Datapoints.Notification.Severity.WARNING)
                        g.setColor(Colors.NOTIFICATION_TOAST_WARNING);
                    else if(severity == Datapoints.Notification.Severity.CRITICAL)
                        g.setColor(Colors.NOTIFICATION_TOAST_CRITICAL);
                    g.fillRoundRect(0, 0, getWidth(), getHeight()+7, Sizes.BORDER_RADIUS, Sizes.BORDER_RADIUS);
                    super.paintComponent(g);
                }
            }
            public DashBoardInfo(Datapoints.Notification[] notifications){
                setBorder(Padding.NOTIFICATION);
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
            g.setColor(Colors.DASHBOARD_BACKGROUND);
            g.fillRoundRect(0, 0, getWidth(), getHeight(), Sizes.BORDER_RADIUS, Sizes.BORDER_RADIUS);
            super.paintComponent(g);
        }
    }
}
