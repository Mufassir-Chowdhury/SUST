package login;
import java.awt.Color;
import java.awt.Dimension;
// import java.sql.ResultSet;
import java.awt.event.*;
import java.awt.Component;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Components.Buttons.AccentButton;
import Components.Buttons.HyperLinkButton;
import Components.InputFields.TextField;
import Constants.Colors;
import Constants.Sizes;
import Constants.Values;
import Constants.conn;
import login.Utilities.showPassword;
import java.sql.ResultSet;


public class LogInRight extends JPanel implements KeyListener, FocusListener {

    private AccentButton logInButton = new AccentButton("Log In");
    private TextField emailField = new TextField(" Email Address", TextField.TYPE.PLAIN);
    private TextField passwordField = new TextField(false, TextField.TYPE.PASSWORD);
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

        line.add(Box.createRigidArea(
                new Dimension(Sizes.TEXT_FIELD_SIZE.width - Sizes.CHECKBOX_SIZE.width, Sizes.BUTTON_SIZE.height)));
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

        line = Box.createHorizontalBox();
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
            showPasswordCheckBox.setForeground(new Color(0, 191, 255));
            passwordField.showPassword = true;
            passwordField.setEchoChar(Values.PASSWORD_PLAIN_ECHO_CHAR);
            
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
        emailField.addFocusListener(this);

        passwordField.addFocusListener(passwordField);
        passwordField.addMouseListener(passwordField);
        passwordField.addKeyListener(passwordField);

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
                e1.printStackTrace();
            }
        });
        forgetPasswordText.addActionListener(l -> forgetPassword());
        registerText.addActionListener(e -> {
            try {
                register();
            } catch (ClassNotFoundException | IOException e1) {
                e1.printStackTrace();
            }
        });
    }
    
    private void fetchData() throws ClassNotFoundException, IOException {
        page.LogIn("mainPage");
        try{
            String email = emailField.getText();
            String password = passwordField.getText();
            String query = "select * from login where email = '" + email + "' and password = '" + password + "'";

            conn c1 = new conn();
            ResultSet exist = c1.s.executeQuery(query);
            if (exist.next()) {
                page.LogIn("mainPage");
            }
            else {
                JOptionPane.showMessageDialog(null, "Invalid LogIn");
            }

            System.out.println(query);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
    }
    private void forgetPassword(){

    }

    private void register() throws ClassNotFoundException, IOException {
        page.LogIn("regiPage");
    }

    private void checkValidity(String input)
    {
        String format = ".sust.edu";
        if(input.equals(" Email Address")) return;
        if (input.endsWith(format)) {
            emailField.setForeground(Color.green);
        }
        else
        {
            emailField.setForeground(Color.red);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        key = e.getKeyChar();
        if (key == KeyEvent.VK_ENTER) {
            try {
                fetchData();
            } catch (ClassNotFoundException | IOException e1) {
                e1.printStackTrace();
            }
            return;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public void focusGained(FocusEvent e) {
        source = e.getComponent();
        if(source == emailField)
        {
            emailField.setForeground(Colors.PLAIN_TEXT);
        }
        
    }

    @Override
    public void focusLost(FocusEvent e) {
        source = e.getComponent();
        if(source == emailField)
        {
            checkValidity(emailField.getText());
        }
    }

}