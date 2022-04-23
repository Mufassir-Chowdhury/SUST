import javax.swing.SwingUtilities;

import login.LogInPage;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new LogInPage().setVisible(true);
			}
		});
	}

}
