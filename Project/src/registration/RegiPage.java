package registration;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Components.InputFields.TextField;
import Components.InputFields.TextField.CustomTextField;
import Components.InputFields.TextField.TYPE;
import Constants.Sizes;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class RegiPage extends JScrollPane {
	private JPanel titlePanel, allFieldPanel,
			row1, emailPanel, secondaryEmailPanel,
			row2, firstNamePanel, lastNamePanel,
			row3, registrationNoPanel, departmentPanel,
			row4, sessionPanel, contactNoPanel,
			row5, hometownPanel, birthdayPanel,
			row6, bloodGroupPanel, photoPanel,
			row7, passwordPanel, confirmPasswordPanel;
						
	private JLabel registerTitle,
			emailLabel, secondaryEmailLabel,
			firstNameLabel, lastNameLabel,
			registrationNoLabel, departmentLabel,
			sessionLabel, contactNoLabel,
			hometownLabel, birthdayLabel,
			bloodGroupLabel, photoLabel,
			passwordLabel, confirmPasswordLabel;
	
	private JTextField 
			emailField, secondaryEmailField,
			firstNameField, lastNameField,
			registrationNoField, departmentField,
			sessionField, contactNoField,
			hometownField, birthdayField,
			bloodGroupField, photoField,
			passwordField, confirmPasswordField;
						
	
					
	private JPanel createColumn(JPanel col, JLabel label,
			String text, JTextField field) 
	{
		col = new JPanel();
		col.setLayout(new BoxLayout(col, BoxLayout.X_AXIS));
		label = new JLabel(text);
		field = new TextField("", TYPE.PLAIN);
		col.add(label);
		col.add(Box.createHorizontalStrut(Sizes.CARD_SPACING_LONG));
		col.add(field);
		return col;
	}						

	private void createRow(JPanel row, JPanel col1, JPanel col2,
			JLabel label1, JLabel label2,
			String text1, String text2,
			JTextField field1, JTextField field2) 
	{
		row = new JPanel();
		row.setLayout(new BoxLayout(row, BoxLayout.X_AXIS));

		row.add(createColumn(col1, label1, text1, field1));
		row.add(Box.createHorizontalStrut(Sizes.CARD_SPACING_LONG));
		row.add(createColumn(col2, label2, text2, field2));
		
		allFieldPanel.add(row);
		allFieldPanel.add(Box.createVerticalStrut(Sizes.CARD_SPACING));
	}
	

	public RegiPage() {
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);
		setSize(1000, 400);

		titlePanel = new JPanel();
		titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		registerTitle = new JLabel("Registration");
		titlePanel.add(registerTitle);
		setColumnHeaderView(titlePanel);
		

		allFieldPanel = new JPanel();
		setViewportView(allFieldPanel);
		allFieldPanel.setLayout(new BoxLayout(allFieldPanel, BoxLayout.Y_AXIS));
		allFieldPanel.add(Box.createVerticalStrut(Sizes.CARD_SPACING));

		createRow(row1, emailPanel, secondaryEmailPanel,
				emailLabel, secondaryEmailLabel,
				"Email", "Secondary Email",
				emailField, secondaryEmailField);

		createRow(row2, firstNamePanel, lastNamePanel,
				firstNameLabel, lastNameLabel,
				"First Name", "Last Name",
				firstNameField, lastNameField);
		
		createRow(row3, registrationNoPanel, departmentPanel,
				registrationNoLabel, departmentLabel,
				"Registration No", "Department",
				registrationNoField, departmentField);
		
		createRow(row4, sessionPanel, contactNoPanel,
				sessionLabel, contactNoLabel,
				"Session", "Contact No",
				sessionField, contactNoField);

		createRow(row5, hometownPanel, birthdayPanel,
				hometownLabel, birthdayLabel,
				"Hometown", "Birthday",
				hometownField, birthdayField);

		createRow(row6, bloodGroupPanel, photoPanel,
				bloodGroupLabel, photoLabel,
				"Blood Group", "Upload Photo",
				bloodGroupField, photoField);
	}

}