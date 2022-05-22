package login;
import java.awt.Color;
import java.awt.Dimension;
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
import login.Utilities.showPassword;


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
    private String email, password;
    private boolean condition, flag;
    private FieldValidity fieldChecker = new FieldValidity();
    private Query database = new Query();

    
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
        emailField.addKeyListener(this);
        emailField.addFocusListener(this);

        passwordField.addFocusListener(passwordField);
        passwordField.addMouseListener(passwordField);
        passwordField.addKeyListener(passwordField);
        passwordField.addKeyListener(this);

        logInButton.addMouseListener(logInButton);
        logInButton.addFocusListener(logInButton);

        forgetPasswordText.addMouseListener(forgetPasswordText);
        forgetPasswordText.addFocusListener(forgetPasswordText);

        registerText.addMouseListener(registerText);
        registerText.addFocusListener(registerText);

        showPasswordCheckBox.addActionListener(e -> showPassword());
        logInButton.addActionListener(e -> {
            logInWithoutTry();
            tryingToLogIn();

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
    
    
    private void forgetPassword(){

    }

    private void register() throws ClassNotFoundException, IOException {
        page.LogIn("regiPage");
    }

    @Override
    public void keyTyped(KeyEvent e) {
        key = e.getKeyChar();
        if (key == KeyEvent.VK_ENTER) {
            flag = true;
            e.consume();
            logInWithoutTry();
            tryingToLogIn();
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
        if (source == emailField) {
            emailField.border = Colors.ACCENT;
            repaint();
        }

        
    }

    @Override
    public void focusLost(FocusEvent e) {
        source = e.getComponent();
        if (source == emailField) {
            if (key == KeyEvent.VK_ENTER & flag)
            {
                flag = false;
                return;
            }
            fetchData();
            condition = fieldChecker.checkThisEmail(email);
            showValidity(condition);
        }
    }
    

    private void logInWithoutTry()
    {
        try {
            page.LogIn("mainPage");
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    private void tryingToLogIn()
    {
        fetchData();

        if (isFieldFilled())
        {
            showValidity(condition);
            if(condition)
                if(database.runQuery(email, password))
                    try {
                        page.LogIn("mainPage");
                    } catch (ClassNotFoundException | IOException e) {
                        e.printStackTrace();
                    }

        }
            
    }

    private void fetchData()
    {
        email = emailField.getText();
        password = passwordField.getText();
    }

    public boolean isFieldFilled()
    {
        boolean a, b;
        a = fieldChecker.isEmailFieldFilled(email);
        if(a)
            condition = fieldChecker.checkThisEmail(email);
        
        if (a & !condition)
            JOptionPane.showMessageDialog(null, "email format is not right");
        
        b = fieldChecker.isPasswordFieldFilled(passwordField.getPassword());

        return a & b;
    }
    
    private void showValidity(boolean c)
    {
        if (c)
            emailField.border = Color.green;
        else
            emailField.border = Color.red;
        repaint();
    }
}