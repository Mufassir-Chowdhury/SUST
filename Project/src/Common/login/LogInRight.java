package Common.login;
import java.awt.Dimension;
import java.awt.event.*;
import java.awt.Component;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import Common.login.Utilities.showPassword;
import Components.Label;
import Components.Buttons.AccentButton;
import Components.Buttons.HyperLinkButton;
import Components.InputFields.TextField;
import Constants.Colors;
import Constants.Fonts;
import Constants.Sizes;
import Constants.Values;
import Server.Datapoints;


public class LogInRight extends JPanel implements KeyListener, FocusListener {

    private AccentButton logInButton = new AccentButton("Log In");
    public TextField emailField = new TextField(Values.EMAIL_PLACEHOLDER, TextField.TYPE.PLAIN);
    public TextField passwordField = new TextField(false, TextField.TYPE.PASSWORD);
    private showPassword showPasswordCheckBox = new Utilities.showPassword();
    private HyperLinkButton forgetPasswordText = new HyperLinkButton("Forgotten  Password?");
    
    private static final long serialVersionUID = 1L;  
    private Box line = Box.createHorizontalBox();
    private LogInPage page;
    private Component source;
    private Character key = KeyEvent.VK_ENTER;
    private String email, password;
    private String mode;
    private boolean condition;
    private FieldValidity fieldChecker = new FieldValidity();
    
    public LogInRight(LogInPage page, String mode) {
        this.mode = mode;
        this.page = page;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setOpaque(false);

        line.add(Box.createRigidArea(
                new Dimension(Sizes.TEXT_FIELD_SIZE.width - Sizes.CHECKBOX_SIZE.width, Sizes.BUTTON_SIZE.height)));
        line.add(showPasswordCheckBox);

        add(Box.createVerticalGlue());
        add(new Label(mode + " Portal", Fonts.DISPLAY, Component.CENTER_ALIGNMENT));
        add(Box.createVerticalStrut(30));
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
        forgetPasswordText.setFocusable(false);
        line.add(forgetPasswordText);
        line.add(Box.createHorizontalGlue());
        add(line);

        add(Box.createVerticalGlue());

        addListeners();
    }

    private void showPassword(){
        if(showPasswordCheckBox.isSelected()){
            showPasswordCheckBox.setForeground(Colors.CheckBox.SELECTED);
            passwordField.showPassword = true;
            passwordField.setEchoChar(Values.PASSWORD_PLAIN_ECHO_CHAR);
            
        }
        if(showPasswordCheckBox.isSelected()==false){
            showPasswordCheckBox.setForeground(Colors.CheckBox.UNSELECTED);
            if(Arrays.equals(passwordField.getPassword(), Values.PASSWORD_PLACEHOLDER_CHAR)==false)
                passwordField.setEchoChar(Values.PASSWORD_ECHO_CHAR);
        }
    }

    private void addListeners() {        
        emailField.addKeyListener(this);
        emailField.addFocusListener(this);
        passwordField.addKeyListener(this);
        passwordField.addFocusListener(this);

        logInButton.addKeyListener(this);

        showPasswordCheckBox.addActionListener(e -> showPassword());
        logInButton.addActionListener(e -> {
            try {
                System.err.println("cicked");
                logInWithFetch(mode);
            } catch (IOException | ClassNotFoundException e1) {
                e1.printStackTrace();
            }

        });
        forgetPasswordText.addActionListener(l -> forgetPassword());

        addKeyListener(this);
        addFocusListener(this);
    }
    
    
    private void forgetPassword(){

    }

    @Override
    public void keyTyped(KeyEvent e) {
        key = e.getKeyChar();
        if (key == KeyEvent.VK_ENTER) {
            e.consume();
            logInButton.requestFocus();

            updateEmailStatus(key.getClass());
            logInWithoutFetch();
            try {
                logInWithFetch(mode);
            } catch (IOException | ClassNotFoundException e1) {
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
        if (source == emailField) {
            typing(emailField);
        }

        if (source == passwordField) {
            typing(passwordField);
        }
        
    }

    @Override
    public void focusLost(FocusEvent e) {
        source = e.getComponent();
        if (source == emailField) {
            updateEmailStatus("".getClass());
        }
    }



    private void fetchData()
    {
        email = emailField.getText();
        password = passwordField.getText();
    }
    
    private void showFieldValidity(TextField field, boolean condition)
    {
        if (condition)
            field.border = Colors.TextField.VALID;
        else {
            field.border = Colors.TextField.INVALID;
        }

        repaint();
    }

    private void updateEmailStatus(Object x)
    {
        fetchData();
        if (fieldChecker.isEmailFieldFilled(email)) {
            condition = fieldChecker.checkThisEmail(email, mode);
            showFieldValidity(emailField, condition);
        }
        else if(x == key.getClass())
        {
            //TODO emailFieldLabel change to "please fill up this field"
        }
    }
    
    private boolean isGreen()
    {
        if (emailField.border == Colors.TextField.VALID)
        {
            if(fieldChecker.isPasswordFieldFilled(password.toCharArray()))
                return true;
        }
        return false;
    }
    
    private void nextPage(String panel)
    {
        try {
            page.LogIn(panel);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    private void logInWithFetch(String mode) throws IOException, ClassNotFoundException
    {
        fetchData();
        if (isGreen()) {
            condition = Datapoints.getInstance().client.login(mode, email, password).equals("true");

            if (mode.equals("Administrator")) {

            }
            if (mode.equals("Student")) {

            }
            if (mode.equals("Teacher")) {

            }

        }
        logInWithoutFetch();
    }

    private void logInWithoutFetch()
    {
        nextPage("mainPage");
    }

    private void typing(TextField field)
    {
        field.border = Colors.Theme.ACCENT;
        repaint();
    }
    
}