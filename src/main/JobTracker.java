package main;

import java.awt.EventQueue;

import javax.swing.JFrame;


public class JobTracker {

	private JFrame jobTrackerFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JobTracker window = new JobTracker();
					window.jobTrackerFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JobTracker() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		jobTrackerFrame = new JFrame("JobTracker");
		jobTrackerFrame.setBounds(100, 100, 450, 300);
		jobTrackerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jobTrackerFrame.getContentPane().setLayout(null);
	}
	public void setVisible(boolean b) {
		this.jobTrackerFrame.setVisible(b);
		
}
}

	
