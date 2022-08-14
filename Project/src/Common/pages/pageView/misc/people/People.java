package Common.pages.pageView.misc.people;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.event.MouseInputAdapter;

import java.awt.CardLayout;

import Components.Background;
import Components.Card;
import Components.Label;
import Components.Buttons.AccentButton;
import Constants.Collections;
import Constants.Fonts;
import Constants.Icons;
import Constants.Padding;
import Constants.Sizes;

import java.awt.event.MouseEvent;
import java.awt.Component;

import Components.pageView.Panels.ListPanel;
import Components.pageView.Panels.ScrollPane;
import Components.pageView.Panels.TilesPanel;
import Components.pageView.Panels.ViewPortPanel;
import Server.Datapoints;
import java.awt.Dimension;

public class People extends ViewPortPanel {
    TilesPanel tilesPanel = new TilesPanel(1, 2, 0, 10);
    ListPanel listPanel = new ListPanel();

    public class Dialog extends ListPanel {

        public Dialog(Dimension size, JFrame frame, String type, Datapoints.Person person) {
            setSize(size);
            setBorder(Padding.DIALOG_VIEW_PORT);
            
            TilesPanel informationPanel;
            Box line = Box.createHorizontalBox();
            line.add(Box.createHorizontalGlue());
            line.add(new Card(Icons.DP, (int)Sizes.DP.getWidth(), Sizes.DP));
            line.add(Box.createHorizontalGlue());
            add(line);
            add(new Label(person.name, Fonts.DISPLAY, Component.CENTER_ALIGNMENT));
            add(Box.createVerticalGlue());
            if (type.equals("Student")) {
                informationPanel = new TilesPanel(8, 2, 10);
                informationPanel.add(new Label("Registration"));
                informationPanel.add(new Label(person.registration));
            } else {
                informationPanel = new TilesPanel(7, 2, 10);
                informationPanel.add(new Label("Department"));
                informationPanel.add(new Label(person.department));
            }


            if (type.equals("Student")) {
                informationPanel.add(new Label("Session (20xx-xx)"));
                informationPanel.add(new Label(person.session));
                informationPanel.add(new Label("Semester"));
                informationPanel.add(new Label(person.session));
            } else {
                informationPanel.add(new Label("Designation"));
                informationPanel.add(new Label(person.designation));
            }
            informationPanel.add(new Label("Email"));
            informationPanel.add(new Label(person.email));
            informationPanel.add(new Label("Number (Without +88)"));
            informationPanel.add(new Label(person.number));
            informationPanel.add(new Label("Blood Group (X+/-)"));
            informationPanel.add(new Label(person.blood));
            informationPanel.add(new Label("Birthday (DD/MM/YYYY)"));
            informationPanel.add(new Label(person.birthDay));
            informationPanel.add(new Label("Hometown"));
            informationPanel.add(new Label(person.hometown));

            informationPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

            add(informationPanel);
            add(Box.createVerticalGlue());
            AccentButton proceed = new AccentButton("Proceed");
            proceed.setAlignmentX(Component.CENTER_ALIGNMENT);
            proceed.addMouseListener(new MouseInputAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    frame.dispose();
                }
            });

            add(proceed);
        }
    }



    public People(JComponent component) {
        super("People", component);
        getPanel().setLayout(new BoxLayout(getPanel(), BoxLayout.Y_AXIS));
        
        listPanel.setLayout(new CardLayout());
        for(String role: Collections.ROLES){
            ListPanel cardList = new ListPanel();
            for (Datapoints.Person person : role.equals("Teacher") ? Datapoints.TEACHERS : Datapoints.STUDENTS) {
                Box box = person.getListItem();
                box.addMouseListener(new MouseInputAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        Dimension size = Sizes.DIALOG.PERSON;
                        Background frame = new Background(size, new JFrame());
                        frame.add(new Dialog(size, frame, role, person));
                        frame.setVisible(true); 
                    }
                });
                cardList.add(box);
                cardList.add(Box.createVerticalStrut(10));
            }

            listPanel.add(new ScrollPane(cardList), role);

            Label label = new Label(role, Fonts.DISPLAY, role.equals("Teacher") ? SwingConstants.LEFT : SwingConstants.RIGHT);
            tilesPanel.add(label);
            label.addMouseListener(new MouseInputAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                            ((CardLayout) listPanel.getLayout()).show(listPanel, role);
                    }
            });
        }

        getPanel().add(tilesPanel);
        getPanel().add(listPanel);
    }
}
