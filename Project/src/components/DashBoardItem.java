package Components;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Components.DashBoardItem;
import Components.Buttons.AccentButton;
import Components.pageView.Panels.ListPanel;

import java.awt.Graphics;
import java.awt.BorderLayout;
import java.awt.Component;

import Constants.Colors;
import Constants.Fonts;
import Constants.Icons;
import Constants.Padding;
import Constants.Sizes;
import Server.Datapoints;

public class DashBoardItem extends JPanel {
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
    public DashBoardItem(){
        setLayout(new BorderLayout());
        setAlignmentX(Component.LEFT_ALIGNMENT);
        setOpaque(false);
        add(new Title("Your Work"), BorderLayout.PAGE_START);
        add(new ListPanel(new AccentButton("+ Add or Create"), new AccentButton("Mark as Done")));
    }
    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Colors.DASHBOARD_BACKGROUND);
        g.fillRoundRect(0, 0, getWidth(), getHeight(), Sizes.BORDER_RADIUS, Sizes.BORDER_RADIUS);
        super.paintComponent(g);
    }
}
