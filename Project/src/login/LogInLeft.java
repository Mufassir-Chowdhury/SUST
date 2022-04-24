package login;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;


class LogInLeft extends JPanel {

    private static final long serialVersionUID = 1L;

    public LogInLeft() {
        setBackground(new Color(0, 0, 0));
        setLayout(null);
        
        JLabel logo = new JLabel("");
        logo.setHorizontalAlignment(SwingConstants.CENTER);
        logo.setBounds(0, 65, 494, 290);
        add(logo);
        ImageIcon sustImage = new ImageIcon(".\\Project\\src\\static\\images\\logo.png");
        logo.setIcon(sustImage);
        
        JLabel logInPageAppName = new JLabel("SUST APP");
        logInPageAppName.setBounds(0, 360, 494, 45);
        logInPageAppName.setFont(new Font("Verdana", Font.BOLD, 36));
        logInPageAppName.setHorizontalAlignment(SwingConstants.CENTER);
        logInPageAppName.setForeground(Color.decode("#D5AF36"));
        add(logInPageAppName);
        
        JLabel logInPageText = new JLabel("Bringing Everything In One Place");
        logInPageText.setBounds(0, 433, 494, 30);
        logInPageText.setFont(new Font("Times New Roman", Font.BOLD, 26));
        logInPageText.setHorizontalAlignment(SwingConstants.CENTER);
        logInPageText.setForeground(Color.decode("#C1C0C0"));
        add(logInPageText);
        

    }

}