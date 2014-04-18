package allelustwillewigkeit.twotowers.model;

import java.util.ArrayList;
import java.util.List;

public class Akadaly {
	protected int eletero = 0; //TODO Ez tutira rossz, sehol sincs használva
	protected List<Varazsko> varazsko = new ArrayList<Varazsko>();
	protected Ut ut = null;

	/**
	 * Az akadály konstruktora
	 * 
	 * @param Ut
	 *            u
	 */
	public Akadaly(Ut u) {
		this.ut = u;
	}

	/**
	 * void felkovez Felveszi a paraméterül kapott varászkő referenciáját
	 * 
	 * @param Varazsko
	 *            mivel
	 */
	public void felkovez(Varazsko mivel) {
		this.varazsko.add(mivel);
	}

	/**
	 * void sebzodik Levonja a paraméterül kapott értéket az életerejéből.
	 * 
	 * @param int mennyit
	 */
	public void sebzodik(int mennyit) { //TODO meg is kéne halnia, meg ilyesmi.
		eletero -= mennyit;
	}
}
