package allelustwillewigkeit.twotowers.graphical;

import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class JatekPanel extends JPanel {
	ActionListener controller;
	
	public JatekPanel(ActionListener controller) {
		this.controller = controller;
	}
}
