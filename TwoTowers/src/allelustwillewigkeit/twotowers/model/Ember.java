package allelustwillewigkeit.twotowers.model;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

public class Ember extends Ellenseg {
	public Ember() {
		super();
	}

	@Override
	public void sebezDarda() {
		SkeletonController.tabNo();
		if (SkeletonController
				.kerdezIH("Ember vagyok. Eltalalt egy Darda. Meghaltam?")) {
			ellensegek.egyEllensegMeghalt(this);
		}
		SkeletonController.tabCsokken();
	}

	@Override
	public void sebezTuzgolyo() {
		SkeletonController.tabNo();
		if (SkeletonController
				.kerdezIH("Ember vagyok. Eltalalt egy Tuzgolyo. Meghaltam?")) {
			ellensegek.egyEllensegMeghalt(this);
		}
		SkeletonController.tabCsokken();
	}

	@Override
	public void sebezSzikla() {
		SkeletonController.tabNo();
		if (SkeletonController
				.kerdezIH("Ember vagyok. Eltalalt egy Szikla. Meghaltam?")) {
			ellensegek.egyEllensegMeghalt(this);
		}
		SkeletonController.tabCsokken();
	}

	@Override
	public void sebezNyil() {
		SkeletonController.tabNo();
		if (SkeletonController
				.kerdezIH("Ember vagyok. Eltalalt egy Nyil. Meghaltam?")) {
			ellensegek.egyEllensegMeghalt(this);
		}
		SkeletonController.tabCsokken();
	}
}
