package login;
import javax.swing.JPanel;
import java.awt.GridLayout;

class LogInComponentPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private JPanel logInRight = new LogInRight();
    private LogInLeft left = new LogInLeft();

    public LogInComponentPanel() {
        setBounds(0, 25, 1000, 575);
        setLayout(new GridLayout(0, 2));
        setOpaque(false);
        
        add(left);
        add(logInRight);	
    }
}