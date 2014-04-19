package allelustwillewigkeit.twotowers.prototype;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.omg.CORBA.Environment;

import allelustwillewigkeit.twotowers.model.*;

public class PrototypeController {
	private static final int MAXVARAZSERO = 1000;
	private static boolean palyaszerkeszt;
	private static Palya palya;
	private static Jatekmotor motor;
	private static Ellensegek ellen;
	private static Program program;
	private static JosagosSzaruman szaruman;

	public static void main(String[] args) throws IOException {
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		String s = new String();
		while (true) {
			s = br.readLine();
			String[] cmd = s.split(" ");
			if (cmd != null && cmd.length != 0) {
				switch (cmd[0]) {
				case "BetoltUtasitasok":
					betoltUtasitasok(cmd);
					break;

				case "FajlbaIR":
					fajlbaIr(cmd);
					break;

				case "ToronyLerak":
					toronyLerak(cmd);
					break;

				case "AkadalyLerak":
					akadalyLerak(cmd);
					break;

				case "VarazskoLerak":
					varazskoLerak(cmd);
					break;

				case "VarazskoListaz":
					varazskoListaz(cmd);
					break;

				case "HullamOSszetetelRandom":
					hullamOsszetetelRandom(cmd);
					break;

				case "HullamIndit":
					hullamIndit(cmd);
					break;

				case "EmberIndit":
					emberIndit(cmd);
					break;

				case "HobbitIndit":
					hobbitIndit(cmd);
					break;

				case "ElfIndit":
					elfIndit(cmd);
					break;

				case "TorpIndit":
					torpIndit(cmd);
					break;

				case "KilistazMap":
					kilistazMap();
					break;

				case "Tick":
					tick(cmd);
					break;

				case "AllitHanyEllensegVanMeg":
					allitHanyEllensegVanMeg(cmd);
					break;

				case "LekerHanyEllensegVanMeg":
					lekerHanyEllensegVanMeg(cmd);
					break;

				case "Elkodosit":
					elkodosit(cmd);
					break;

				case "Show":
					show(cmd);
					break;

				case "Reset":
					reset(cmd);
					break;

				case "PalyaSzerkeszt":
					palyaSzerkeszt(cmd);
					break;

				case "PalyaElemKeszit":
					palyaElemKeszit(cmd);
					break;

				// case "PalyaElemOsszekapcsol":
				// palyaElemOsszekapcsol(cmd);
				// break;

				case "EpitesiTeruletLerak":
					epitesiTeruletLerak(cmd);
					break;

				case "UtLerak":
					utLerak(cmd);
					break;

				case "StartLerak":
					startLerak(cmd);
					break;

				case "VegzetHegyeLerak":
					vegzetHegyeLerak(cmd);
					break;

				case "UtOsszekapcsol":
					utOsszekapcsol(cmd);
					break;
				default:
					System.out.println("Érvénytelen parancs!");
				}
			}
		}
	}

	private static void utOsszekapcsol(String[] cmd) {
		if (palyaszerkeszt) {
			int egyesID = Integer.parseInt(cmd[1]);
			int kettesID = Integer.parseInt(cmd[2]);
			PalyaElem pe1 = palya.lekerPalyaElemIDvel(egyesID);
			PalyaElem pe2 = palya.lekerPalyaElemIDvel(kettesID);
			if (pe1 != null && pe2 != null) {
				pe1.lekerUt().beallitKovUt(pe2.lekerUt());
				System.out.println("A két út összelinkelődött" + egyesID + "->"
						+ kettesID);
			} else
				System.out.println("Nincs ilyen pályaelem!");
		} else
			System.out.println("Nincs aktiválva a pályaszereksztő mód!");

	}

	private static void vegzetHegyeLerak(String[] cmd) {
		if (palyaszerkeszt) {
			int palyaElemID = Integer.parseInt(cmd[1]);
			PalyaElem pe = palya.lekerPalyaElemIDvel(palyaElemID);
			if (pe != null) {
				pe.legyelVegzetHegye(motor);
				System.out.println("A végzet hegyének lerakása sikerült"
						+ palyaElemID + "-ra");
			} else
				System.out.println("Nincs ilyen pályaelem!");
		} else
			System.out.println("Nincs aktiválva a pályaszereksztő mód!");
	}

