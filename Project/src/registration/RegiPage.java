package registration;

import javax.swing.JPanel;

import Components.InputFields.TextField;
import Components.InputFields.TextField.TYPE;
import Components.pageView.Panels.TilesPanel;
import Components.pageView.Panels.ViewPort;
import java.awt.*;
import java.io.IOException;

import Main.Main;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Constants.Fonts;
import Constants.Padding;
import Constants.Sizes;
import Constants.Colors;

public class RegiPage extends ViewPort {
	private JPanel
			row1, emailPanel, secondaryEmailPanel,
			row2, firstNamePanel, lastNamePanel,
			row3, registrationNoPanel, departmentPanel,
			row4, sessionPanel, contactNoPanel,
			row5, hometownPanel, birthdayPanel,
			row6, bloodGroupPanel, photoPanel,
			row7, passwordPanel, confirmPasswordPanel;

	private JLabel
			emailLabel, secondaryEmailLabel,
			firstNameLabel, lastNameLabel,
			registrationNoLabel, departmentLabel,
			sessionLabel, contactNoLabel,
			hometownLabel, birthdayLabel,
			bloodGroupLabel, photoLabel,
			passwordLabel, confirmPasswordLabel;
		
	private TextField 
			emailField, secondaryEmailField,
			firstNameField, lastNameField,
			registrationNoField, departmentField,
			sessionField, contactNoField,
			hometownField, birthdayField,
			bloodGroupField, photoField,
			passwordField, confirmPasswordField;
			
	TilesPanel allFieldPanel;

	private JPanel createColumn(JPanel col, JLabel label,
			String text, TextField field) 
	{
		col = new JPanel();
		col.setOpaque(false);
		col.setLayout(new BoxLayout(col, BoxLayout.X_AXIS));

		label = new JLabel(text+" :");
		label.setFont(Fonts.BODY_LARGE);
		label.setForeground(Colors.ACCENT_TEXT);
		
		field = new TextField("", TYPE.PLAIN);

		col.add(label);
		col.add(Box.createHorizontalGlue());
		col.add(field);

		return col;
	}

	private void createRow(JPanel row, JPanel col1, JPanel col2,
			JLabel label1, JLabel label2,
			String text1, String text2,
			TextField field1, TextField field2) 
	{

		allFieldPanel.add(createColumn(col1, label1, text1, field1));
		allFieldPanel.add(createColumn(col2, label2, text2, field2));
	}


	public RegiPage(Main main) throws ClassNotFoundException, IOException {
		super("Registration");
		
		setBorder(Padding.REGISTRATION_VIEW_PORT);
		setAlignmentY(Component.LEFT_ALIGNMENT);

		allFieldPanel = new TilesPanel(7, 2, (int)Sizes.USABLE_WINDOW_SIZE.getWidth()/10, 10);
		
		add(allFieldPanel);

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

		createRow(row7, passwordPanel, confirmPasswordPanel,
				passwordLabel, confirmPasswordLabel,
				"Password", "Confirm Password",
				passwordField, confirmPasswordField);
		
	}

}
