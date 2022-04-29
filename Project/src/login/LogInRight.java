package login;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Components.RoundJPasswordField;
import Components.RoundJTextField;
import Components.Buttons.RoundJButton;
import Components.Buttons.RoundJButton.Style;
import Constants.Colors;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
// import java.sql.ResultSet;

class LogInRight extends JPanel {

    private RoundJButton logInButton = new RoundJButton(20, "Log In", Style.ACCENT);
    private RoundJTextField emailField = new RoundJTextField(20, " Email Address");
    private RoundJPasswordField passwordField = new RoundJPasswordField(20, false);
    private JCheckBox showPasswordCheckBox = new JCheckBox();
    private JLabel forgetPasswordText = new JLabel();
    private JLabel registerText = new JLabel();
    private char[] defaultPassword = new char[]{' ', 'p','a','s','s','w','o','r','d'};
    private static final long serialVersionUID = 1L;    
    
    
    public LogInRight(LogInPage page) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setAlignmentY(Component.CENTER_ALIGNMENT);
        setOpaque(false);
        add(Box.createVerticalGlue());

        emailField.addFocusListener(emailField);
        emailField.addKeyListener(emailField);
        emailField.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(emailField);

        add(Box.createVerticalStrut(30));
        
        passwordField.addFocusListener(passwordField);
        passwordField.addKeyListener(passwordField);
        passwordField.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(passwordField);
        
        add(Box.createVerticalStrut(10));

        Box line = Box.createHorizontalBox();
        
        showPasswordCheckBox.setSize(110, 23);
        showPasswordCheckBox.setFocusPainted(false);
        showPasswordCheckBox.setBackground(new Color(0,0,0));
        showPasswordCheckBox.setForeground(Colors.ACCENT);
        showPasswordCheckBox.setBorder(null);
        showPasswordCheckBox.setText("Show Password");
        showPasswordCheckBox.setContentAreaFilled(false);
        showPasswordCheckBox.setFocusable(false);
        showPasswordCheckBox.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(showPasswordCheckBox.isSelected()){
                    passwordField.setEchoChar('\u0000');
                    showPasswordCheckBox.setForeground(new Color(0, 191, 255));
                }
                if(showPasswordCheckBox.isSelected()==false){
                    showPasswordCheckBox.setForeground(new Color(135, 206, 250));
                    if(Arrays.equals(passwordField.getPassword(), defaultPassword)==false)
                        passwordField.setEchoChar('\u25cf');
                }
            }
        });
        line.add(Box.createRigidArea(new Dimension(240, 23)));
        line.add(showPasswordCheckBox);
        line.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(line);
        add(Box.createVerticalStrut(20));

        
//         logInButton.addMouseListener(new MouseAdapter() {
        	
// //         	public void mouseClicked(MouseEvent e) {
// //         		try {
// //         			String email = emailField.getText();
// //         			String password = passwordField.getText();
// //         			String query = "select * from login where email='"+email+"' and password='"+password+"'";
        			
// //         			conn c1 = new conn();
// //         			ResultSet exist = c1.s.executeQuery(query);
        			
// //         			if(exist.next()) {
// //         				JFrame frame = new JFrame();
// // //        				LogInPage().setVisible(false);
// //         				frame.setBounds(100,100,100,100);
// //         				frame.setVisible(true);
// //         			}
// //         		}catch(Exception ee) {
// //         			ee.printStackTrace();
// //         		}
// //         	}
//         });

        logInButton.addKeyListener(logInButton);
        logInButton.addMouseListener(logInButton);
        logInButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                page.LogIn();
            }

        });
        logInButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(logInButton);

        add(Box.createVerticalStrut(20));

        line = Box.createHorizontalBox() ;
        line.add(Box.createHorizontalGlue());
        
        forgetPasswordText.setText("Forgotten Password?");
        forgetPasswordText.setSize(140, 25);
        forgetPasswordText.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        forgetPasswordText.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        forgetPasswordText.setForeground(Colors.ACCENT);
        line.add(forgetPasswordText);
        
        line.add(Box.createHorizontalGlue());
        
        registerText.setText("Register");
        registerText.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerText.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        registerText.setSize(140, 25);
        registerText.setForeground(Colors.ACCENT);
        line.add(registerText);
        
        line.add(Box.createHorizontalGlue());
        line.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(line);
        
        add(Box.createVerticalGlue());

    }

}