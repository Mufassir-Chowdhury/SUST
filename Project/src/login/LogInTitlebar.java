package login;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Image;
import java.awt.Color;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class LogInTitlebar extends JPanel {

	private static final long serialVersionUID = 1L;
	public ImageIcon makeLogo(Image image, int width, int height){
    	Image scaled = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    	return new ImageIcon(scaled);
    }
	
	public LogInTitlebar() {
		setBackground(new Color(0, 191, 255));
		setBounds(0, 0, 1000, 25);
		setLayout(null);
		
		
		ImageIcon cancelImage = new ImageIcon("F:\\Study\\CSE\\2-1\\Java\\Academic\\Project\\Project\\src\\start\\cancel.png");
        ImageIcon cancelLogo = makeLogo(cancelImage.getImage(), 15, 15);
		
        JLabel cancelIcon = new JLabel(cancelLogo);
        cancelIcon.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		System.exit(0);
        	}
        });
		cancelIcon.setBounds(975, 0, 25, 25);
		add(cancelIcon);
	}
}