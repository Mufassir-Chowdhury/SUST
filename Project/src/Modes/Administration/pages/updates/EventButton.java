package Modes.Administration.pages.updates;

import Components.Label;
import Components.Buttons.AccentButton;
import Components.InputFields.TextField;
import Components.InputFields.TextField.TYPE;
import Components.pageView.Panels.ListPanel;
import Components.pageView.Panels.TilesPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import java.awt.Component;

public class EventButton extends AccentButton implements ActionListener {
    public class Dialog extends ListPanel{
        public Dialog(JDialog dialog){
            add(Box.createVerticalStrut(50));

            TilesPanel tilesPanel = new TilesPanel(5, 2, 10);
            tilesPanel.add(new Label("Title"));
            tilesPanel.add(new TextField("Write Title", TYPE.PLAIN));
            tilesPanel.add(new Label("Description"));
            tilesPanel.add(new TextField("Write Description", TYPE.PLAIN));
            tilesPanel.add(new Label("Date"));
            tilesPanel.add(new TextField("Write Date", TYPE.PLAIN));
            tilesPanel.add(new Label("Location"));
            tilesPanel.add(new TextField("Write Location", TYPE.PLAIN));
            tilesPanel.add(new Label("Organiser"));
            tilesPanel.add(new TextField("Write Organiser", TYPE.PLAIN));
            tilesPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(tilesPanel);
            
            add(Box.createVerticalGlue());
            AccentButton proceed = new AccentButton("Proceed");
            proceed.setAlignmentX(Component.CENTER_ALIGNMENT);
            proceed.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    dialog.dispose();
                }
            });
            add(proceed);
        }
    }
    public EventButton(){
        super("Post New Event");
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final JDialog dialog = new JDialog();
        final JOptionPane optionPane = new JOptionPane(new Dialog(dialog), JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);

        dialog.setTitle("Add an event");
        dialog.setModal(true);
        dialog.setContentPane(optionPane);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.pack();

        dialog.setVisible(true);
    }
}
