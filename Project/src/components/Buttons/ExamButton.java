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

import java.awt.Component;
import java.awt.Dimension;

public class ExamButton extends AccentButton implements ActionListener {
    public class Dialog extends ListPanel{
        public Dialog(Dimension size, JFrame frame){
            setBorder(Padding.DIALOG_VIEW_PORT);
            setSize(size);

            add(new Label("Post New Exam", Fonts.DISPLAY, Component.CENTER_ALIGNMENT));
            add(Box.createVerticalGlue());

            TilesPanel tilesPanel = new TilesPanel(3, 2, 10);
            tilesPanel.add(new Label("Title"));
            tilesPanel.add(new TextField("Write Title", TYPE.PLAIN));
            tilesPanel.add(new Label("Date"));
            tilesPanel.add(new TextField("Write Date", TYPE.PLAIN));
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
    public ExamButton(){
        super("Post New Exam");
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Dimension size = new Dimension((int)(Sizes.DEFAULT_WINDOW_SIZE.getWidth()/1.7), (int)(Sizes.DEFAULT_WINDOW_SIZE.getHeight()/1.4));
        Background frame = new Background(size, new JFrame());
        frame.add(new Dialog(size, frame));
    }
}
