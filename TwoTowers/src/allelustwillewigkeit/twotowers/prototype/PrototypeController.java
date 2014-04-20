package allelustwillewigkeit.twotowers.prototype;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import allelustwillewigkeit.twotowers.model.Elf;
import allelustwillewigkeit.twotowers.model.Ellenseg;
import allelustwillewigkeit.twotowers.model.Ellensegek;
import allelustwillewigkeit.twotowers.model.Ember;
import allelustwillewigkeit.twotowers.model.EpitesiTerulet;
import allelustwillewigkeit.twotowers.model.Hobbit;
import allelustwillewigkeit.twotowers.model.Jatekmotor;
import allelustwillewigkeit.twotowers.model.JosagosSzaruman;
import allelustwillewigkeit.twotowers.model.Palya;
import allelustwillewigkeit.twotowers.model.PalyaElem;
import allelustwillewigkeit.twotowers.model.Program;
import allelustwillewigkeit.twotowers.model.Start;
import allelustwillewigkeit.twotowers.model.Torony;
import allelustwillewigkeit.twotowers.model.Torp;
import allelustwillewigkeit.twotowers.model.Ut;
import allelustwillewigkeit.twotowers.model.Varazsko;

public class PrototypeController {
	private static final int MAXVARAZSERO = 1000;
	private static boolean palyaszerkeszt = false;
	private static Palya palya;
	private static Jatekmotor motor;
	private static Ellensegek ellen;
	private static Program program;
	private static JosagosSzaruman szaruman;
	private static Start start;
	private static boolean random = false;
	private static boolean fileba = false;
	private static File f;
	private static BufferedWriter o;

	public static void main(String[] args) throws IOException {
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		String s = new String();
		try {
			while (true) {
				s = br.readLine();
				ertelmez(s);
			}
		} catch (Exception e) {
			kiir(e.getMessage());
		}
	}

