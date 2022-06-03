package mainView;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import Components.Card;
import Components.DashBoardItem;
import Components.Label;

import java.awt.GridBagLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;

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

}
