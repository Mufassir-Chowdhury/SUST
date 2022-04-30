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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.KeyListener;
import java.awt.event.FocusListener;
import java.awt.Color;
import java.awt.Component;
import java.util.Arrays;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.Dimension;
// import java.sql.ResultSet;

public class LogInRight extends JPanel implements KeyListener, FocusListener, MouseListener, MouseMotionListener{

    public AccentButton logInButton = new AccentButton("Log In");
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

    private void addListeners(){
        emailField.addFocusListener(this);
        emailField.addKeyListener(this);
        
        passwordField.addFocusListener(this);
        passwordField.addKeyListener(this);

        showPasswordCheckBox.addMouseListener(this);

        logInButton.addMouseListener(this);
        logInButton.addMouseMotionListener(this);

        forgetPasswordText.addMouseListener(this);
        forgetPasswordText.addMouseMotionListener(this);

        registerText.addMouseListener(this);
        registerText.addMouseMotionListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        source = e.getComponent();
        key = e.getKeyChar();
        if (key == KeyEvent.VK_ENTER)
                System.out.println("hi");
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

    @Override
    public void focusGained(FocusEvent e) {
        source = e.getComponent();
        if(source == emailField || source == passwordField)
        {
            source.setBackground(new Color(0, 191, 255));
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        source = e.getComponent();
        if(source == emailField)
        {
            if (emailField.isEmpty() || emailField.checkPlaceholder()) {
                emailField.setBackground(new Color(135, 206, 250));
                emailField.setPlaceholder();
            }
        }
        else if(source == passwordField)
        {
            if (passwordField.isEmpty() || passwordField.checkPlaceholder()) {
                passwordField.setEchoChar(Values.PASSWORD_PLAIN_ECHO_CHAR);
                passwordField.setBackground(new Color(135, 206, 250));
                passwordField.setText(Values.PASSWORD_PLACEHOLDER);
            }
        } 
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        source = e.getComponent();
        if(source == showPasswordCheckBox)
            showPassword();
        else if(source == logInButton)
        {
            //TODO fetch data and complete authentication 
        }
        else if(source == forgetPasswordText)
        {
            //TODO open recovering page
        }
        else if(source == registerText)
        {
            //TODO open register page
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        source = e.getComponent();
        if(source == forgetPasswordText)
        {
            //TODO set hovering effect
        }
        else if(source == registerText)
        {
            //TODO set hovering effect
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        source = e.getComponent();
        if(source == forgetPasswordText)
        {
            //TODO undo hovering effect
        }
        else if(source == forgetPasswordText)
        {
            //TODO undo hovering effect
        }
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

}