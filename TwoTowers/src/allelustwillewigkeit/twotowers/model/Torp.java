package allelustwillewigkeit.twotowers.model;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

public class Torp extends Ellenseg {
	public Torp() {
		super();
	}

	@Override
	public void sebezTuzgolyo() {
		if (SkeletonController
				.kerdezIH("Torp vagyok. Eltalalt egy Tuzgolyo. Meghaltam?")) {
			ellensegek.egyEllensegMeghalt(this);
		}
	}

	@Override
	public void sebezSzikla() {
		if (SkeletonController
				.kerdezIH("Torp vagyok. Eltalalt egy Tuzgolyo. Meghaltam?")) {
			ellensegek.egyEllensegMeghalt(this);
		}
	}

	@Override
	public void sebezNyil() {
		if (SkeletonController
				.kerdezIH("Torp vagyok. Eltalalt egy Tuzgolyo. Meghaltam?")) {
			ellensegek.egyEllensegMeghalt(this);
		}
	}

	@Override
	public void sebezDarda() {
		if (SkeletonController
				.kerdezIH("Torp vagyok. Eltalalt egy Tuzgolyo. Meghaltam?")) {
			ellensegek.egyEllensegMeghalt(this);
		}
	}
}
