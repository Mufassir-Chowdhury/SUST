package login;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;

class LogInLeft extends JPanel {

    private static final long serialVersionUID = 1L;

    
    public LogInLeft() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        add(new Logo());
        add(new AppName());
        add(new Slogan());
    }


    private class Logo extends JLabel {
        public Logo(){
            setHorizontalAlignment(SwingConstants.CENTER);
            setSize(getHeight(), 290);
            ImageIcon sustImage = new ImageIcon(ClassLoader.getSystemResource("static/images/logo.png"));
            setIcon(sustImage);
        }
    }
    private class AppName extends JLabel{
        public AppName(){
            setText("SUST APP");
            setSize(getHeight(), 45);
            setFont(new Font("Verdana", Font.BOLD, 36));
            setHorizontalAlignment(SwingConstants.CENTER);
            setForeground(Color.decode("#D5AF36"));
        }
    }
    private class Slogan extends JLabel{
        public Slogan(){
            setText("Bringing Everything In One PlaSe");
            setSize(getHeight(), 30);
            setFont(new Font("Times New Roman", Font.BOLD, 26));
            setHorizontalAlignment(SwingConstants.CENTER);
            setForeground(Color.decode("#C1C0C0"));
        }
    }
}