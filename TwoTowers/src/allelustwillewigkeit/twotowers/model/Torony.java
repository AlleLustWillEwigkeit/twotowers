package allelustwillewigkeit.twotowers.model;

import java.util.ArrayList;
import java.util.List;

public class Torony {
	protected List<Varazsko> kovek = new ArrayList<Varazsko>();
	public int alapHatotav;
	protected EpitesiTerulet minAll = null;
	protected List<Ut> kikhezRegisztraltamFel = new ArrayList<Ut>();

	/**
	 * A torony konstruktora
	 */
	public Torony() {
		alapHatotav = 5;
		beRegisztralTavonBeluliUtakhoz(this, alapHatotav);
	}

	/**
	 * void tuzel Minden varászkövének szól, hogy tüzeljen a célpontra
	 * 
	 * @param Ellenseg
	 *            celpont
	 */
	public void tuzel(Ellenseg celpont) {
		for (Varazsko v : this.kovek) {
			v.tuzel(celpont);
		}
	}

	/**
	 * void beRegisztralTavonBeluliUtakhoz Szól az őt tároló pályaelemnek, hogy
	 * beregisztrálna az utakhoz, a megfelelő hatótávon.
	 */
	public void beRegisztralTavonBeluliUtakhoz(Torony t, int tavolsag) {// TODO
		// PalyaElem pe = minAll.minAll();
		// if (pe.beregisztralt || tavolsag == 0)
		// return;
		// for (Varazsko v : kovek) {
		// tavolsag *= v.lekerHatotavSzorzo();
		// }
		// pe.beregisztral(this, tavolsag--);
	}

	/**
	 * void felkovez Ha még nincs rajta a paraméterül kapott varászkő, akkor
	 * felkövezi vele
	 * 
	 * @param Varazsko
	 *            mivel
	 */
	public void felkovez(Varazsko mivel) {
		if (!this.kovek.contains(mivel))
			this.kovek.add(mivel);
	}

	public void kiregisztral() {// TODO

	}
}
