package allelustwillewigkeit.twotowers.graphical;

import java.awt.Dimension;

public class VarazskoButton extends JatekButton {
	public VarazskoButton(String name, int koltseg) {
		super(name,koltseg);
		this.setPreferredSize(new Dimension(48, 48));
	}
}
