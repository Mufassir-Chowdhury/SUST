package login;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Components.RoundJPasswordField;
import Components.RoundJTextField;
import Components.Buttons.RoundJButton;
import Components.Buttons.RoundJButton.Style;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.util.Arrays;
// import java.sql.ResultSet;
import java.util.Map;

class LogInRight extends JPanel {

    private RoundJButton logInButton = new RoundJButton(20, "Log In", Style.ACCENT);
    private RoundJTextField emailField = new RoundJTextField(20, " Email Address");
    private RoundJPasswordField passwordField = new RoundJPasswordField(20, false);
    private JCheckBox showPasswordCheckBox = new JCheckBox();
    private JLabel forgetPasswordText = new JLabel();
    private JLabel registerText = new JLabel();
    private char[] defaultPassword = new char[]{' ', 'p','a','s','s','w','o','r','d'};
    private static final long serialVersionUID = 1L;    
    
    
    public LogInRight() {
        setBackground(new Color(0, 0, 0));
        setLayout(null);
        
        emailField.addFocusListener(emailField);
        emailField.addKeyListener(emailField);
        add(emailField);
        
        passwordField.addFocusListener(passwordField);
        passwordField.addKeyListener(passwordField);
        add(passwordField);
        
        
        
        showPasswordCheckBox.setBounds(270, 295, 110, 23);
        showPasswordCheckBox.setFocusPainted(false);
        showPasswordCheckBox.setBackground(new Color(0,0,0));
        showPasswordCheckBox.setForeground(new Color(135, 206, 250));
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
//                    if(passwordField.getPassword().equals(passwordPlaceholder)==false)
                    if(Arrays.equals(passwordField.getPassword(), defaultPassword)==false)
                        passwordField.setEchoChar('\u25cf');
                }
            }
        });
        add(showPasswordCheckBox);
        
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
        
        add(logInButton);
        
        forgetPasswordText.setText("Forgotten Password?");
        forgetPasswordText.setHorizontalAlignment(SwingConstants.RIGHT);
        forgetPasswordText.setBounds(105, 396, 140, 25);
        forgetPasswordText.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        forgetPasswordText.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        forgetPasswordText.setForeground(new Color(30, 144, 255));
        forgetPasswordText.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                Font font = forgetPasswordText.getFont();
                Map adding = font.getAttributes();
                adding.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                forgetPasswordText.setFont(font.deriveFont(adding));
                
            }
            @Override
            public void mouseExited(MouseEvent e) {
                forgetPasswordText.setFont(new Font("Segoe UI", Font.PLAIN, 15));
            }
        });
        add(forgetPasswordText);
        
        registerText.setText("Register");
        registerText.setHorizontalAlignment(SwingConstants.LEFT);
        registerText.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerText.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        registerText.setBounds(255, 396, 60, 25);
        registerText.setForeground(new Color(30, 144, 255));
        registerText.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                Font font = registerText.getFont();
                Map adding = font.getAttributes();
                adding.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                registerText.setFont(font.deriveFont(adding));
                
            }
            @Override
            public void mouseExited(MouseEvent e) {
                registerText.setFont(new Font("Segoe UI", Font.PLAIN, 15));
            }
        });
        add(registerText);


    }

}