	private static void startLerak(String[] cmd) {
		if (palyaszerkeszt) {
			int palyaElemID = Integer.parseInt(cmd[1]);
			PalyaElem pe = palya.lekerPalyaElemIDvel(palyaElemID);
			if (pe != null) {
				pe.legyelStart();
				System.out.println("A start lerakása sikerült" + palyaElemID
						+ "-re");
			} else
				System.out.println("Nincs ilyen pályaelem!");
		} else
			System.out.println("Nincs aktiválva a pályaszereksztő mód!");
	}

	private static void utLerak(String[] cmd) {
		if (palyaszerkeszt) {
			int palyaElemID = Integer.parseInt(cmd[1]);
			PalyaElem pe = palya.lekerPalyaElemIDvel(palyaElemID);
			if (pe != null) {
				pe.legyelUt();
				System.out.println("Az út lerakása sikerült " + palyaElemID
						+ "-re");
			} else
				System.out.println("Nincs ilyen pályaelem!");
		} else
			System.out.println("Nincs aktiválva a pályaszereksztő mód!");

	}

	private static void epitesiTeruletLerak(String[] cmd) {
		if (palyaszerkeszt) {
			int palyaElemID = Integer.parseInt(cmd[1]);
			PalyaElem pe = palya.lekerPalyaElemIDvel(palyaElemID);
			if (pe != null) {
				pe.legyelEpitesiTerulet();
				System.out.println("Építési terület létrejött " + palyaElemID
						+ "-on");
			} else
				System.out.println("Nincs ilyen pályaelem!");
		} else
			System.out.println("Nincs aktiválva a pályaszereksztő mód!");
	}

	// private static void palyaElemOsszekapcsol(String[] cmd) {
	//
	// int palyaElemID1 = Integer.parseInt(cmd[1]);
	// int palyaElemID2 = Integer.parseInt(cmd[2]);
	// }

	private static void palyaElemKeszit(String[] cmd) {
		if (palyaszerkeszt) {
			int palyaElemID = Integer.parseInt(cmd[1]);
			PalyaElem pe = new PalyaElem(palyaElemID);
			palya.hozzaAdPalyahoz(pe);
			System.out.println("A pályaelem elkészült" + palyaElemID + "-vel");
		} else
			System.out.println("Nincs aktiválva a pályaszereksztő mód!");
	}

	private static void palyaSzerkeszt(String[] cmd) {

		String muvelet = cmd[1];
		switch (muvelet) {
		case "kezd":
			palyaszerkeszt = true;
			System.out.println("A pályaszerkesztés megkezdődött.");
			break;
		case "veg":
			palyaszerkeszt = false;
			System.out.println("A pályaszerkesztés befejeződött.");
			break;
		default:
			System.out.println("Érvénytelen paraméter");
			break;
		}
	}

	private static void reset(String[] cmd) {
		palya = new Palya();
		szaruman = new JosagosSzaruman(MAXVARAZSERO);
		program = new Program();
		motor = new Jatekmotor(ellen, szaruman, palya, program);
		ellen = new Ellensegek(motor, 0);
		System.out.println("A reset sikerült.");
	}

	private static void show(String[] cmd) {
		String muvelet = cmd[1];
		switch (muvelet) {
		case "map":
			kilistazMap();
			break;
		case "ellensegek":
			kilistazEllensegek();
			break;
		default:
			System.out.println("Érvénytelen paraméter!");
		}

	}

	private static void elkodosit(String[] cmd) {

		int palyaElemID = Integer.parseInt(cmd[1]);
		PalyaElem pe = palya.lekerPalyaElemIDvel(palyaElemID);
		pe.lekerEpitesiTerulet().lekerTorony().elkodosit();
		System.out.println("A torony elködösítése sikeres" + palyaElemID
				+ "-en.");
	}

	private static void lekerHanyEllensegVanMeg(String[] cmd) {
		System.out.println("Ennyi ellenség van még:"
				+ ellen.lekerHanyEllensegVanMeg());
	}

	private static void allitHanyEllensegVanMeg(String[] cmd) {

		int ertek = Integer.parseInt(cmd[1]);
		ellen.allitHanyEllensegVanMeg(ertek);
		System.out
				.println(ertek + "-re beállítva a hátralevő ellenségek száma");
	}

	private static void tick(String[] cmd) {
		int tmp;
		int hanyszor = tmp = Integer.parseInt(cmd[1]);
		while (--hanyszor != 0) {
			motor.tick();
		}
		System.out.println(tmp + "lépés megtörtént");
	}

