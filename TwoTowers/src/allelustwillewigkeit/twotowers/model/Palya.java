package allelustwillewigkeit.twotowers.model;

import java.util.ArrayList;
import java.util.List;

public class Palya {
	protected List<PalyaElem> palyaElem = new ArrayList<PalyaElem>();

	/**
	 * A pálya konstruktora
	 */
	public Palya() {
	}

	public void tick() {
		for (PalyaElem p : this.palyaElem) {
			p.tick();
		}
	}

	/**
	 * void ujPalya Létrehoz egy pálya összeállítást.
	 */
	public void ujPalya() { // TODO
	}

	public void hozzaAdPalyahoz(PalyaElem _pe) {
		palyaElem.add(_pe);
	}

	public PalyaElem lekerPalyaElemIDvel(int _palyaElemID) {
		for (PalyaElem p : this.palyaElem) {
			if (p.lekerID() == _palyaElemID)
				return p;
		}
		return null;
	}
}
