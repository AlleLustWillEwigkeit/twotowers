package allelustwillewigkeit.twotowers.graphical;

import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class GyozelemPanel extends JPanel {
	ActionListener controller;
	
	public GyozelemPanel(ActionListener controller) {
		this.controller = controller;
	}
}