	private static void kilistazMap() {

	}

	private static void torpIndit(String[] cmd) {

		int szint = Integer.parseInt(cmd[1]);
		int darab = Integer.parseInt(cmd[2]);
		for (int i = 0; i < darab; i++) {
			Torp t = new Torp(START_IDE_VALAHOGY, ellen, szint);
			ellen.inditEllenseg(t);
		}
	}

	private static void elfIndit(String[] cmd) {

		int szint = Integer.parseInt(cmd[1]);
		int darab = Integer.parseInt(cmd[2]);
		for (int i = 0; i < darab; i++) {
			Elf e = new Elf(START_IDE_VALAHOGY, ellen, szint);
			ellen.inditEllenseg(e);
		}
	}

	private static void hobbitIndit(String[] cmd) {

		int szint = Integer.parseInt(cmd[1]);
		int darab = Integer.parseInt(cmd[2]);
		for (int i = 0; i < darab; i++) {
			Hobbit h = new Hobbit(START_IDE_VALAHOGY, ellen, szint);
			ellen.inditEllenseg(h);
		}
	}

	private static void emberIndit(String[] cmd) {

		int szint = Integer.parseInt(cmd[1]);
		int darab = Integer.parseInt(cmd[2]);
		for (int i = 0; i < darab; i++) {
			Ember e = new Ember(START_IDE_VALAHOGY, ellen, szint);
			ellen.inditEllenseg(e);
		}
	}

	private static void hullamIndit(String[] cmd) {
		// TODO
		int szint = Integer.parseInt(cmd[1]);
		int kezdoID = Integer.parseInt(cmd[2]);
	}

	private static void hullamOsszetetelRandom(String[] cmd) {
		// TODO
		String muvelet = cmd[1];
	}

	private static void varazskoListaz(String[] cmd) {
		// mit listáz? egy kollekciót? a varázskó "szótárat"?
	}

	private static void varazskoLerak(String[] cmd) {
		int palyaElemID = Integer.parseInt(cmd[1]);
		int varazskoDictID = Integer.parseInt(cmd[2]);
		PalyaElem pe = palya.lekerPalyaElemIDvel(palyaElemID);
		if (pe != null) {
			EpitesiTerulet e = pe.lekerEpitesiTerulet();
			if (e != null) {
				Torony t = e.lekerTorony();
				if (t != null) {
					Varazsko v = new Varazsko(varazskoDictID);
					t.felkovez(v);
					System.out.println("A varázskő lerakása sikeres"
							+ palyaElemID + "-ra");
				} else
					System.out.println("Itt nincs torony!");
			} else
				System.out.println("Itt nincs építési terület, így torony se!");
		} else
			System.out.println("Nincs ilyen pályaelem!");
	}

	private static void akadalyLerak(String[] cmd) {
		int palyaElemID = Integer.parseInt(cmd[1]);
		PalyaElem pe = palya.lekerPalyaElemIDvel(palyaElemID);
		if (pe != null) {
			Ut u = pe.lekerUt();
			if (u != null) {
				u.lerakAkadaly();
			} else
				System.out.println("Itt nincs út!");
		} else
			System.out.println("Nincs ilyen pályaelem!");
	}

	private static void toronyLerak(String[] cmd) {

		int palyaElemID = Integer.parseInt(cmd[1]);
		PalyaElem pe = palya.lekerPalyaElemIDvel(palyaElemID);
		if (pe != null) {
			EpitesiTerulet e = pe.lekerEpitesiTerulet();
			if (e != null) {
				e.lerakTornyot();
			} else
				System.out.println("Itt nincs építési terület!");
		} else
			System.out.println("Nincs ilyen pályaelem!");
	}

	private static void fajlbaIr(String[] cmd) {
		// TODO
		String muvelet = cmd[1];
		String utvonal = null;
		if (cmd.length == 3) {
			utvonal = cmd[2];
		}
	}

	private static void betoltUtasitasok(String[] cmd) {
		String utvonal = cmd[1];
	}

	private static void kilistazEllensegek() {
		System.out.println("ellensegek:");
		for (Ellenseg tmp : ellen.lekerLista()) {
			System.out.println("ellensegid " + tmp.lekerid() + ", ellenseghp"
					+ tmp.eleteroLeker() + ", utid" + tmp.lekerut() + ", speed"
					+ tmp.lekersebesseg());
		}
	}
}
