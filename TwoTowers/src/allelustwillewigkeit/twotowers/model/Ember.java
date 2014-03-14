package allelustwillewigkeit.twotowers.model;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

public class Ember extends Ellenseg {
	public Ember() {
		super();
	}

	@Override
	public void sebezDarda() {
		if (SkeletonController
				.kerdezIH("Ember vagyok. Eltalalt egy Darda. Meghaltam?")) {
			ellensegek.egyEllensegMeghalt(this);
		}
	}

	@Override
	public void sebezTuzgolyo() {
		if (SkeletonController
				.kerdezIH("Ember vagyok. Eltalalt egy Tuzgolyo. Meghaltam?")) {
			ellensegek.egyEllensegMeghalt(this);
		}
	}

	@Override
	public void sebezSzikla() {
		if (SkeletonController
				.kerdezIH("Ember vagyok. Eltalalt egy Szikla. Meghaltam?")) {
			ellensegek.egyEllensegMeghalt(this);
		}
	}

	@Override
	public void sebezNyil() {
		if (SkeletonController
				.kerdezIH("Ember vagyok. Eltalalt egy Nyil. Meghaltam?")) {
			ellensegek.egyEllensegMeghalt(this);
		}
	}
}
