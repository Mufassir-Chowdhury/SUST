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

public class RegisterProfile extends AccentButton implements ActionListener {
    public class Dialog extends ListPanel{
        public Dialog(JDialog dialog, String type){
            add(Box.createVerticalStrut(50));

            TilesPanel tilesPanel = new TilesPanel(8, 2, 10);
            tilesPanel.add(new Label("Registration"));
            tilesPanel.add(new TextField("Write Registration", TYPE.PLAIN));
            tilesPanel.add(new Label("Name"));
            tilesPanel.add(new TextField("Write Name", TYPE.PLAIN));
            if(type == "Student"){
                tilesPanel.add(new Label("Position (20xx-xx)"));
            } else {
                tilesPanel.add(new Label("Designation"));
            }
            tilesPanel.add(new TextField("Write Position", TYPE.PLAIN));
            tilesPanel.add(new Label("Number (Without +88)"));
            tilesPanel.add(new TextField("Write Number", TYPE.PLAIN));
            tilesPanel.add(new Label("Email"));
            tilesPanel.add(new TextField("Write Email", TYPE.PLAIN));
            tilesPanel.add(new Label("Blood Group (X+/-)"));
            tilesPanel.add(new TextField("Write Blood Group", TYPE.PLAIN));
            tilesPanel.add(new Label("Birthday (DD/MM/YYYY)"));
            tilesPanel.add(new TextField("Write Birthday", TYPE.PLAIN));
            tilesPanel.add(new Label("Hometown"));
            tilesPanel.add(new TextField("Write Hometown", TYPE.PLAIN));
            tilesPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(tilesPanel);
            add(new FileButton("Choose a photo"));
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
    public RegisterProfile(){
        super("Add new Profile");
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final JDialog dialog = new JDialog();
        final JOptionPane optionPane;
        int returnValue = JOptionPane.showOptionDialog(null, "Choose type", "Choose a type", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"Teacher", "Student"}, null);
        if(returnValue == JOptionPane.YES_OPTION){
            optionPane = new JOptionPane(new Dialog(dialog, "Teacher"), JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
        } else{
            optionPane = new JOptionPane(new Dialog(dialog, "Student"), JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
        }

        dialog.setTitle("Register a new profile");
        dialog.setModal(true);
        dialog.setContentPane(optionPane);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.pack();

        dialog.setVisible(true);

    }
}
