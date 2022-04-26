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
        
        add(new Logo());
        add(new AppName());
        add(new Slogan());
    }


    private class Logo extends JLabel {
        public Logo(){
            // JLabel logo = new JLabel("");
            setHorizontalAlignment(SwingConstants.CENTER);
            setBounds(0, 65, 494, 290);
            ImageIcon sustImage = new ImageIcon(ClassLoader.getSystemResource("static/images/logo.png"));
            setIcon(sustImage);
        }
    }
    private class AppName extends JLabel{
        public AppName(){
            // JLabel logInPageAppName = new JLabel("SUST APPa");
            setText("SUST APP");
            setBounds(0, 360, 494, 45);
            setFont(new Font("Verdana", Font.BOLD, 36));
            setHorizontalAlignment(SwingConstants.CENTER);
            setForeground(Color.decode("#D5AF36"));
        }
    }
    private class Slogan extends JLabel{
        public Slogan(){
            setText("Bringing Everything In One PlaSe");
            setBounds(0, 433, 494, 30);
            setFont(new Font("Times New Roman", Font.BOLD, 26));
            setHorizontalAlignment(SwingConstants.CENTER);
            setForeground(Color.decode("#C1C0C0"));
        }
    }
}