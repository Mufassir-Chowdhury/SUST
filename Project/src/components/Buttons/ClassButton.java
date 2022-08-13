package Components.Buttons;

import Components.Background;
import Components.Label;
import Components.InputFields.ComboBox;
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

public class ClassButton extends AccentButton implements ActionListener {
    public class Dialog extends ListPanel{
        public Dialog(Dimension size, JFrame frame) {
            
            setBorder(Padding.DIALOG_VIEW_PORT);
            setSize(size);

            add(new Label("Add/Remove Class", Fonts.DISPLAY, Component.CENTER_ALIGNMENT));
            add(Box.createVerticalGlue());
            
            String[] options = {"Add", "Remove"};
            TilesPanel tilesPanel = new TilesPanel(6, 2, 10);
            tilesPanel.add(new Label("Add or Remove"));
            tilesPanel.add(new ComboBox<>(options));
            tilesPanel.add(new Label("Classroom"));
            tilesPanel.add(new TextField("Write Classroom", TYPE.PLAIN));
            tilesPanel.add(new Label("Date"));
            tilesPanel.add(new TextField("Write Date", TYPE.PLAIN));
            tilesPanel.add(new Label("Remarks"));
            tilesPanel.add(new TextField("Add remarks", TYPE.PLAIN));
            tilesPanel.add(new Label("Start Time"));
            tilesPanel.add(new TextField("Write Start Time", TYPE.PLAIN));
            tilesPanel.add(new Label("Duration"));
            tilesPanel.add(new TextField("Write Duration", TYPE.PLAIN));
            tilesPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(tilesPanel);
            
            add(Box.createVerticalGlue());
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
    public ClassButton(){
        super("Add or remove a class");
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Dimension size = Sizes.DIALOG.CLASS;
        Background frame = new Background(size, new JFrame());
        frame.add(new Dialog(size, frame));

    }
}
