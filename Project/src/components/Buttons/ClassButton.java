package Components.Buttons;

import Components.Label;
import Components.InputFields.ComboBox;
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

public class ClassButton extends AccentButton implements ActionListener {
    public class Dialog extends ListPanel{
        public Dialog(JDialog dialog){
            add(Box.createVerticalStrut(50));
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
                    dialog.dispose();
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
        final JDialog dialog = new JDialog();
        final JOptionPane optionPane = new JOptionPane(new Dialog(dialog), JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);

        dialog.setTitle("Add or remove a class");
        dialog.setModal(true);
        dialog.setContentPane(optionPane);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.pack();

        dialog.setVisible(true);
    }
}
