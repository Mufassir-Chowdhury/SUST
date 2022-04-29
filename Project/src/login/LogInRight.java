package login;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Components.RoundJPasswordField;
import Components.RoundJTextField;
import Components.Buttons.AccentButton;
import Components.Buttons.HyperLinkButton;
import Components.Buttons.RoundJButton;
import Constants.Colors;
import Constants.Fonts;
import Constants.Sizes;
import Constants.Values;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
// import java.sql.ResultSet;

class LogInRight extends JPanel {

    private AccentButton logInButton = new AccentButton("Log In");
    private RoundJTextField emailField = new RoundJTextField(" Email Address");
    private RoundJPasswordField passwordField = new RoundJPasswordField(false);
    private JCheckBox showPasswordCheckBox = new JCheckBox();
    private HyperLinkButton forgetPasswordText = new HyperLinkButton("Forget Password?");
    private HyperLinkButton registerText = new HyperLinkButton("Create an account!");
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
        
        showPasswordCheckBox.setSize(Sizes.CHECKBOX_SIZE);
        showPasswordCheckBox.setFocusPainted(false);
        showPasswordCheckBox.setBackground(Colors.PLAIN_TEXT);
        showPasswordCheckBox.setForeground(Colors.ACCENT);
        showPasswordCheckBox.setBorder(null);
        showPasswordCheckBox.setText("Show Password");
        showPasswordCheckBox.setContentAreaFilled(false);
        showPasswordCheckBox.setFocusable(false);
        showPasswordCheckBox.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showPassword();
            }
        });
        line.add(Box.createRigidArea(new Dimension(Sizes.TEXT_FIELD_SIZE.width - Sizes.CHECKBOX_SIZE.width, Sizes.BUTTON_SIZE.height)));
        line.add(showPasswordCheckBox);
        line.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(line);
        add(Box.createVerticalStrut(20));

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
        
        line.add(forgetPasswordText);
        
        line.add(Box.createHorizontalGlue());
        
        line.add(registerText);
        
        line.add(Box.createHorizontalGlue());
        line.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(line);
        
        add(Box.createVerticalGlue());

    }

    private void showPassword(){
        if(showPasswordCheckBox.isSelected()){
            passwordField.setEchoChar(Values.PASSWORD_PLAIN_ECHO_CHAR);
            showPasswordCheckBox.setForeground(new Color(0, 191, 255));
        }
        if(showPasswordCheckBox.isSelected()==false){
            showPasswordCheckBox.setForeground(new Color(135, 206, 250));
            if(Arrays.equals(passwordField.getPassword(), Values.DEFAULT_PASSWORD)==false)
                passwordField.setEchoChar(Values.PASSWORD_ECHO_CHAR);
        }
       
    }

}