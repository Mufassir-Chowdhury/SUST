package login;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import Components.RoundJPasswordField;
import Components.RoundJTextField;
import Components.Buttons.AccentButton;
import Components.Buttons.HyperLinkButton;
import Constants.Sizes;
import Constants.Values;
import login.Utilities.showPassword;

import java.awt.Color;
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
    private showPassword showPasswordCheckBox = new Utilities.showPassword();
    private HyperLinkButton forgetPasswordText = new HyperLinkButton("Forget Password?");
    private HyperLinkButton registerText = new HyperLinkButton("Create an account!");
    private static final long serialVersionUID = 1L;  
    private Box line = Box.createHorizontalBox();
    private LogInPage page;
    
    public LogInRight(LogInPage page) {
        this.page = page;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setOpaque(false);
        
        line.add(Box.createRigidArea(new Dimension(Sizes.TEXT_FIELD_SIZE.width - Sizes.CHECKBOX_SIZE.width, Sizes.BUTTON_SIZE.height)));
        line.add(showPasswordCheckBox);

        add(Box.createVerticalGlue());
        add(emailField);
        add(Box.createVerticalStrut(30));
        add(passwordField);
        add(Box.createVerticalStrut(10));
        add(line);
        add(Box.createVerticalStrut(20));
        add(logInButton);
        add(Box.createVerticalStrut(20));

        line = Box.createHorizontalBox() ;
        line.add(Box.createHorizontalGlue());
        line.add(forgetPasswordText);
        line.add(Box.createHorizontalGlue());
        line.add(registerText);
        line.add(Box.createHorizontalGlue());
        add(line);
    
        add(Box.createVerticalGlue());

        addListeners();

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

    private void addListeners(){
        emailField.addFocusListener(emailField);
        emailField.addKeyListener(emailField);
        
        passwordField.addFocusListener(passwordField);
        passwordField.addKeyListener(passwordField);
        
        showPasswordCheckBox.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showPassword();
            }
        });

        logInButton.addKeyListener(logInButton);
        logInButton.addMouseListener(logInButton);
        logInButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                page.LogIn();
            }
        });
    }

}