	private static void ertelmez(String _cmd) {
		String[] cmd = _cmd.split(" ");
		if (cmd != null && _cmd.length() != 0 && _cmd.startsWith("//") == false) {
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
				varazskoListaz();
				break;

			case "HullamRandom":
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

			case "PalyaElemOsszekapcsol":
				palyaElemOsszekapcsol(cmd);
				break;

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
				kiir("Érvénytelen parancs!");
			}
		}

	}

	private static void utOsszekapcsol(String[] cmd) {
		if (palyaszerkeszt) {
			try {
				int egyesID = Integer.parseInt(cmd[1]);
				int kettesID = Integer.parseInt(cmd[2]);
				PalyaElem pe1 = palya.lekerPalyaElemIDvel(egyesID);
				PalyaElem pe2 = palya.lekerPalyaElemIDvel(kettesID);
				pe1.addSzomszed(pe2); // FIXME ha nem kell
				pe1.lekerUt().beallitKovUt(pe2.lekerUt());
				kiir("A két út összelinkelődött" + egyesID + "->" + kettesID);
			} catch (Exception e) {
				kiir(e.getMessage());
			}
		} else
			kiir("Nincs aktiválva a pályaszereksztő mód!");

	}

	private static void vegzetHegyeLerak(String[] cmd) {
		if (palyaszerkeszt) {
			try {
				int palyaElemID = Integer.parseInt(cmd[1]);
				PalyaElem pe = palya.lekerPalyaElemIDvel(palyaElemID);
				pe.legyelVegzetHegye(motor);
				kiir("A végzet hegyének lerakása sikerült " + palyaElemID
						+ "-ra");
			} catch (Exception e) {
				kiir(e.getMessage());
			}
		} else
			kiir("Nincs aktiválva a pályaszereksztő mód!");
	}

	private static void startLerak(String[] cmd) {
		if (palyaszerkeszt) {
			try {
				int palyaElemID = Integer.parseInt(cmd[1]);
				int startID = Integer.parseInt(cmd[2]);
				PalyaElem pe = palya.lekerPalyaElemIDvel(palyaElemID);
				pe.legyelStart(startID);
				start = (Start) pe.lekerUt();
				kiir("A start lerakása sikerült " + palyaElemID + "-re");
			} catch (Exception e) {
				kiir(e.getMessage());
			}
		} else
			kiir("Nincs aktiválva a pályaszereksztő mód!");
	}

	private static void utLerak(String[] cmd) {
		if (palyaszerkeszt) {
			try {
				int palyaElemID = Integer.parseInt(cmd[1]);
				int utID = Integer.parseInt(cmd[2]);

				PalyaElem pe = palya.lekerPalyaElemIDvel(palyaElemID);
				pe.legyelUt(utID);
				kiir("Az út lerakása sikerült " + palyaElemID + "-re");
			} catch (Exception e) {
				kiir(e.getMessage());
			}
		} else
			kiir("Nincs aktiválva a pályaszereksztő mód!");

	}

	private static void epitesiTeruletLerak(String[] cmd) {
		if (palyaszerkeszt) {
			try {
				int palyaElemID = Integer.parseInt(cmd[1]);
				int etID = Integer.parseInt(cmd[2]);
				PalyaElem pe = palya.lekerPalyaElemIDvel(palyaElemID);
				pe.legyelEpitesiTerulet(etID);
				kiir("Építési terület létrejött " + palyaElemID + "-on");
			} catch (Exception e) {
				kiir(e.getMessage());
			}
		} else
			kiir("Nincs aktiválva a pályaszereksztő mód!");
	}

	private static void palyaElemOsszekapcsol(String[] cmd) {
		if (palyaszerkeszt) {
			try {
				int egyesID = Integer.parseInt(cmd[1]);
				int kettesID = Integer.parseInt(cmd[2]);
				PalyaElem pe1 = palya.lekerPalyaElemIDvel(egyesID);
				PalyaElem pe2 = palya.lekerPalyaElemIDvel(kettesID);
				pe1.addSzomszed(pe2);
				kiir("A két pályaelem összelinkelődött" + egyesID + "->"
						+ kettesID);
			} catch (Exception e) {
				kiir(e.getMessage());
			}
		} else
			kiir("Nincs aktiválva a pályaszereksztő mód!");
	}

	private static void palyaElemKeszit(String[] cmd) {
		if (palyaszerkeszt) {
			try {
				int palyaElemID = Integer.parseInt(cmd[1]);
				PalyaElem pe = new PalyaElem(palyaElemID);
				palya.hozzaAdPalyahoz(pe);
				kiir("A pályaelem elkészült" + palyaElemID + "-vel");
			} catch (Exception e) {
				kiir(e.getMessage());
			}
		} else
			kiir("Nincs aktiválva a pályaszereksztő mód!");
	}

	private static void palyaSzerkeszt(String[] cmd) {
		try {
			String muvelet = cmd[1];
			switch (muvelet) {
			case "kezd":
				palyaszerkeszt = true;
				kiir("A pályaszerkesztés megkezdődött.");
				break;
			case "veg":
				palyaszerkeszt = false;
				kiir("A pályaszerkesztés befejeződött.");
				break;
			default:
				kiir("Érvénytelen paraméter");
				break;
			}
		} catch (Exception e) {
			kiir(e.getMessage());
		}
	}

	private static void reset(String[] cmd) {
		try {
			palya = new Palya();
			szaruman = new JosagosSzaruman(MAXVARAZSERO);
			program = new Program();
			ellen = new Ellensegek(motor, 1000, start);
			motor = new Jatekmotor(ellen, szaruman, palya, program);
			palyaszerkeszt = false;
			random = false;
			fileba = false;
			kiir("A reset sikerült.");
		} catch (Exception e) {
			kiir(e.getMessage());
		}
	}

	private static void show(String[] cmd) {
		try {
			String muvelet = cmd[1];
			switch (muvelet) {
			case "map":
				kilistazMap();
				break;
			case "ellensegek":
				kilistazEllensegek();
				break;
			case "allapot":
				switch (motor.lekerallapot()) {
				case 0:
					kiir("Még folyik a mérkőzés!");
					break;
				case 1337:
					kiir("Győzelem!");
					break;
				case -666:
					kiir("Vereség");
					break;
				default:
					System.out
							.println("FAILSAFE: Gáz van, ilyet nem kéne látnod!");
				}
			case "varazskovek":
				varazskoListaz();
				break;
			case "tornyok":
				kilistaztornyok();
				break;
			case "utak":
				kilistazutak();
				break;
			default:
				kiir("Érvénytelen paraméter!");
			}
		} catch (Exception e) {
			kiir(e.getMessage());
		}

	}

	private static void elkodosit(String[] cmd) {
		try {
			int palyaElemID = Integer.parseInt(cmd[1]);
			PalyaElem pe = palya.lekerPalyaElemIDvel(palyaElemID);
			EpitesiTerulet e = pe.lekerEpitesiTerulet();
			Torony t = e.lekerTorony();
			t.elkodosit();
			kiir("A torony elködösítése sikeres" + palyaElemID + "-en.");
		} catch (Exception e) {
			kiir(e.getMessage());
		}
	}

	private static void lekerHanyEllensegVanMeg(String[] cmd) {
		try {
			kiir("Ennyi ellenség van még:" + ellen.lekerHanyEllensegVanMeg());
		} catch (Exception e) {
			kiir(e.getMessage());
		}
	}

	private static void allitHanyEllensegVanMeg(String[] cmd) {
		try {
			int ertek = Integer.parseInt(cmd[1]);
			ellen.allitHanyEllensegVanMeg(ertek);
			kiir(ertek + "-re beállítva a hátralevő ellenségek száma");
		} catch (Exception e) {
			kiir(e.getMessage());
		}
	}

	private static void tick(String[] cmd) {
		try {
			int tmp;
			int hanyszor = tmp = Integer.parseInt(cmd[1]);
			while (hanyszor != 0) {
				hanyszor--;
				motor.tick();
			}
			kiir(tmp + "lépés megtörtént");
		} catch (Exception e) {
			kiir(e.getMessage());
		}
	}

	private static void kilistazMap() {
		kiir("a palya:");
		Ut u;
		EpitesiTerulet e;
		for (PalyaElem tmp : palya.lekerlista()) {
			kiir("palyaelemid:" + tmp.lekerID());
			try {
				u = tmp.lekerUt();
				kiir(" ut");
				if (u.vanAkadalyRajta()) {
					kiir(" akadállyal");
				}
			} catch (Exception ex) {
			}
			try {
				e = tmp.lekerEpitesiTerulet();
				kiir(" epitesi terulet");
				if (e.vanToronyRajta()) {
					kiir(" toronnyal");
				}
			} catch (Exception ex) {
			}
		}
	}

	private static void torpIndit(String[] cmd) {
		try {
			int szint = Integer.parseInt(cmd[1]);
			int darab = Integer.parseInt(cmd[2]);
			int kezdo = Integer.parseInt(cmd[3]);
			for (int i = 0; i < darab; i++) {
				Torp t = new Torp(start, ellen, szint, kezdo);
				kezdo++;
				ellen.beallitKezdohely(start);
				ellen.inditEllenseg(t);
				kiir(darab + "ellenség elkészült!");
			}
		} catch (Exception e) {
			kiir(e.getMessage());
		}
	}

	private static void elfIndit(String[] cmd) {
		try {
			int szint = Integer.parseInt(cmd[1]);
			int darab = Integer.parseInt(cmd[2]);
			int kezdo = Integer.parseInt(cmd[3]);
			for (int i = 0; i < darab; i++) {
				Elf e = new Elf(start, ellen, szint, kezdo);
				kezdo++;
				ellen.beallitKezdohely(start);
				ellen.inditEllenseg(e);
				kiir(darab + "ellenség elkészült!");
			}
		} catch (Exception e) {
			kiir(e.getMessage());
		}
	}

	private static void hobbitIndit(String[] cmd) {
		try {
			int szint = Integer.parseInt(cmd[1]);
			int darab = Integer.parseInt(cmd[2]);
			int kezdo = Integer.parseInt(cmd[3]);
			for (int i = 0; i < darab; i++) {
				Hobbit h = new Hobbit(start, ellen, szint, kezdo);
				kezdo++;
				ellen.beallitKezdohely(start);
				ellen.inditEllenseg(h);
				kiir(darab + "ellenség elkészült!");
			}
		} catch (Exception e) {
			kiir(e.getMessage());
		}
	}

	private static void emberIndit(String[] cmd) {
		try {
			int szint = Integer.parseInt(cmd[1]);
			int darab = Integer.parseInt(cmd[2]);
			int kezdo = Integer.parseInt(cmd[3]);
			for (int i = 0; i < darab; i++) {
				Ember e = new Ember(start, ellen, szint, kezdo);
				kezdo++;
				ellen.beallitKezdohely(start);
				ellen.inditEllenseg(e);
				kiir(darab + "ellenség elkészült!");
			}
		} catch (Exception e) {
			kiir(e.getMessage());
		}
	}

	private static void hullamIndit(String[] cmd) {
		try {// FIXME
			int szint = Integer.parseInt(cmd[1]);
			int darab = Integer.parseInt(cmd[2]);
			if (random) {
				ellen.inditEllenseg(darab, szint);
			} else {
				ellen.inditEllenseg(new Ember(start, ellen, szint));
			}
		} catch (Exception e) {
			kiir(e.getMessage());
		}
	}

	private static void hullamOsszetetelRandom(String[] cmd) {
		try {
			String muvelet = cmd[1];
			switch (muvelet) {
			case "ki":
				random = false;
				break;
			case "be":
				random = true;
				break;
			default:
				kiir("Érvénytelen paraméter");
			}
		} catch (Exception e) {
			kiir(e.getMessage());
		}
	}

	private static void varazskoListaz() {
		try {
			kiir("varazskovek:");
			EpitesiTerulet e;
			for (PalyaElem tmp : palya.lekerlista()) {
				kiir("palyaelemid:" + tmp.lekerID());
				e = tmp.lekerEpitesiTerulet();
				Torony t = e.lekerTorony();
				for (Varazsko v : t.lekerVarazskovek()) {
					kiir("toronyid: " + tmp.lekerID() + " varazskoid: "
							+ v.lekerID() + " duration: " + v.lekerDuration());
				}
			}
		} catch (Exception e) {
			kiir(e.getMessage());
		}
	}

	private static void varazskoLerak(String[] cmd) {
		int palyaElemID, varazskodictID, varazskoID;
		PalyaElem palyaElem;

		try {
			palyaElemID = Integer.parseInt(cmd[1]);
			palyaElem = palya.lekerPalyaElemIDvel(palyaElemID);
			if (palyaElem == null)
				throw new Exception();
		} catch (Exception e) {
			kiir("A varázskő lerakása sikertelen, a PalyaElemID nem létezik.");
			return;
		}

		try {
			varazskodictID = Integer.parseInt(cmd[2]);
			if (varazskodictID < 0)
				throw new Exception("A VarazskoDictID: " + cmd[2] + " hibás");
		} catch (Exception e) {
			kiir(e.getMessage());
			return;
		}

		try {
			varazskoID = Integer.parseInt(cmd[3]);
			if (varazskoID < 0)
				throw new Exception("A VarazskoID: " + cmd[3] + " hibás.");
			if (!palyaElem.vanEpitesiTerulete()) {
				if (!palyaElem.vanUtja()) {
					throw new Exception(
							"A varázskő lerakása sikertelen, a PalyaElemID nem építési terület toronnyal, és nem út akadállyal.");
				}
				Ut u = palyaElem.lekerUt();
				if (!u.vanAkadalyRajta()) {
					throw new Exception(
							"A varázskő lerakása sikertelen, a PalyaElemID nem építési terület toronnyal, és nem út akadállyal.");
				}
				u.lekerAkadaly().felkovez(
						new Varazsko(varazskodictID, varazskoID));
			}
			EpitesiTerulet et = palyaElem.lekerEpitesiTerulet();
			if (!et.vanToronyRajta()) {
				throw new Exception(
						"A varázskő lerakása sikertelen, a PalyaElemID nem építési terület toronnyal, és nem út akadállyal.");
			}
			et.lekerTorony().felkovez(new Varazsko(varazskodictID, varazskoID));
			kiir("A varázskő lerakása sikeres" + palyaElemID + "-re"
					+ varazskoID + "-vel");
		} catch (Exception e) {
			kiir(e.getMessage());
		}
	}

	private static void akadalyLerak(String[] cmd) {
		int palyaElemID, akadalyID;
		PalyaElem palyaElem;

		try {
			palyaElemID = Integer.parseInt(cmd[1]);
			palyaElem = palya.lekerPalyaElemIDvel(palyaElemID);
			if (palyaElem == null)
				throw new Exception();
		} catch (Exception e) {
			kiir("A PalyaElemID nem egy pályaelemé");
			return;
		}

		try {
			akadalyID = Integer.parseInt(cmd[2]);
			if (akadalyID < 0)
				throw new Exception();
		} catch (Exception e) {
			kiir("Az AkadalyElemID nem egy pozitív egész szám");
			return;
		}

		try {
			if (!palyaElem.vanUtja()) {
				throw new Exception("Az adott PalyaElemID-n nincs út");
			}
			Ut u = palyaElem.lekerUt();
			u.lerakAkadaly(akadalyID);
			kiir("Az akadály lerakása sikeres " + palyaElemID + "-re");
		} catch (Exception e) {
			kiir(e.getMessage());
		}
	}

	private static void toronyLerak(String[] cmd) {
		int palyaElemID, toronyID;
		PalyaElem palyaElem;

		try {
			palyaElemID = Integer.parseInt(cmd[1]);
			palyaElem = palya.lekerPalyaElemIDvel(palyaElemID);
			if (palyaElem == null)
				throw new Exception("A PalyaElemID nem egy pályaelemé");
		} catch (Exception e) {
			kiir(e.getMessage());
			return;
		}

		try {
			toronyID = Integer.parseInt(cmd[2]);
			if (toronyID < 0)
				throw new Exception("A ToronyID nem egy pozitív egész szám");
		} catch (Exception e) {
			kiir(e.getMessage());
			return;
		}

		try {
			if (!palyaElem.vanEpitesiTerulete())
				throw new Exception(
						"A torony lerakása sikertelen, a PalyaElemID nem építési terület");
			palyaElem.lekerEpitesiTerulet().lerakTornyot(toronyID);
			kiir("A torony lerakása sikeres " + palyaElemID + "-re " + toronyID
					+ "-vel.");
		} catch (Exception e) {
			kiir(e.getMessage());
		}
	}

	private static void fajlbaIr(String[] cmd) {
		try {
			fileba = true;
			String utvonal = cmd[1];
			f = new File(utvonal);
			o = new BufferedWriter(new FileWriter(f));
			kiir("Az [utvonal] helyre a naplózás megkezdődött.");
		} catch (Exception e) {
			kiir("Az [utvonal] helyre kezdődő naplózás sikertelen (valószínűleg nincs jogosultsága a szoftvernek oda írnia)");
		}
	}

	private static void betoltUtasitasok(String[] cmd) {

		String utvonal = cmd[1];
		try {
			File f1 = new File(utvonal);

			BufferedReader br = new BufferedReader(new FileReader(f1));
			String s;
			kiir("A fájl betöltése sikeres");
			while ((s = br.readLine()) != null) {
				ertelmez(s);
			}
			br.close();
		} catch (Exception e) {
			kiir("A fájl betöltése sikertelen. (Valószínűleg A fájl nem található, vagy nincs olvasási jog.) ");
		}
	}

	private static void kilistazEllensegek() {
		try {
			kiir("ellensegek:");
			for (Ellenseg tmp : ellen.lekerLista()) {
				kiir("ellensegid: " + tmp.lekerid() + " ellenseghp: "
						+ tmp.eleteroLeker() + " utid: "
						+ tmp.lekerut().lekerPalyaelem().lekerID() + " speed: "
						+ tmp.lekersebesseg());
			}
		} catch (Exception e) {
			kiir(e.getMessage());
		}
	}

	private static void kilistaztornyok() {
		try {
			kiir("tornyok:");
			EpitesiTerulet e;
			for (PalyaElem tmp : palya.lekerlista()) {
				kiir("palyaelemid:" + tmp.lekerID());
				e = tmp.lekerEpitesiTerulet();
				kiir(" epitesi terulet");
				if (e.vanToronyRajta()) {
					kiir(" toronnyal");
				}
			}

		} catch (Exception e) {
			kiir(e.getMessage());
		}
	}

	private static void kilistazutak() {
		try {
			kiir("utak:");
			Ut u;
			for (PalyaElem tmp : palya.lekerlista()) {
				kiir("palyaelemid:" + tmp.lekerID());
				u = tmp.lekerUt();
				kiir(" ut");
				if (u.vanAkadalyRajta()) {
					kiir(" akadállyal");
				}
			}
		} catch (Exception e) {
			kiir(e.getMessage());
		}
	}

	private static void kiir(String _str) {
		System.out.print(_str);
		System.out.println();
		if (fileba) {
			try {
				o.write(_str);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
