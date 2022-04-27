package login;
import javax.swing.JPanel;
import java.awt.GridLayout;

class LogInComponentPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private JPanel logInRight = new LogInRight();
    private LogInLeft left = new LogInLeft();
    // private JSplitPane logInSplitPane = new JSplitPane();

    public LogInComponentPanel() {
        setBounds(0, 25, 1000, 575);
        setLayout(new GridLayout(0, 2));
        setOpaque(false);
        // setBackground(new Color(0,0,0));
        // logInSplitPane.setOneTouchExpandable(false);
        // logInSplitPane.setResizeWeight(0.5);
        // logInSplitPane.setDividerSize(0);
        // add(logInSplitPane);
        
        add(left);
        add(logInRight);
        // logInSplitPane.setLeftComponent(left);
        // logInSplitPane.setRightComponent(logInRight);	
    }
}