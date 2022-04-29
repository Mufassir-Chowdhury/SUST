package login;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Constants.Colors;

class LogInLeft extends JPanel {

    private static final long serialVersionUID = 1L;

    
    public LogInLeft() {
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
            setSize(156, 173);
            setMaximumSize(new Dimension(156, 173));
            ImageIcon sustImage = new ImageIcon(ClassLoader.getSystemResource("static/images/logo.png"));
            setIcon(sustImage);
            
        }
    }
    private class Text extends JPanel {
        public Text(){
            setOpaque(false);
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            add(new AppName());
            add(new Slogan());
        }
    }
    private class AppName extends JLabel{
        public AppName(){
            setText("SUST");
            setSize(getHeight(), 45);
            setFont(new Font("Segoe UI", Font.BOLD, 28));
            setHorizontalAlignment(SwingConstants.CENTER);
            setForeground(Colors.ACCENT);
        }
    }
    private class Slogan extends JLabel{
        public Slogan(){
            setText("Bringing Everything In One Place");
            setSize(getHeight(), 30);
            setFont(new Font("Segoe UI", Font.BOLD, 24));
            setHorizontalAlignment(SwingConstants.CENTER);
            setForeground(Color.decode("#C1C0C0"));
        }
    }
}