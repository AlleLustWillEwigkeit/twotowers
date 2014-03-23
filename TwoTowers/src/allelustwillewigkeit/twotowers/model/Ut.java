package allelustwillewigkeit.twotowers.model;

import java.util.ArrayList;
import java.util.List;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

public class Ut {
	public Akadaly akadaly = null;
	public List<Torony> torony = new ArrayList<Torony>();
	public List<Ut> ut = new ArrayList<Ut>();

	/**
	 * Az út konstruktora
	 */
	public Ut() {
		super();
		SkeletonController.tabNo();
		SkeletonController.println("<<create>> Ut");
		SkeletonController.tabCsokken();
	}

	/** Void raLep
	 * Minden tonyának szól, hogy tüzeljen a célpontra
	 * @param Ellenseg ellenseg
	 */
	public void raLep(Ellenseg ellenseg) {
		SkeletonController.tabNo();
		for (Torony t : this.torony) {
			t.tuzel(ellenseg);
		}
		SkeletonController.tabCsokken();
	}

	/** Void feliratkozik
	 * Ha a torony még nincs alistában, akkor felveszi oda
	 * @param Torony torony
	 */
	public void feliratkozik(Torony torony) {
		SkeletonController.tabNo();
		if( !this.torony.contains(torony)){
			this.torony.add(torony);
		}
		SkeletonController.tabCsokken();
	}

	/** Void akadalyomLebomlott
	 *  Az akadályát törli.
	 */
	public void akadalyomLebomlott() {
		SkeletonController.tabNo();
		this.akadaly = null;
		SkeletonController.tabCsokken();
	}

	/** Void lerakAkadaly
	 * Létrehoz egy új akadályt, és felveszi a referenciáját.
	 */
	public void lerakAkadaly() {
		SkeletonController.tabNo();
		this.akadaly = new Akadaly(this);
		SkeletonController.tabCsokken();
	}

	/** boolean vanAkadalyRajta
	 * Igazzal tér vissza, ha van akadály rajta, máskülönben hamissal
	 * @return boolean
	 */
	public boolean vanAkadalyRajta() {
		SkeletonController.tabNo();
		SkeletonController.tabCsokken();
		return (this.akadaly != null);
	}

	/** Akadaly lekerAkadaly
	 * Az akadály referenciájával tér vissza, vagy nullal, ha nincs rajta akadály.
	 * @return Akadaly
	 */
	public Akadaly lekerAkadaly() {
		SkeletonController.tabNo();
		SkeletonController.tabCsokken();
		return this.akadaly; 
	}

	/** Ut lekerKovUt
	 * Az első nála ismert úttal tér vissza, vagy ha a tároló üres, akkor nullal.
	 * @return Ut
	 */
	public Ut lekerKovUt() {
		SkeletonController.tabNo();
		SkeletonController.tabCsokken();
		if(this.ut.isEmpty())
			return null;
		else
			return this.ut.get(0);
	}

	/** Void beallitKovUt
	 * Hozzáadja a paraméterül kapott utat a listához, ha még nincs benne.
	 * @param ut
	 */
	public void beallitKovUt(Ut ut) {
		SkeletonController.tabNo();
		if( !this.ut.contains(ut)){
			this.ut.add(ut);
		}
		SkeletonController.tabCsokken();
	}

	/** void akadalySebzes
	 * Sebzi a rajta lévő akadályt, ha van.
	 * @param int mennyit
	 */
	public void akadalySebzes(int mennyit) {
		SkeletonController.tabNo();
		if (this.vanAkadalyRajta()) 
			this.lekerAkadaly().sebzodik(mennyit);
		SkeletonController.tabCsokken();
	}
}
