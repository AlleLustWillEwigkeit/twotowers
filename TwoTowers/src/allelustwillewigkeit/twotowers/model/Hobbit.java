package allelustwillewigkeit.twotowers.model;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

public class Hobbit extends Ellenseg {
	public Hobbit() {
		super();
	}

	@Override
	public void sebezNyil() {
		if (SkeletonController
				.kerdezIH("Hobbit vagyok. Eltalalt egy Nyil. Meghaltam?")) {
			ellensegek.egyEllensegMeghalt(this);
		}
	}

	@Override
	public void sebezSzikla() {
		if (SkeletonController
				.kerdezIH("Hobbit vagyok. Eltalalt egy Szikla. Meghaltam?")) {
			ellensegek.egyEllensegMeghalt(this);
		}
	}

	@Override
	public void sebezTuzgolyo() {
		if (SkeletonController
				.kerdezIH("Hobbit vagyok. Eltalalt egy Tuzgolyo. Meghaltam?")) {
			ellensegek.egyEllensegMeghalt(this);
		}
	}

	@Override
	public void sebezDarda() {
		if (SkeletonController
				.kerdezIH("Hobbit vagyok. Eltalalt egy Darda. Meghaltam?")) {
			ellensegek.egyEllensegMeghalt(this);
		}
	}
}
