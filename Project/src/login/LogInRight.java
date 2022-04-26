package login;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.sql.ResultSet;
import java.util.Map;

class LogInRight extends JPanel {

    public RoundJButton logInButton;
    private String emailPlaceholder = " Email address";
    private String passwordPlaceholder = " Password"; 
    RoundJTextField emailField;
    RoundJPasswordField passwordField;
    JCheckBox showPasswordCheckBox;
    JLabel forgetPasswordText, registerText;
    private static final long serialVersionUID = 1L;    
    
    
    public LogInRight() {
        setBackground(new Color(0, 0, 0));
        setLayout(null);

        emailField = new RoundJTextField(20);
        passwordField = new RoundJPasswordField(20);
        showPasswordCheckBox = new JCheckBox();
        logInButton = new RoundJButton(20);
        forgetPasswordText = new JLabel();
        registerText = new JLabel();
        
        
        emailField.setBounds(40, 160, 340, 40);
        emailField.setBackground(new Color(135, 206, 250));
        emailField.setForeground(Color.black);
        emailField.setFont(new Font("Segoe UI", Font.ITALIC, 16));
        emailField.setMargin(new Insets(2, 10, 2, 2));
        emailField.setText(emailPlaceholder);
        emailField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
//            	if(e.getKeyCode()==KeyEvent.VK_BACK_SPACE) emailField.setText("");
                if(emailField.getText().equals(emailPlaceholder))
                {
                	
                	emailField.setText("");
                }
                    
            }
        });
        emailField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                emailField.setBackground(new Color(0, 191, 255));
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(emailField.getText().isEmpty() || emailField.getText().equals(emailPlaceholder)) {
                    emailField.setBackground(new Color(135, 206, 250));
                    emailField.setText(emailPlaceholder);
                }
            }
        });
        add(emailField);
        
        
        
        passwordField.setBounds(40, 250, 340, 40);
        passwordField.setBackground(new Color(135, 206, 250));
        passwordField.setForeground(Color.black);
        passwordField.setFont(new Font("Segoe UI", Font.ITALIC, 16));
        passwordField.setMargin(new Insets(2, 10, 2, 2));
        passwordField.setText(passwordPlaceholder);
        passwordField.setEchoChar('\u0000');
        passwordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(passwordField.getText().equals(passwordPlaceholder))
                {
                    passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                    if(showPasswordCheckBox.isSelected()==false) passwordField.setEchoChar('\u25cf');
                    passwordField.setText("");
                }
            }
        });
        passwordField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
            	passwordField.setBackground(new Color(0, 191, 255));
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(passwordField.getText().isEmpty() || passwordField.getText().equals(passwordPlaceholder)) {
                    passwordField.setEchoChar('\u0000');
                    passwordField.setBackground(new Color(135, 206, 250));
                    passwordField.setFont(new Font("Segoe UI", Font.ITALIC, 16));
                    passwordField.setText(passwordPlaceholder);
                }
            }
        });
        add(passwordField);
        
        
        showPasswordCheckBox.setBounds(270, 295, 110, 23);
        showPasswordCheckBox.setFocusPainted(false);
        showPasswordCheckBox.setBackground(new Color(0,0,0));
        showPasswordCheckBox.setForeground(new Color(135, 206, 250));
        showPasswordCheckBox.setBorder(null);
        showPasswordCheckBox.setText("Show Password");
        showPasswordCheckBox.setContentAreaFilled(false);
        showPasswordCheckBox.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(showPasswordCheckBox.isSelected())
                {
                    passwordField.setEchoChar('\u0000');
                    showPasswordCheckBox.setForeground(new Color(0, 191, 255));
                }
                if(showPasswordCheckBox.isSelected()==false)
                {
                    showPasswordCheckBox.setForeground(new Color(135, 206, 250));
                    if(passwordField.getPassword().equals(passwordPlaceholder)==false)
                        passwordField.setEchoChar('\u25cf');
                }
            }
        });
        add(showPasswordCheckBox);
        
        
        
        logInButton.setText("Log  In");
        logInButton.setBounds(40, 340, 340, 40);
        logInButton.setContentAreaFilled(false);
        logInButton.setFocusPainted(false);
        logInButton.setFont(new Font("MS UI Gothic", Font.BOLD, 23));
        logInButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        logInButton.setForeground(new Color(135, 206, 250));
        logInButton.setBackground(new Color(0, 0, 0));
        logInButton.setBorder(null);
        logInButton.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                logInButton.setForeground(new Color(30, 144, 255));
            }
            @Override
            public void focusLost(FocusEvent e) {
                logInButton.setForeground(new Color(135, 206, 250));
            }
        });
        logInButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                logInButton.setForeground(new Color(30, 144, 255));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                if(logInButton.isFocusOwner()) return;
                logInButton.setForeground(new Color(135, 206, 250));
            }
        	
        	public void mouseClicked(MouseEvent e) {
        		try {
        			String email = emailField.getText();
        			String password = passwordField.getText();
        			String query = "select * from login where email='"+email+"' and password='"+password+"'";
        			
        			conn c1 = new conn();
        			ResultSet exist = c1.s.executeQuery(query);
        			
        			if(exist.next()) {
        				JFrame frame = new JFrame();
//        				LogInPage().setVisible(false);
        				frame.setBounds(100,100,100,100);
        				frame.setVisible(true);
        			}
        		}catch(Exception ee) {
        			ee.printStackTrace();
        		}
        	}
        });
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