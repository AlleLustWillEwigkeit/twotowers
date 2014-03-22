package allelustwillewigkeit.twotowers.model;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

public class Torp extends Ellenseg {
	public Torp(Ut start, Ellensegek ellens) {
		super(start,ellens);
		SkeletonController.tabNo();
		SkeletonController.println("<<create>> Torp");
		SkeletonController.tabCsokken();
	}

	@Override
	public void sebezTuzgolyo() {
		SkeletonController.tabNo();
		if(ellensegek != null){
			if (SkeletonController
					.kerdezIH("Torp vagyok. Eltalalt egy Tuzgolyo. Meghaltam?")) {
				ellensegek.egyEllensegMeghalt(this);
			}
		}else{
			SkeletonController.println("Torp vagyok. Eltalalt egy Tuzgolyo.");
		}
		SkeletonController.tabCsokken();
	}

	@Override
	public void sebezSzikla() {
		SkeletonController.tabNo();
		if(ellensegek != null){
			if (SkeletonController
					.kerdezIH("Torp vagyok. Eltalalt egy Szikla. Meghaltam?")) {
				ellensegek.egyEllensegMeghalt(this);
			}
		}else{
			SkeletonController.println("Torp vagyok. Eltalalt egy Szikla.");
		}
		SkeletonController.tabCsokken();
	}

	@Override
	public void sebezNyil() {
		SkeletonController.tabNo();
		if(ellensegek != null){
			if (SkeletonController
					.kerdezIH("Torp vagyok. Eltalalt egy Nyil. Meghaltam?")) {
				ellensegek.egyEllensegMeghalt(this);
			}
		}else{
			SkeletonController.println("Torp vagyok. Eltalalt egy Nyil.");
		}
		SkeletonController.tabCsokken();
	}

	@Override
	public void sebezDarda() {
		SkeletonController.tabNo();
		if(ellensegek != null){
			if (SkeletonController
					.kerdezIH("Torp vagyok. Eltalalt egy Darda. Meghaltam?")) {
				ellensegek.egyEllensegMeghalt(this);
			}
		}else{
			SkeletonController.println("Torp vagyok. Eltalalt egy Darda.");
		}
		SkeletonController.tabCsokken();
	}
}
