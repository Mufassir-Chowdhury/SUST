package Components;

import javax.swing.JPanel;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Image;
import java.awt.Point;
import java.awt.Color;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseListener;

public class TitleBar extends JPanel implements MouseMotionListener, MouseListener {
	public int x, y, xx, yy;
	public  Point point;
	private static final long serialVersionUID = 1L;
	public ImageIcon makeLogo(Image image, int width, int height){
    	Image scaled = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    	return new ImageIcon(scaled);
    }
	
	public TitleBar() {
		// setBackground(new Color(0, 191, 255));
		setBounds(0, 0, 1000, 25);
		setLayout(null);
		setOpaque(true);
		
		
		ImageIcon cancelImage = new ImageIcon(ClassLoader.getSystemResource("static/images/cancel.png"));
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
	
	

	@Override
	public void mouseDragged(MouseEvent e) {
		xx = e.getXOnScreen();
		yy = e.getYOnScreen();
		point = new Point(xx - x, yy - y);
		setLocation(xx,yy);
		setLocation(0, 0);
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		x = e.getX();
		y = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
}
