package login;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import java.awt.BorderLayout;

class LogInComponentPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private JPanel logInRight = new LogInRight();
    private LogInLeft left = new LogInLeft();
    private JSplitPane logInSplitPane = new JSplitPane();

    public LogInComponentPanel() {
        setBounds(0, 25, 1000, 575);
        setLayout(new BorderLayout(0, 0));
        
        logInSplitPane.setOneTouchExpandable(false);
        logInSplitPane.setResizeWeight(0.5);
        logInSplitPane.setDividerSize(0);
        add(logInSplitPane, BorderLayout.CENTER);
        
        
        logInSplitPane.setLeftComponent(left);
        logInSplitPane.setRightComponent(logInRight);	
    }
}