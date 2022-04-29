package Components;

import javax.swing.JPanel;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseListener;
import javax.swing.SpringLayout;

import Constants.Colors;
import Constants.Padding;


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
	private Background frame;
	public int width, height;

	public TitleBar(Background frame, int width) {
		this.frame = frame;
		setOpaque(false);
		setSize(width, 35);
		createIcons();
		
        cancelIcon = new JLabel(cancelLogo);
		cancelIcon.setSize(15, 15);
		cancelIcon.addMouseListener(this);
		cancelIcon.addMouseMotionListener(this);
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.NORTH, cancelIcon, 0, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, cancelIcon, 0, SpringLayout.EAST, this);
		cancelIcon.setBorder(Padding.titleBarItem);
		setLayout(springLayout);
		add(cancelIcon);


        fullScreenIcon = new JLabel(fullScreenLogo);
        springLayout.putConstraint(SpringLayout.NORTH, fullScreenIcon, 0, SpringLayout.NORTH, this);
        springLayout.putConstraint(SpringLayout.EAST, fullScreenIcon, -5, SpringLayout.WEST, cancelIcon);
		fullScreenIcon.setSize(15, 15);
		fullScreenIcon.setBorder(Padding.titleBarItem);
		fullScreenIcon.addMouseListener(this);
		fullScreenIcon.addMouseMotionListener(this);
		add(fullScreenIcon);

        
        minimizeIcon = new JLabel(minimizeLogo);
        springLayout.putConstraint(SpringLayout.NORTH, minimizeIcon, 0, SpringLayout.NORTH, this);
        springLayout.putConstraint(SpringLayout.EAST, minimizeIcon, -5, SpringLayout.WEST, fullScreenIcon);
		minimizeIcon.setSize(15, 15);
		minimizeIcon.setBorder(Padding.titleBarItem);
		minimizeIcon.addMouseListener(this);
		minimizeIcon.addMouseMotionListener(this);
		add(minimizeIcon);
	}
	
	private void createIcons(){
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
				frame.Extend();
				fullScreenIcon.setIcon(restoreLogo);
			}
			else{
				fullScreenIcon.setIcon(fullScreenLogo);
				frame.Normal();
			}
		}
		else if(e.getSource() == minimizeIcon) {
			frame.setState(Frame.ICONIFIED);
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
			cancelIcon.setBackground(Colors.closeButtonHover);
		}
		else if(e.getSource() == fullScreenIcon) {
			fullScreenIcon.setOpaque(true);
			fullScreenIcon.setBackground(Colors.standardButtonHover);
		}
		else if(e.getSource() == minimizeIcon) {
			minimizeIcon.setOpaque(true);
			minimizeIcon.setBackground(Colors.standardButtonHover);
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
