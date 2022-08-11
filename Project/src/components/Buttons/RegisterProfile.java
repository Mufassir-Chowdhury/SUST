package Components.Buttons;

import Components.Label;
import Components.InputFields.ComboBox;
import Components.InputFields.TextField;
import Components.InputFields.TextField.TYPE;
import Components.pageView.Panels.ListPanel;
import Components.pageView.Panels.TilesPanel;
import Constants.Sizes;
import Server.Datapoints.Student;

import java.awt.*;
import java.awt.event.*;

import javax.swing.Box;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import java.awt.Component;

public class RegisterProfile extends AccentButton implements ActionListener {
    public class Dialog extends ListPanel{
        public Dialog(JDialog dialog){
            add(Box.createVerticalStrut(50));
            String[] types = { "Teacher", "Student" };

            ComboBox<String> comboBox = new ComboBox<>(types);
            TextField registrationField= new TextField("Write Registration", TYPE.PLAIN);
            TextField nameField= new TextField("Write Name", TYPE.PLAIN);
            TextField positionField= new TextField("Write Position", TYPE.PLAIN);
            TextField numberField= new TextField("Write Number", TYPE.PLAIN);
            TextField emailField= new TextField("Write Email", TYPE.PLAIN);
            TextField bloodField= new TextField("Write Blood Group", TYPE.PLAIN);
            TextField birthdayField= new TextField("Write Birthday", TYPE.PLAIN);
            TextField hometownField= new TextField("Write Hometown", TYPE.PLAIN);

            TilesPanel tilesPanel = new TilesPanel(9, 2, 10);
            tilesPanel.add(new Label("Type"));
            tilesPanel.add(comboBox);
            tilesPanel.add(new Label("Registration"));
            tilesPanel.add(registrationField);
            tilesPanel.add(new Label("Name"));
            tilesPanel.add(nameField);
            tilesPanel.add(new Label("Position (20xx-xx) / designation for teachers"));
            tilesPanel.add(positionField);
            tilesPanel.add(new Label("Number (Without +88)"));
            tilesPanel.add(numberField);
            tilesPanel.add(new Label("Email"));
            tilesPanel.add(emailField);
            tilesPanel.add(new Label("Blood Group (X+/-)"));
            tilesPanel.add(bloodField);
            tilesPanel.add(new Label("Birthday (DD/MM/YYYY)"));
            tilesPanel.add(birthdayField);
            tilesPanel.add(new Label("Hometown"));
            tilesPanel.add(hometownField);
            tilesPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(tilesPanel);
            add(new FileButton("Choose a photo"));
            add(Box.createVerticalGlue());
            AccentButton proceed = new AccentButton("Proceed");
            proceed.setAlignmentX(Component.CENTER_ALIGNMENT);
            proceed.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    fetchData();
                    dialog.dispose();

                }
            });
            add(proceed);
        }

        private void fetchData() {
            Student student = new Student(registration, name, email, number, blood, birthDay, hometown, session, semester, regular, drop)
        }
    }
    public RegisterProfile(){
        super("Add new Profile");
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final JDialog dialog = new JDialog();
        final JOptionPane optionPane = new JOptionPane(new Dialog(dialog), JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);

        dialog.setTitle("Register a new profile");
        dialog.setModal(true);
        dialog.setContentPane(optionPane);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.pack();

        Dimension size = Sizes.DEFAULT_WINDOW_SIZE;
        dialog.setLocation((int)(size.getWidth()-dialog.getWidth())/2, (int)(size.getHeight()-dialog.getHeight())/2);
        
        dialog.setVisible(true);

    }
}
