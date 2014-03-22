package allelustwillewigkeit.twotowers.model;

import java.util.ArrayList;
import java.util.HashSet;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

public class Palya {
	public ArrayList<PalyaElem> palyaElem = new ArrayList<PalyaElem>();

	public Palya() {
		super();
	}

	public void ujPalya(int melyikUseCaseHez) {
		SkeletonController.tabNo();
		//TODO ezen faszkodok most
		switch(melyikUseCaseHez){

		case 1: //lépés
			
			
			PalyaElem p1 = new PalyaElem();
			p1.legyelUt();
			palyaElem.add(p1);
			
			PalyaElem p2 = new PalyaElem();
			p2.legyelUt();
			palyaElem.add(p2);
			
			p2.addSzomszed(p1);
			p1.addSzomszed(p2);
			break;
		case 2: //lövés
			
			break;
		case 3://Akadály lerakása
			
			break;
		case 4://torony lerakása
			
			break;
		case 5://varázskő lerakása
			
			break;
		case 6: //győzelem
			
			break;
		case 7 ://vereség
			
			break;
		}
		SkeletonController.tabCsokken();
	}
}
