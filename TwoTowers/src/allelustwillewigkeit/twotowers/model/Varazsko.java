package allelustwillewigkeit.twotowers.model;

import java.util.ArrayList;
import java.util.List;

public class Varazsko {
	protected List<Lovedek> lovedek = new ArrayList<Lovedek>();
	protected double hatotavSzorzo;
	protected double eleteroSzorzo;
	protected int duration;
	protected Varazskovezheto tarolo;

	public Varazsko(double _eleteroSzorzo, double _hatotavSzorzo, int _duration) {
		eleteroSzorzo = _eleteroSzorzo;
		hatotavSzorzo = _hatotavSzorzo;
		duration = _duration;
	}

	public Varazsko() {
		// TODO Auto-generated constructor stub
	}

	public void beallitTarolo(Varazskovezheto t) {
		this.tarolo = t;
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
	public double lekerHatotavSzorzo() {
		return this.hatotavSzorzo;
	}

	/**
	 * float lekerEleteroSzorzo Visszatér az életerőszorzóval
	 * 
	 * @return float
	 */
	public double lekerEleteroSzorzo() {
		return this.eleteroSzorzo;
	}

	public int lekerDuration() {
		return duration;
	}

	public void hozzaadLovedek(Lovedek l) {
		this.lovedek.add(l);
	}

	public void tick() {
		if (duration == -1)
			return;

		duration--;
		if (duration <= 0) {
			duration = 0;

			if (this.tarolo != null) {
				this.tarolo.lejarVarazsko(this);
			}
		}
	}

}
