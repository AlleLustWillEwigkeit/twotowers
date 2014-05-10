package allelustwillewigkeit.twotowers.graphical;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class View extends JFrame {
	ActionListener controller = null;
	JPanel jelenlegiPanel = null;
	
	View(ActionListener controller) {
		super("Two Towers");
		
		this.controller = controller;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	}
	
	public void feluletEpit() {
		this.setContentPane(jelenlegiPanel);
		this.pack();
		this.setSize(928, 700);
	}
	
	public void menuRajzol() {
		jelenlegiPanel = new MenuPanel(controller);
		feluletEpit();
	}
	
	
	protected void jatekRajzol() {
		jelenlegiPanel = new JatekPanel(controller);
		feluletEpit();
	}
	
	public void gyozelemRajz() {
		jelenlegiPanel = new GyozelemPanel(controller);
		feluletEpit();
	}
	
	public void veresegRajz() {
		jelenlegiPanel = new VeresegPanel(controller);
		feluletEpit();
	}
	
	public void tickTortent() {
		
	}
	
	public void kilep() {
		this.setVisible(false);
	    this.dispose();
	}
}
