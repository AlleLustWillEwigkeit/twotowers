package allelustwillewigkeit.twotowers.graphical;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Controller implements ActionListener {
	View mainFrame;
	
	public static void main(String[] args) throws IOException {
		Controller c = new Controller();
	}
	
	Controller() {
		mainFrame = new View(this);
		mainFrame.setVisible(true);
		
		mainFrame.menuRajzol();
	}
	
	public void ujJatek() {
		
	}
	
	public void tick() {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
	}
}
