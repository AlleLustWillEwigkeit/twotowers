package allelustwillewigkeit.twotowers.model;

import java.util.ArrayList;
import java.util.List;

public class Varazsko {
	protected List<Lovedek> lovedek;
	protected double hatotavSzorzo;
	protected double eleteroSzorzo;
	protected int duration;
	protected Varazskovezheto tarolo;
	protected int id;
	protected int dictID;

	public Varazsko(double _eleteroSzorzo, double _hatotavSzorzo,
			int _duration, int _id) {
		lovedek = new ArrayList<Lovedek>();
		eleteroSzorzo = _eleteroSzorzo;
		hatotavSzorzo = _hatotavSzorzo;
		duration = _duration;
		id = _id;
		lovedek.add(new Lovedek(0));
	}

	public Varazsko(int varazskoDictID, int _id) {
		lovedek = new ArrayList<Lovedek>();
		lovedek.add(new Lovedek(0));
		id = _id;
		dictID = varazskoDictID;
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
			lovedek.clear();
			lovedek.add(new Szelo(_id));
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
	
	public int lekerVarazskoDictID(){
		return dictID;
	}

	public void beallitTarolo(Varazskovezheto t) {
		this.tarolo = t;
	}

	/**
	 * void tuzel Minden lovedekenek szol, hogy loje meg a celpontot
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
	 * float lekerHatotavSzorzo Visszater a hatotavszorzoval
	 * 
	 * @return double
	 */
	public double lekerHatotavSzorzo() {
		return this.hatotavSzorzo;
	}

	/**
	 * float lekerEleteroSzorzo Visszater az eleteroszorzoval
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

	public List<Lovedek> lekerLovedekek() {
		if (lovedek != null)
			return lovedek;
		throw new NullPointerException("Nincs lovedek, az gaz!");
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
