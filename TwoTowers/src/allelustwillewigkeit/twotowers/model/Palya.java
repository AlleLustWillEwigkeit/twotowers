package allelustwillewigkeit.twotowers.model;

import java.util.ArrayList;
import java.util.List;

public class Palya {
	public List<PalyaElem> palyaElem = new ArrayList<PalyaElem>();

	/**
	 * A pálya konstruktora
	 */
	public Palya() {
	}
	
	public void tick(){
		for(PalyaElem p : this.palyaElem){
			p.tick();
		}
	}

	/**
	 * void ujPalya Létrehoz egy pálya összeállítást.
	 */
	public void ujPalya() { // TODO
	}
}
