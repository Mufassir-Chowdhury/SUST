package login;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
// import java.sql.ResultSet;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Components.RoundJPasswordField;
import Components.RoundJTextField;
import Components.Buttons.AccentButton;
import Components.Buttons.HyperLinkButton;
import Constants.Sizes;
import Constants.Values;
import Constants.conn;
import login.Utilities.showPassword;
import java.sql.ResultSet;


public class LogInRight extends JPanel implements KeyListener {

    private AccentButton logInButton = new AccentButton("Log In");
    private RoundJTextField emailField = new RoundJTextField(" Email Address");
    private RoundJPasswordField passwordField = new RoundJPasswordField(false);
    private showPassword showPasswordCheckBox = new Utilities.showPassword();
    private HyperLinkButton forgetPasswordText = new HyperLinkButton("Forget Password?");
    private HyperLinkButton registerText = new HyperLinkButton("Create an account!");
    private static final long serialVersionUID = 1L;  
    private Box line = Box.createHorizontalBox();
    private LogInPage page;
    private Component source;
    private char key;
    
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

    private void addListeners() {
        emailField.addFocusListener(emailField);
        emailField.addMouseListener(emailField);
        emailField.addKeyListener(emailField);

        passwordField.addFocusListener(passwordField);
        passwordField.addMouseListener(passwordField);
        passwordField.addKeyListener(passwordField);

        // showPasswordCheckBox.addMouseListener(showPasswordCheckBox);

        logInButton.addMouseListener(logInButton);
        logInButton.addFocusListener(logInButton);

        forgetPasswordText.addMouseListener(forgetPasswordText);
        forgetPasswordText.addFocusListener(forgetPasswordText);

        registerText.addMouseListener(registerText);
        registerText.addFocusListener(registerText);

        showPasswordCheckBox.addActionListener(e -> showPassword());
        logInButton.addActionListener(e -> {
            try {
                fetchData();
            } catch (ClassNotFoundException | IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });
        forgetPasswordText.addActionListener(l -> forgetPassword());
        registerText.addActionListener(l -> register());
    }
    
    private void fetchData() throws ClassNotFoundException, IOException {
        page.LogIn();
        try{
            String email = emailField.getText();
            String password = passwordField.getText();
            String query = "select * from login where email = '" + email + "' and password = '" + password + "'";

            conn c1 = new conn();
            ResultSet exist = c1.s.executeQuery(query);
            if (exist.next()) {
                page.LogIn();
            }
            else {
                JOptionPane.showMessageDialog(null, "Invalid LogIn");
                //TODO seti visibility of logInPage false
            }

            System.out.println(query);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
    }
    private void forgetPassword(){

    }
    private void register(){

    }

    @Override
    public void keyTyped(KeyEvent e) {
        source = e.getComponent();
        key = e.getKeyChar();
        if (key == KeyEvent.VK_ENTER) {
            try {
                fetchData();
            } catch (ClassNotFoundException | IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
        else if(source == emailField)
            emailField.cleanField();
        else if(source == passwordField)
            passwordField.cleanField();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        key = e.getKeyChar();
        source = e.getComponent();
        if (key == KeyEvent.VK_BACK_SPACE)
        {
            if(source == emailField)
                emailField.cleanField();
            else if(source == passwordField)
                passwordField.cleanField();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

}