package Components.Buttons;

import Components.Label;
import Components.InputFields.ComboBox;
import Components.InputFields.TextField;
import Components.InputFields.TextField.TYPE;
import Components.pageView.Panels.ListPanel;
import Components.pageView.Panels.TilesPanel;
import Constants.Sizes;
import Server.Datapoints;
import Server.Datapoints.Student;
import Server.Datapoints.Teacher;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import java.awt.Component;

public class RegisterProfile extends AccentButton implements ActionListener {
    public class Dialog extends ListPanel {

        String[] bgGroup = { "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-" };
        String[] semester = { "1-1", "1-2", "2-1", "2-2", "3-1", "3-2", "4-1", "4-2" };
        String[] designation = { "Lecturer", "Assistant Professor", "Professor" };

        ComboBox<String> departmentField = new ComboBox<>(Datapoints.getInstance().Departments);
        TextField registrationField = new TextField("Write Registration", TYPE.PLAIN);

        TextField nameField = new TextField("Write Name", TYPE.PLAIN);
        ComboBox<String> DesignationField = new ComboBox<>(designation);
        TextField sessionField = new TextField("Write Session", TYPE.PLAIN);
        ComboBox<String> semesterField = new ComboBox<>(semester);

        TextField numberField = new TextField("Write Number", TYPE.PLAIN);
        TextField emailField = new TextField("Write Email", TYPE.PLAIN);
        ComboBox<String> bloodField = new ComboBox<>(bgGroup);
        TextField birthdayField = new TextField("Write Birthday", TYPE.PLAIN);
        TextField hometownField = new TextField("Write Hometown", TYPE.PLAIN);

        public Dialog(JDialog dialog, String type) {
            add(Box.createVerticalStrut(50));

            TilesPanel tilesPanel = new TilesPanel(9, 2, 10);
            if (type == "Student") {
                tilesPanel.add(new Label("Registration"));
                tilesPanel.add(registrationField);
            } else {
                tilesPanel.add(new Label("Department"));
                tilesPanel.add(departmentField);
            }

            tilesPanel.add(new Label("Name"));
            tilesPanel.add(nameField);

            if (type == "Student") {
                tilesPanel.add(new Label("Session (20xx-xx)"));
                tilesPanel.add(sessionField);
                tilesPanel.add(new Label("Semester"));
                tilesPanel.add(semesterField);
            } else {
                tilesPanel.add(new Label("Designation"));
                tilesPanel.add(DesignationField);
            }
            tilesPanel.add(new Label("Email"));
            tilesPanel.add(emailField);
            tilesPanel.add(new Label("Number (Without +88)"));
            tilesPanel.add(numberField);
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
            proceed.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        fetchDataAndPassToClient(type);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    dialog.dispose();

                }
            });
            add(proceed);
        }

        private void fetchDataAndPassToClient(String type) throws IOException {
            if (type == "Student") {
                Student student = new Student(registrationField.getText(), nameField.getText(), emailField.getText(),
                        numberField.getText(), bloodField.getSelectedItem().toString(), birthdayField.getText(),
                        hometownField.getText(),
                        sessionField.getText(), semesterField.getSelectedItem().toString(), null, null);
                Datapoints.getInstance().client.add(student, Datapoints.ADD_STUDENT);
            }
            if (type == "Teacher") {
                Teacher teacher = new Teacher(departmentField.getSelectedItem().toString(), nameField.getText(),
                        emailField.getText(), DesignationField.getSelectedItem().toString(), numberField.getText(),
                        bloodField.getSelectedItem().toString(), birthdayField.getText(), hometownField.getText());
                Datapoints.getInstance().client.add(teacher, Datapoints.ADD_TEACHER);
            }
        }
    }

    public RegisterProfile() {
        super("Add new Profile");
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final JDialog dialog = new JDialog();
        final JOptionPane optionPane;
        int returnValue = JOptionPane.showOptionDialog(null, "Choose type", "Choose a type", JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, new Object[] { "Teacher", "Student" }, null);
        if (returnValue == JOptionPane.YES_OPTION) {
            optionPane = new JOptionPane(new Dialog(dialog, "Teacher"), JOptionPane.INFORMATION_MESSAGE,
                    JOptionPane.DEFAULT_OPTION, null, new Object[] {}, null);
        } else if (returnValue == JOptionPane.NO_OPTION) {
            optionPane = new JOptionPane(new Dialog(dialog, "Student"), JOptionPane.INFORMATION_MESSAGE,
                    JOptionPane.DEFAULT_OPTION, null, new Object[] {}, null);
        }
        else return;

        dialog.setTitle("Register a new profile");
        dialog.setModal(true);
        dialog.setContentPane(optionPane);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.pack();

        Dimension size = Sizes.DEFAULT_WINDOW_SIZE;
        dialog.setLocation((int) (size.getWidth() - dialog.getWidth()) / 2,
                (int) (size.getHeight() - dialog.getHeight()) / 2);

        dialog.setVisible(true);

    }
}
