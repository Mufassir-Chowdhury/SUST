package Components;

import javax.swing.JPanel;
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
import Constants.Icons;
import Constants.Padding;
import Constants.Sizes;


public class TitleBar extends JPanel implements MouseMotionListener, MouseListener {
	public int x, y, xx, yy;
	public  Point point;
	public Dimension size;
	private static final long serialVersionUID = 1L;
	private JLabel minimizeIcon, closeIcon, fullScreenIcon;
	private Background frame;
	public int width, height;

	public TitleBar(Background frame, int width) {
		this.frame = frame;
		setOpaque(false);
		setSize(width, Sizes.TITLE_BAR_HEIGHT);
		
        closeIcon = new JLabel(Icons.CLOSE);
		closeIcon.setSize(Sizes.ICON_SIZE);
		closeIcon.addMouseListener(this);
		closeIcon.addMouseMotionListener(this);
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.NORTH, closeIcon, 0, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, closeIcon, 0, SpringLayout.EAST, this);
		closeIcon.setBorder(Padding.TITLE_BAR_ITEM);
		setLayout(springLayout);
		add(closeIcon);


        fullScreenIcon = new JLabel(Icons.FULL_SCREEN);
        springLayout.putConstraint(SpringLayout.NORTH, fullScreenIcon, 0, SpringLayout.NORTH, this);
        springLayout.putConstraint(SpringLayout.EAST, fullScreenIcon, -5, SpringLayout.WEST, closeIcon);
		fullScreenIcon.setSize(Sizes.ICON_SIZE);
		fullScreenIcon.setBorder(Padding.TITLE_BAR_ITEM);
		fullScreenIcon.addMouseListener(this);
		fullScreenIcon.addMouseMotionListener(this);
		add(fullScreenIcon);

        
        minimizeIcon = new JLabel(Icons.MINIMIZE);
        springLayout.putConstraint(SpringLayout.NORTH, minimizeIcon, 0, SpringLayout.NORTH, this);
        springLayout.putConstraint(SpringLayout.EAST, minimizeIcon, -5, SpringLayout.WEST, fullScreenIcon);
		minimizeIcon.setSize(Sizes.ICON_SIZE);
		minimizeIcon.setBorder(Padding.TITLE_BAR_ITEM);
		minimizeIcon.addMouseListener(this);
		minimizeIcon.addMouseMotionListener(this);
		add(minimizeIcon);
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
		if(e.getSource() == closeIcon) {
			System.exit(0);
		}
		else if(e.getSource() == fullScreenIcon) {
			size = Toolkit.getDefaultToolkit().getScreenSize();
			if(fullScreenIcon.getIcon() == Icons.FULL_SCREEN) {
				frame.Extend();
				fullScreenIcon.setIcon(Icons.RESTORE);
			}
			else{
				fullScreenIcon.setIcon(Icons.FULL_SCREEN);
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
		if(e.getSource() == closeIcon) {
			closeIcon.setOpaque(true);
			closeIcon.setBackground(Colors.CLOSE_BUTTON_HOVER);
		}
		else if(e.getSource() == fullScreenIcon) {
			fullScreenIcon.setOpaque(true);
			fullScreenIcon.setBackground(Colors.STANDARD_BUTTON_HOVER);
		}
		else if(e.getSource() == minimizeIcon) {
			minimizeIcon.setOpaque(true);
			minimizeIcon.setBackground(Colors.STANDARD_BUTTON_HOVER);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource() == closeIcon) {
			closeIcon.setOpaque(false);
			closeIcon.setBackground(null);
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
