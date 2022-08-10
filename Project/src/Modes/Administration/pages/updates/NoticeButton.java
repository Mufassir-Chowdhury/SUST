package Modes.Administration.pages.updates;

import Components.Background;
import Components.Label;
import Components.Buttons.AccentButton;
import Components.InputFields.TextField;
import Components.InputFields.TextField.TYPE;
import Components.pageView.Panels.ListPanel;
import Components.pageView.Panels.TilesPanel;
import Constants.Icons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JOptionPane;

import java.awt.Component;

public class NoticeButton extends AccentButton implements ActionListener {
    public class Dialog extends ListPanel{
        public Dialog(){
            add(Box.createVerticalStrut(50));

            TilesPanel tilesPanel = new TilesPanel(2, 2, 10);
            tilesPanel.add(new Label("Title"));
            tilesPanel.add(new TextField("Write Title", TYPE.PLAIN));
            tilesPanel.add(new Label("Message"));
            tilesPanel.add(new TextField("Write Message", TYPE.PLAIN));
            tilesPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(tilesPanel);
            
            add(Box.createVerticalGlue());
            AccentButton proceed = new AccentButton("Proceed");
            proceed.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(proceed);
        }
    }
    public NoticeButton(){
        super("Post New Notice");
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(
            new Background(), 
            new Dialog(), 
            "Add A Notice",
            JOptionPane.OK_CANCEL_OPTION,
            Icons.INFO
        );

    }
}
