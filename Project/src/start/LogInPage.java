package start;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.font.TextAttribute;
import java.awt.geom.RoundRectangle2D;
import java.util.Map;

class LogInTitlebar extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 * 
	 */
	public ImageIcon makeLogo(Image image, int width, int height)
    {
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
		
//		ImageIcon sustImage = new ImageIcon("F:\\Study\\CSE\\2-1\\Java\\Academic\\Project\\Project\\src\\start\\logo.png");
//		ImageIcon sustLogo = logoMaker.makeLogo(sustImage.getImage(), 25, 25);
//		JLabel titleLogo = new JLabel();
//		titleLogo.setIcon(sustLogo);
//		titleLogo.setBounds(5, 0, 25, 25);
//		add(titleLogo);
	}
}

	class LogInLeft extends JPanel {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		/**
		 * Create the panel.
		 */
		public LogInLeft() {
			setBackground(new Color(0, 0, 0));
			setLayout(null);
			
			JLabel logo = new JLabel("");
			logo.setHorizontalAlignment(SwingConstants.CENTER);
			logo.setBounds(0, 65, 494, 290);
			add(logo);
			ImageIcon sustImage = new ImageIcon("F:\\Study\\CSE\\2-1\\Java\\Academic\\Project\\Project\\src\\start\\logo.png");
			logo.setIcon(sustImage);
			
			JLabel logInPageAppName = new JLabel("SUST APP");
			logInPageAppName.setBounds(0, 360, 494, 45);
			logInPageAppName.setFont(new Font("Verdana", Font.BOLD, 36));
			logInPageAppName.setHorizontalAlignment(SwingConstants.CENTER);
			logInPageAppName.setForeground(Color.decode("#D5AF36"));
			add(logInPageAppName);
			
			JLabel logInPageText = new JLabel("Bringing Everything In One Place");
			logInPageText.setBounds(0, 433, 494, 30);
			logInPageText.setFont(new Font("Times New Roman", Font.BOLD, 26));
			logInPageText.setHorizontalAlignment(SwingConstants.CENTER);
			logInPageText.setForeground(Color.decode("#C1C0C0"));
			add(logInPageText);
			

		}

	}

	class RoundJTextField extends JTextField {
	    /**
		 * 
		 */
		private Shape shape;
		private int size;
	    public RoundJTextField(int size) {
	    	super(size);
	    	this.size = size;
	        setOpaque(false); // As suggested by @AVD in comment.
	    }
	    protected void paintComponent(Graphics g) {
	         g.setColor(getBackground());
	         g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, size, size);
	         super.paintComponent(g);
	    }
	    protected void paintBorder(Graphics g) {
	         g.setColor(getForeground());
	         g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, size, size);
	    }
	    public boolean contains(int x, int y) {
	         if (shape == null || !shape.getBounds().equals(getBounds())) {
	             shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, size, size);
	         }
	         return shape.contains(x, y);
	    }
	}


	@SuppressWarnings("serial")
	class RoundJPasswordField extends JPasswordField {
	    /**
		 * 
		 */
//		private static final long serialVersionUID = 1L;
		private Shape shape;
		private int size;
	    public RoundJPasswordField(int size) {
	    	super(size);
	    	this.size = size;
	        setOpaque(false); // As suggested by @AVD in comment.
	    }
	    protected void paintComponent(Graphics g) {
	         g.setColor(getBackground());
	         g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, size, size);
	         super.paintComponent(g);
	    }
	    protected void paintBorder(Graphics g) {
	         g.setColor(getForeground());
	         g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, size, size);
	    }
	    public boolean contains(int x, int y) {
	         if (shape == null || !shape.getBounds().equals(getBounds())) {
	             shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, size, size);
	         }
	         return shape.contains(x, y);
	    }
	}

	class RoundJButton extends JButton {
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Shape shape;
		private int size;
	    public RoundJButton(int size) {
	    	super();
	    	this.size = size;
	        setOpaque(false); // As suggested by @AVD in comment.
	    }
	    protected void paintComponent(Graphics g) {
	         g.setColor(getBackground());
	         g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, size, size);
	         super.paintComponent(g);
	    }
	    protected void paintBorder(Graphics g) {
	         g.setColor(getForeground());
	         g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, size, size);
	    }
	    public boolean contains(int x, int y) {
	         if (shape == null || !shape.getBounds().equals(getBounds())) {
	             shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, size, size);
	         }
	         return shape.contains(x, y);
	    }
	}

	class LogInRight extends JPanel {

		
		private String emailPlaceholder = " Email address";
		private String passwordPlaceholder = " Password"; 
		RoundJTextField emailField;
		RoundJPasswordField passwordField;
		JCheckBox showPasswordCheckBox;
		RoundJButton logInButton;
		JLabel forgetPasswordText, registerText;
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		/**
		 * Create the panel.
		 */
		
		
		
		public LogInRight() {
			setBackground(new Color(0, 0, 0));
			setLayout(null);

			emailField = new RoundJTextField(20);
			passwordField = new RoundJPasswordField(20);
			showPasswordCheckBox = new JCheckBox();
			logInButton = new RoundJButton(20);
			forgetPasswordText = new JLabel();
			registerText = new JLabel();
			
			
			emailField.setBounds(40, 160, 340, 40);
			emailField.setBackground(new Color(135, 206, 250));
			emailField.setForeground(Color.black);
			emailField.setFont(new Font("Segoe UI", Font.ITALIC, 16));
			emailField.setMargin(new Insets(2, 10, 2, 2));
			emailField.setText(emailPlaceholder);
			emailField.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					if(emailField.getText().equals(emailPlaceholder))
						emailField.setText("");
				}
			});
			emailField.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					emailField.setBackground(new Color(0, 191, 255));
				}
				@Override
				public void focusLost(FocusEvent e) {
					if(emailField.getText().isEmpty() || emailField.getText().equals(emailPlaceholder)) {
						emailField.setBackground(new Color(135, 206, 250));
						emailField.setText(emailPlaceholder);
					}
				}
			});
			add(emailField);
			
			
			
			passwordField.setBounds(40, 250, 340, 40);
			passwordField.setBackground(new Color(135, 206, 250));
			passwordField.setForeground(Color.black);
			passwordField.setFont(new Font("Segoe UI", Font.ITALIC, 16));
			passwordField.setMargin(new Insets(2, 10, 2, 2));
			passwordField.setText(passwordPlaceholder);
			passwordField.setEchoChar('\u0000');
			passwordField.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					if(passwordField.getText().equals(passwordPlaceholder))
					{
						passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
						if(showPasswordCheckBox.isSelected()==false) passwordField.setEchoChar('\u25cf');
						passwordField.setText("");
					}
				}
			});
			passwordField.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					if(passwordField.getText().equals(passwordPlaceholder))
					{
						passwordField.setBackground(new Color(0, 191, 255));
					}
				}
				@Override
				public void focusLost(FocusEvent e) {
					if(passwordField.getText().isEmpty() || passwordField.getText().equals(passwordPlaceholder)) {
						passwordField.setEchoChar('\u0000');
						passwordField.setBackground(new Color(135, 206, 250));
						passwordField.setFont(new Font("Segoe UI", Font.ITALIC, 16));
						passwordField.setText(passwordPlaceholder);
					}
				}
			});
			add(passwordField);
			
			
			showPasswordCheckBox.setBounds(270, 295, 110, 23);
			showPasswordCheckBox.setFocusPainted(false);
			showPasswordCheckBox.setBackground(new Color(0,0,0));
			showPasswordCheckBox.setForeground(new Color(135, 206, 250));
			showPasswordCheckBox.setBorder(null);
			showPasswordCheckBox.setText("Show Password");
			showPasswordCheckBox.setContentAreaFilled(false);
			showPasswordCheckBox.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(showPasswordCheckBox.isSelected())
					{
						passwordField.setEchoChar('\u0000');
						showPasswordCheckBox.setForeground(new Color(0, 191, 255));
					}
					if(showPasswordCheckBox.isSelected()==false)
					{
						showPasswordCheckBox.setForeground(new Color(135, 206, 250));
						if(passwordField.getText().equals(passwordPlaceholder)==false)
							passwordField.setEchoChar('\u25cf');
					}
				}
			});
			add(showPasswordCheckBox);
			
			
			
			logInButton.setText("Log  In");
			logInButton.setBounds(40, 340, 340, 40);
			logInButton.setContentAreaFilled(false);
			logInButton.setFocusPainted(false);
			logInButton.setFont(new Font("MS UI Gothic", Font.BOLD, 23));
			logInButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			logInButton.setForeground(new Color(135, 206, 250));
			logInButton.setBackground(new Color(0, 0, 0));
			logInButton.setBorder(null);
			logInButton.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					logInButton.setForeground(new Color(30, 144, 255));
				}
				@Override
				public void focusLost(FocusEvent e) {
					logInButton.setForeground(new Color(135, 206, 250));
				}
			});
			logInButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					logInButton.setForeground(new Color(30, 144, 255));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					if(logInButton.isFocusOwner()) return;
					logInButton.setForeground(new Color(135, 206, 250));
				}
			});
			add(logInButton);
			
			forgetPasswordText.setText("Forgotten Password?");
			forgetPasswordText.setHorizontalAlignment(SwingConstants.RIGHT);
			forgetPasswordText.setBounds(105, 396, 140, 25);
			forgetPasswordText.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			forgetPasswordText.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			forgetPasswordText.setForeground(new Color(30, 144, 255));
			forgetPasswordText.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					Font font = forgetPasswordText.getFont();
					Map adding = font.getAttributes();
					adding.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
					forgetPasswordText.setFont(font.deriveFont(adding));
					
				}
				@Override
				public void mouseExited(MouseEvent e) {
					forgetPasswordText.setFont(new Font("Segoe UI", Font.PLAIN, 15));
				}
			});
			add(forgetPasswordText);
			
			registerText.setText("Register");
			registerText.setHorizontalAlignment(SwingConstants.LEFT);
			registerText.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			registerText.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			registerText.setBounds(255, 396, 60, 25);
			registerText.setForeground(new Color(30, 144, 255));
			registerText.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					Font font = registerText.getFont();
					Map adding = font.getAttributes();
					adding.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
					registerText.setFont(font.deriveFont(adding));
					
				}
				@Override
				public void mouseExited(MouseEvent e) {
					registerText.setFont(new Font("Segoe UI", Font.PLAIN, 15));
				}
			});
			add(registerText);


		}

	}

	 class LogInComponentPanel extends JPanel {
		
		private static final long serialVersionUID = 1L;

		public LogInComponentPanel() {
			setBounds(0, 25, 1000, 575);
			setLayout(new BorderLayout(0, 0));
			
			JSplitPane logInSplitPane = new JSplitPane();
			logInSplitPane.setOneTouchExpandable(false);
			logInSplitPane.setResizeWeight(0.5);
			logInSplitPane.setDividerSize(0);
			add(logInSplitPane, BorderLayout.CENTER);
			
			LogInLeft left = new LogInLeft();

			logInSplitPane.setLeftComponent(left);
			logInSplitPane.setRightComponent(new LogInRight());	
		}

	}

 class LogInPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel logInPageMainPanel;
	private LogInTitlebar logInTitlebar;
	private int x,y;

	/**
	 * Create the frame
	 */
	@SuppressWarnings("unused")
	public LogInPage() {
		setBounds(new Rectangle(170, 70, 1000, 600));
		setUndecorated(true);
		
		logInPageMainPanel = new JPanel();
		logInPageMainPanel.setBounds(0, 0, 1000, 600);
		logInPageMainPanel.setLayout(null);
		setContentPane(logInPageMainPanel);
		
		logInTitlebar = new LogInTitlebar();
		logInTitlebar.setBounds(0, 0, 1000, 25);
		logInTitlebar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int xx = e.getXOnScreen();
				int yy = e.getYOnScreen();
				setLocation(xx-x,yy-y);
			}
		});
		logInTitlebar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x = e.getX();
				y = e.getY();
			}
		});
		logInPageMainPanel.add(logInTitlebar);
		
		logInPageMainPanel.add(new LogInComponentPanel());
	
	}
	public class Main {

		public static void main(String[] args) {
			new LogInPage().setVisible(true);

		}

	}
}
