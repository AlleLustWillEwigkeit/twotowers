package allelustwillewigkeit.twotowers.graphical;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class View extends JFrame {
	Controller controller = null;
	JPanel jelenlegiPanel = null;
	boolean isPlaying;
	
	View(Controller controller) {
		super("Two Towers");
		
		this.controller = controller;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.isPlaying = false;
	}
	
	public void feluletEpit() {
		this.setContentPane(jelenlegiPanel);
		this.pack();
		this.setSize(928, 700);
	}
	
	public void menuRajzol() {
		jelenlegiPanel = new MenuPanel(controller);
		feluletEpit();
		this.isPlaying = false;
	}
	
	
	protected void jatekRajzol() {
		jelenlegiPanel = new JatekPanel(controller);
		feluletEpit();
		this.isPlaying = true;
	}
	
	public void gyozelemRajz() {
		jelenlegiPanel = new GyozelemPanel(controller);
		feluletEpit();
		this.isPlaying = false;
	}
	
	public void veresegRajz() {
		jelenlegiPanel = new VeresegPanel(controller);
		feluletEpit();
		this.isPlaying = false;
	}
	
	public void tickTortent() {
		
	}
	
	public void kilep() {
		this.setVisible(false);
	    this.dispose();
	}
}
