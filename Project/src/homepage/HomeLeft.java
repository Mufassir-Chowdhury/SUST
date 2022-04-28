package homepage;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;

class HomeLeft extends JPanel {

    private static final long serialVersionUID = 1L;

    
    public HomeLeft() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        // setAlignmentX(SwingConstants.CENTER);
        // setAlignmentY(SwingConstants.CENTER);
        setOpaque(false);
        add(new Logo());
        add(new Text());
    }


    private class Logo extends JLabel {
        public Logo(){
            setHorizontalAlignment(SwingConstants.CENTER);
            setSize(getHeight(), 290);
            ImageIcon sustImage = new ImageIcon(ClassLoader.getSystemResource("static/images/logo.png"));
            setIcon(sustImage);
            
        }
    }
    private class Text extends JPanel {
        public Text(){
            setOpaque(false);
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            setSize(getHeight(), getWidth());
            add(new AppName());
            add(new Slogan());
        }
    }
    private class AppName extends JLabel{
        public AppName(){
            setText("LoggedIn");
            setSize(getHeight(), 45);
            setFont(new Font("Verdana", Font.BOLD, 36));
            setHorizontalAlignment(SwingConstants.CENTER);
            setForeground(Color.decode("#D5AF36"));
        }
    }
    private class Slogan extends JLabel{
        public Slogan(){
            setText("Bringing Everything In One Place");
            setSize(getHeight(), 30);
            setFont(new Font("Times New Roman", Font.BOLD, 26));
            setHorizontalAlignment(SwingConstants.CENTER);
            setForeground(Color.decode("#C1C0C0"));
        }
    }
}