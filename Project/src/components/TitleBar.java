package Components;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import javax.swing.SpringLayout;

import Common.Main.Main;
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
	public static JLabel backIcon = new JLabel();
	private Background frame;
	public int width, height;
	public Component source;
	SpringLayout springLayout = new SpringLayout();

	public TitleBar(Background frame, int width) {
		this.frame = frame;
		setSize(width, Sizes.TITLE_BAR_HEIGHT);
		decorateTitleBar();
	}

	public TitleBar(Background frame, int width, JFrame s) {
		this.frame = frame;
		setSize(width, Sizes.TITLE_BAR_HEIGHT);

		setOpaque(false);
		setLayout(springLayout);

		closeIcon = new JLabel(Icons.TitleBar.CLOSE);
		springLayout.putConstraint(SpringLayout.NORTH, closeIcon, 2, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, closeIcon, -4, SpringLayout.EAST, this);
		closeIcon.setBorder(Padding.TITLE_BAR_ITEM);
		add(closeIcon);

		closeIcon.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}

			public void mouseEntered(MouseEvent e) {
				closeIcon.setOpaque(true);
				closeIcon.setBackground(Colors.Button.CLOSE_BUTTON_HOVER);
			}

			public void mouseExited(MouseEvent e) {
				closeIcon.setOpaque(false);
				closeIcon.setBackground(null);
			}
		});
		

		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	public TitleBar(Background frame, int width, String s) {
		this.frame = frame;
		setSize(width, Sizes.TITLE_BAR_HEIGHT);
		decorateTitleBar();
		add(backIcon);
	}

	private void decorateTitleBar()
	{
		setOpaque(false);
		setLayout(springLayout);

		closeIcon = new JLabel(Icons.TitleBar.CLOSE);
		springLayout.putConstraint(SpringLayout.NORTH, closeIcon, 0, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, closeIcon, 0, SpringLayout.EAST, this);
		closeIcon.setBorder(Padding.TITLE_BAR_ITEM);
		add(closeIcon);

		fullScreenIcon = new JLabel(Icons.TitleBar.RESTORE);
		springLayout.putConstraint(SpringLayout.NORTH, fullScreenIcon, 0, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, fullScreenIcon, -5, SpringLayout.WEST, closeIcon);
		fullScreenIcon.setBorder(Padding.TITLE_BAR_ITEM);
		add(fullScreenIcon);

		minimizeIcon = new JLabel(Icons.TitleBar.MINIMIZE);
		springLayout.putConstraint(SpringLayout.NORTH, minimizeIcon, 0, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, minimizeIcon, -5, SpringLayout.WEST, fullScreenIcon);
		minimizeIcon.setBorder(Padding.TITLE_BAR_ITEM);
		add(minimizeIcon);

		backIcon = new JLabel(Icons.TitleBar.BACK_COLORED);
		springLayout.putConstraint(SpringLayout.NORTH, backIcon, 0, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, backIcon, 0, SpringLayout.WEST, this);
		backIcon.setBorder(Padding.TITLE_BAR_ITEM);
		
		backIcon.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				Main.getInstance().changeFrame("mainPage");
			}
		});
		add(backIcon);

		addListeners();
	}
	
	private void addListeners(){
		closeIcon.addMouseListener(this);
		closeIcon.addMouseMotionListener(this);

		fullScreenIcon.addMouseListener(this);
		fullScreenIcon.addMouseMotionListener(this);

		minimizeIcon.addMouseListener(this);
		minimizeIcon.addMouseMotionListener(this);

		backIcon.addMouseListener(this);
		backIcon.addMouseMotionListener(this);

		addMouseListener(this);
		addMouseMotionListener(this);
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
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == closeIcon) {
			System.exit(0);
		}
		else if(e.getSource() == fullScreenIcon) {
			size = Toolkit.getDefaultToolkit().getScreenSize();
			if(fullScreenIcon.getIcon() == Icons.TitleBar.FULL_SCREEN) {
				frame.Extend();
				fullScreenIcon.setIcon(Icons.TitleBar.RESTORE);
			}
			else{
				fullScreenIcon.setIcon(Icons.TitleBar.FULL_SCREEN);
				frame.Normal();
			}
		}
		else if (e.getSource() == minimizeIcon) {
			frame.setState(Frame.ICONIFIED);
		}
		else if (e.getSource() == backIcon) {
			//TODO code goes here
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
			closeIcon.setBackground(Colors.Button.CLOSE_BUTTON_HOVER);
		}
		else if(source == fullScreenIcon) {
			fullScreenIcon.setOpaque(true);
			fullScreenIcon.setBackground(Colors.Button.TITLE_BAR_BUTTON_HOVER);
		}
		else if (source == minimizeIcon) {
			minimizeIcon.setOpaque(true);
			minimizeIcon.setBackground(Colors.Button.TITLE_BAR_BUTTON_HOVER);
		}
		else if (source == backIcon) {
			backIcon.setOpaque(true);
			backIcon.setBackground(Colors.Button.TITLE_BAR_BUTTON_HOVER);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		source = e.getComponent();
		if (source == closeIcon) {
			closeIcon.setOpaque(false);
			closeIcon.setBackground(null);
		} else if (source == fullScreenIcon) {
			fullScreenIcon.setOpaque(false);
			fullScreenIcon.setBackground(null);
		} else if (source == minimizeIcon) {
			minimizeIcon.setOpaque(false);
			minimizeIcon.setBackground(null);
		} else if (source == backIcon) {
			backIcon.setOpaque(false);
			backIcon.setBackground(null);
		}
	}
	
	public static final void setBackIcon()
	{
		backIcon = new JLabel(Icons.TitleBar.BACK_COLORED);
	}
}
