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
import java.awt.Component;


public class TitleBar extends JPanel implements MouseMotionListener, MouseListener {
	public int x, y, xx, yy;
	public  Point point;
	public Dimension size;
	private static final long serialVersionUID = 1L;
	private JLabel minimizeIcon, closeIcon, fullScreenIcon;
	private Background frame;
	public int width, height;
	public Component source;
	SpringLayout springLayout = new SpringLayout();

	public TitleBar(Background frame, int width) {
		this.frame = frame;
		setOpaque(false);
		setSize(width, Sizes.TITLE_BAR_HEIGHT);
		setLayout(springLayout);

		closeIcon = new JLabel(Icons.CLOSE);
		closeIcon.setSize(Sizes.ICON_SIZE);
		springLayout.putConstraint(SpringLayout.NORTH, closeIcon, 0, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, closeIcon, 0, SpringLayout.EAST, this);
		closeIcon.setBorder(Padding.TITLE_BAR_ITEM);
		add(closeIcon);

		fullScreenIcon = new JLabel(Icons.FULL_SCREEN);
		fullScreenIcon.setSize(Sizes.ICON_SIZE);
		springLayout.putConstraint(SpringLayout.NORTH, fullScreenIcon, 0, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, fullScreenIcon, -5, SpringLayout.WEST, closeIcon);
		fullScreenIcon.setBorder(Padding.TITLE_BAR_ITEM);
		add(fullScreenIcon);

		minimizeIcon = new JLabel(Icons.MINIMIZE);
		springLayout.putConstraint(SpringLayout.NORTH, minimizeIcon, 0, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, minimizeIcon, -5, SpringLayout.WEST, fullScreenIcon);
		minimizeIcon.setSize(Sizes.ICON_SIZE);
		minimizeIcon.setBorder(Padding.TITLE_BAR_ITEM);
		add(minimizeIcon);

		addListeners();
	}
	
	private void addListeners()
	{
		closeIcon.addMouseListener(this);
		closeIcon.addMouseMotionListener(this);

		fullScreenIcon.addMouseListener(this);
		fullScreenIcon.addMouseMotionListener(this);

		minimizeIcon.addMouseListener(this);
		minimizeIcon.addMouseMotionListener(this);
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
		source = e.getComponent();
		if(source == closeIcon) {
			closeIcon.setOpaque(true);
			closeIcon.setBackground(Colors.CLOSE_BUTTON_HOVER);
		}
		else if(source == fullScreenIcon) {
			fullScreenIcon.setOpaque(true);
			fullScreenIcon.setBackground(Colors.STANDARD_BUTTON_HOVER);
		}
		else if(source == minimizeIcon) {
			minimizeIcon.setOpaque(true);
			minimizeIcon.setBackground(Colors.STANDARD_BUTTON_HOVER);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		source = e.getComponent();
		if(source == closeIcon) {
			closeIcon.setOpaque(false);
			closeIcon.setBackground(null);
		}
		else if(source == fullScreenIcon) {
			fullScreenIcon.setOpaque(false);
			fullScreenIcon.setBackground(null);
		}
		else if(source == minimizeIcon) {
			minimizeIcon.setOpaque(false);
			minimizeIcon.setBackground(null);
		}
	}
}
