package allelustwillewigkeit.twotowers.model;

import java.util.ArrayList;
import java.util.List;

public class Palya {
	protected List<PalyaElem> palya = new ArrayList<PalyaElem>();

	/**
	 * A palya konstruktora
	 */
	public Palya() {
	}

	public void tick() {
		for (PalyaElem p : this.palya) {
			p.tick();
		}
	}

	/**
	 * void ujPalya Letrehoz egy palya osszeallitast.
	 */
	public void ujPalya() { // TODO
	}

	public void hozzaAdPalyahoz(PalyaElem _pe) {
		palya.add(_pe);
	}

	public PalyaElem lekerPalyaElemIDvel(int _palyaElemID) {
		for (PalyaElem p : this.palya) {
			if (p.lekerID() == _palyaElemID)
				return p;
		}
		return null;
	}

	public List<PalyaElem> lekerlista() {
		return palya;
	}
}
