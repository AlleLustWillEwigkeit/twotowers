package allelustwillewigkeit.twotowers.model;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

public class Ember extends Ellenseg {
	public Ember(Ut start, Ellensegek ellens) {
		super(start,ellens);
		SkeletonController.tabNo();
		SkeletonController.println("<<create>> Ember");
		SkeletonController.tabCsokken();
	}

	@Override
	public void sebezDarda() {
		SkeletonController.tabNo();
		if(ellensegek != null){
			if (SkeletonController
					.kerdezIH("Ember vagyok. Eltalalt egy Darda. Meghaltam?")) {
				ellensegek.egyEllensegMeghalt(this);
			}
		}else{
			SkeletonController.println("Ember vagyok. Eltalalt egy Darda.");
		}
		SkeletonController.tabCsokken();
	}

	@Override
	public void sebezTuzgolyo() {
		SkeletonController.tabNo();
		
		if(ellensegek != null){
			if (SkeletonController
					.kerdezIH("Ember vagyok. Eltalalt egy Tuzgolyo. Meghaltam?")) {
				ellensegek.egyEllensegMeghalt(this);
			}
		}else{
			SkeletonController.println("Ember vagyok. Eltalalt egy Tuzgolyo.");
		}
		SkeletonController.tabCsokken();
	}

	@Override
	public void sebezSzikla() {
		SkeletonController.tabNo();
		
		if(ellensegek != null){
			if (SkeletonController
					.kerdezIH("Ember vagyok. Eltalalt egy Szikla. Meghaltam?")) {
				ellensegek.egyEllensegMeghalt(this);
			}
		}else{
			SkeletonController.println("Ember vagyok. Eltalalt egy Szikla.");
		}
		SkeletonController.tabCsokken();
	}

	@Override
	public void sebezNyil() {
		SkeletonController.tabNo();
		
		if(ellensegek != null){
			if (SkeletonController
					.kerdezIH("Ember vagyok. Eltalalt egy Nyil. Meghaltam?")) {
				ellensegek.egyEllensegMeghalt(this);
			}
		}else{
			SkeletonController.println("Ember vagyok. Eltalalt egy Nyil.");
		}
		SkeletonController.tabCsokken();
	}
}
