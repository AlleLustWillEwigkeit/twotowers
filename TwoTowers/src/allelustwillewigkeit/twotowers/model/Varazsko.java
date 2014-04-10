package allelustwillewigkeit.twotowers.model;

import java.util.ArrayList;
import java.util.List;

public class Varazsko {
	protected List<Lovedek> lovedek = new ArrayList<Lovedek>();
	protected float hatotavSzorzo = 0F;
	protected float eleteroSzorzo = 0F;
	protected int duration;

	public Varazsko(float _eleteroSzorzo, float _hatotavSzorzo, int _duration) {
		eleteroSzorzo = _eleteroSzorzo;
		hatotavSzorzo = _hatotavSzorzo;
		duration = _duration;
	}

	public Varazsko() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * void tuzel Minden lövedékének szól, hogy lője meg a célpontot
	 * 
	 * @param Ellenseg
	 *            celpont
	 */
	public void tuzel(Ellenseg celpont) {
		for (Lovedek l : this.lovedek) {
			l.megLo(celpont);
		}
	}

	/**
	 * float lekerHatotavSzorzo Visszatér a hatótávszorzóval
	 * 
	 * @return float
	 */
	public float lekerHatotavSzorzo() {
		return this.hatotavSzorzo;
	}

	/**
	 * float lekerEleteroSzorzo Visszatér az életerőszorzóval
	 * 
	 * @return float
	 */
	public float lekerEleteroSzorzo() {
		return this.eleteroSzorzo;
	}

	public int lekerDuration() {
		return duration;
	}

	public void hozzaadLovedek(Lovedek l) {
		this.lovedek.add(l);
	}

}
