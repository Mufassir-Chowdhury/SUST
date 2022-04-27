package Components;

import javax.swing.JPanel;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseListener;

public class TitleBar extends JPanel implements MouseMotionListener, MouseListener {
	public int x, y, xx, yy;
	public  Point point;
	public Dimension size;
	private static final long serialVersionUID = 1L;
	private Tools tools = new Tools();
	private String sourceWhiteCancelLogo = "static/images/cancel-white.png";
	private String sourceFullScreenLogo = "static/images/full-screen.png";
	private String sourceMinimizeLogo = "static/images/minimize.png";
	private String sourceWhiteRestoreLogo = "static/images/restore-white.png";
	private JLabel minimizeIcon, cancelIcon, fullScreenIcon;
	private ImageIcon cancelLogo, fullScreenLogo, minimizeLogo, restoreLogo;
	
	public TitleBar() {
		setBounds(0, 0, 1000, 25);
		setLayout(null);
		setOpaque(false);
		
		createIcons();
		
        cancelIcon = new JLabel(cancelLogo);
		cancelIcon.setBounds(975, 0, 25, 25);
		cancelIcon.addMouseListener(this);
		cancelIcon.addMouseMotionListener(this);
		add(cancelIcon);


        fullScreenIcon = new JLabel(fullScreenLogo);
		fullScreenIcon.setBounds(945, 0, 25, 25);
		fullScreenIcon.addMouseListener(this);
		fullScreenIcon.addMouseMotionListener(this);
		add(fullScreenIcon);

        
        minimizeIcon = new JLabel(minimizeLogo);
		minimizeIcon.setBounds(915, 0, 25, 25);
		minimizeIcon.addMouseListener(this);
		minimizeIcon.addMouseMotionListener(this);
		add(minimizeIcon);
	}
	
	private void createIcons()
	{
		cancelLogo 		= tools.imageScale(sourceWhiteCancelLogo, 15, 15);
		fullScreenLogo 	= tools.imageScale(sourceFullScreenLogo, 15, 15);
		minimizeLogo 	= tools.imageScale(sourceMinimizeLogo, 15, 15);
		restoreLogo 	= tools.imageScale(sourceWhiteRestoreLogo, 15, 15);
	}
	

	@Override
	public void mouseDragged(MouseEvent e) {
		if(e.getSource() == this) {
			xx = e.getXOnScreen();
			yy = e.getYOnScreen();
			point = new Point(xx - x, yy - y);
			setLocation(xx,yy);
			setLocation(0, 0);
		}
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		
	}

	@Override
	//https://javapointers.com/java/java-se/mouse-listener/
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == cancelIcon) {
			System.exit(0);
		}
		else if(e.getSource() == fullScreenIcon) {
			size = Toolkit.getDefaultToolkit().getScreenSize();
			if(fullScreenIcon.getIcon() == fullScreenLogo) {
				fullScreenIcon.setIcon(restoreLogo);
				//getRootPane().setSize(size);
				//make the frame full size
			}
			else
			{
				fullScreenIcon.setIcon(fullScreenLogo);
				//make the screen default size
			}
		}
		else if(e.getSource() == minimizeIcon) {
//			.setState(Frame.ICONIFIED);
			////set the state to ICONIFIED
		}
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
		if(e.getSource() == cancelIcon) {
			cancelIcon.setOpaque(true);
			cancelIcon.setBackground(Color.red);
		}
		else if(e.getSource() == fullScreenIcon) {
			fullScreenIcon.setOpaque(true);
			fullScreenIcon.setBackground(Color.gray);
		}
		else if(e.getSource() == minimizeIcon) {
			minimizeIcon.setOpaque(true);
			minimizeIcon.setBackground(Color.gray);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource() == cancelIcon) {
			cancelIcon.setOpaque(false);
			cancelIcon.setBackground(null);
		}
		else if(e.getSource() == fullScreenIcon) {
			fullScreenIcon.setOpaque(false);
			fullScreenIcon.setBackground(null);
		}
		else if(e.getSource() == minimizeIcon) {
			minimizeIcon.setOpaque(false);
			minimizeIcon.setBackground(null);
		}
	}
}
