package Components.Buttons;

import Components.Background;
import Components.Label;
import Components.InputFields.TextArea;
import Components.InputFields.TextField;
import Components.InputFields.TextField.TYPE;
import Components.pageView.Panels.ListPanel;
import Components.pageView.Panels.TilesPanel;
import Constants.Fonts;
import Constants.Padding;
import Constants.Sizes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.Component;

public class AssignmentButton extends AccentButton implements ActionListener {
    public class Dialog extends ListPanel{
        public Dialog(Dimension size, JFrame frame){
            setBorder(Padding.DIALOG_VIEW_PORT);
            setSize(size);

            add(new Label("Post New Assignment", Fonts.DISPLAY, Component.CENTER_ALIGNMENT));
            add(Box.createVerticalGlue());

            TilesPanel tilesPanel = new TilesPanel(3, 2, 10);
            tilesPanel.add(new Label("Title"));
            tilesPanel.add(new TextField("Write Title", TYPE.PLAIN));
            tilesPanel.add(new Label("Due Date"));
            tilesPanel.add(new TextField("Write Due Date", TYPE.PLAIN));
            tilesPanel.add(new Label("Total Marks"));
            tilesPanel.add(new TextField("Write Total Marks", TYPE.PLAIN));
            tilesPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(tilesPanel);
            add(Box.createVerticalStrut(10));
            TextArea descriptionField = new TextArea("Write Description", true);
            add(descriptionField);
            add(Box.createVerticalGlue());
            add(Box.createVerticalStrut(10));
            AccentButton proceed = new AccentButton("Proceed");
            proceed.setAlignmentX(Component.CENTER_ALIGNMENT);
            proceed.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                }
            });
            add(proceed);
        }
    }
    public AssignmentButton(){
        super("Post New Assignment");
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame frame = new JFrame();

        Dimension size = new Dimension((int)(Sizes.DEFAULT_WINDOW_SIZE.getWidth()/1.7), (int)(Sizes.DEFAULT_WINDOW_SIZE.getHeight()/1.4));

        frame = new Background(size, frame);
        frame.add(new Dialog(size, frame));

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
