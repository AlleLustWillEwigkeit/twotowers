package allelustwillewigkeit.twotowers.model;

import java.util.ArrayList;
import java.util.List;

public class Varazsko {
	protected List<Lovedek> lovedek = new ArrayList<Lovedek>();
	protected double hatotavSzorzo;
	protected double eleteroSzorzo;
	protected int duration;
	protected Varazskovezheto tarolo;
	protected int id;

	public Varazsko(double _eleteroSzorzo, double _hatotavSzorzo,
			int _duration, int _id) {
		eleteroSzorzo = _eleteroSzorzo;
		hatotavSzorzo = _hatotavSzorzo;
		duration = _duration;
		id = _id;
	}

	public Varazsko(int varazskoDictID, int _id) {
		id = _id;
		switch (varazskoDictID) {
		case 0:
			eleteroSzorzo = 1;
			hatotavSzorzo = 1;
			duration = -1;
			break;
		case 1:
			eleteroSzorzo = 1.5;
			hatotavSzorzo = 1.5;
			duration = -1;
			break;
		case 2:
			eleteroSzorzo = 2;
			hatotavSzorzo = 1.1;
			duration = -1;
			break;
		case 3:
			eleteroSzorzo = 2;
			hatotavSzorzo = 2;
			duration = -1;
			break;
		case 4:
			eleteroSzorzo = 2;
			hatotavSzorzo = 0.8;
			duration = -1;
			break;
		case 5:
			eleteroSzorzo = 2;
			hatotavSzorzo = 0.8;
			duration = -1;
			break;
		case 6:
			eleteroSzorzo = 1;
			hatotavSzorzo = 0.5;
			duration = 10;
			break;
		default:
			eleteroSzorzo = 1;
			hatotavSzorzo = 1;
			duration = -1;
			break;
		}
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
	 * @return double
	 */
	public double lekerHatotavSzorzo() {
		return this.hatotavSzorzo;
	}

	/**
	 * float lekerEleteroSzorzo Visszatér az életerőszorzóval
	 * 
	 * @return double
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

	public int lekerID() {
		return id;
	}
}
