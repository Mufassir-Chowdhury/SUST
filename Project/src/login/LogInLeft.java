package login;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Constants.Colors;
import Constants.Fonts;
import Constants.Icons;
import Constants.Sizes;

class LogInLeft extends JPanel {

    private static final long serialVersionUID = 1L;

    
    public LogInLeft() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setOpaque(false);
        
        add(Box.createHorizontalGlue());
        add(new Logo());
        add(Box.createHorizontalGlue());
        add(new Text());
        add(Box.createHorizontalGlue());
    }


    private class Logo extends JLabel {
        public Logo(){
            setHorizontalAlignment(SwingConstants.CENTER);
            setSize(Sizes.LOGO_SIZE);
            setMaximumSize(Sizes.LOGO_SIZE);
            setIcon(Icons.SUST_LOGO);
            
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
            setFont(Fonts.DISPLAY);
            setForeground(Colors.ACCENT);
        }
    }
    private class Slogan extends JLabel{
        public Slogan(){
            setText("Bringing Everything In One Place");
            setFont(Fonts.SUBTITLE);
            setForeground(Colors.PLAIN_TEXT);
        }
    }
}