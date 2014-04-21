package allelustwillewigkeit.twotowers.prototype;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import allelustwillewigkeit.twotowers.model.Akadaly;
import allelustwillewigkeit.twotowers.model.Elf;
import allelustwillewigkeit.twotowers.model.Ellenseg;
import allelustwillewigkeit.twotowers.model.Ellensegek;
import allelustwillewigkeit.twotowers.model.Ember;
import allelustwillewigkeit.twotowers.model.EpitesiTerulet;
import allelustwillewigkeit.twotowers.model.Hobbit;
import allelustwillewigkeit.twotowers.model.Jatekmotor;
import allelustwillewigkeit.twotowers.model.JosagosSzaruman;
import allelustwillewigkeit.twotowers.model.Lovedek;
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
		String[] cmd = _cmd.toUpperCase().split(" ");
		if (cmd != null && _cmd.length() != 0 && _cmd.startsWith("//") == false) {
			switch (cmd[0]) {
			case "BETOLTUTASITASOK":
				betoltUtasitasok(cmd);
				break;

			case "FAJLBAIR":
				fajlbaIr(cmd);
				break;

			case "TORONYLERAK":
				toronyLerak(cmd);
				break;

			case "AKADALYLERAK":
				akadalyLerak(cmd);
				break;

			case "VARAZSKOLERAK":
				varazskoLerak(cmd);
				break;

			case "VARAZSKOLISTAZ":
				varazskoListaz();
				break;

			case "HULLAMRANDOM":
				hullamOsszetetelRandom(cmd);
				break;

			case "HULLAMINDIT":
				hullamIndit(cmd);
				break;

			case "EMBERINDIT":
				emberIndit(cmd);
				break;

			case "HOBBITINDIT":
				hobbitIndit(cmd);
				break;

			case "ELFINDIT":
				elfIndit(cmd);
				break;

			case "TORPINDIT":
				torpIndit(cmd);
				break;

			case "KILISTAZMAP":
				kilistazMap();
				break;

			case "TICK":
				tick(cmd);
				break;

			case "ALLITHANYELLENSEGVANMEG":
				allitHanyEllensegVanMeg(cmd);
				break;

			case "LEKERHANYELLENSEGVANMEG":
				lekerHanyEllensegVanMeg(cmd);
				break;

			case "ELKODOSIT":
				elkodosit(cmd);
				break;

			case "SHOW":
				show(cmd);
				break;

			case "RESET":
				reset(cmd);
				break;

			case "PALYASZERKESZT":
				palyaSzerkeszt(cmd);
				break;

			case "PALYAELEMKESZIT":
				palyaElemKeszit(cmd);
				break;

			case "PALYAELEMOSSZEKAPCSOL":
				palyaElemOsszekapcsol(cmd);
				break;

			case "EPITESITERULETLERAK":
				epitesiTeruletLerak(cmd);
				break;

			case "UTLERAK":
				utLerak(cmd);
				break;

			case "STARTLERAK":
				startLerak(cmd);
				break;

			case "VEGZETHEGYELERAK":
				vegzetHegyeLerak(cmd);
				break;

			case "UTOSSZEKAPCSOL":
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
				if (egyesID < 0)
					throw new Exception(
							"Az UtID_Honnan nem egy pozitív egész szám.");
				int kettesID = Integer.parseInt(cmd[2]);
				if (kettesID < 0)
					throw new Exception(
							"Az UtID_Hova nem egy pozitív egész szám.");
				PalyaElem pe1 = palya.lekerPalyaElemIDvel(egyesID);
				if (pe1 == null)
					throw new Exception(
							"Az PalyaElemID_Honnan nem egy PalyaElemID");
				PalyaElem pe2 = palya.lekerPalyaElemIDvel(kettesID);
				if (pe2 == null)
					throw new Exception(
							"Az PalyaElemID_Hova nem egy PalyaElemID");
				Ut honnan = pe1.lekerUt();
				if (honnan == null)
					throw new Exception("Nincs út a PályaElemID_Honnan-on");
				Ut hova = pe2.lekerUt();
				if (hova == null)
					throw new Exception("Nincs út a PályaElemID_Hová-n");
				pe1.addSzomszed(pe2);
				pe2.addSzomszed(pe1);
				honnan.beallitKovUt(hova);
				kiir("A két út összelinkelődött" + egyesID + "->" + kettesID);
			} catch (Exception e) {
				kiir(e.getMessage());
			}
		} else
			kiir("A pályaszerkesztés nincs bekapcsolva, így sikertelen. A bekapcsoláshoz írdd be, hogy “PalyaSzerkeszt kezd”");

	}

	private static void vegzetHegyeLerak(String[] cmd) {
		if (palyaszerkeszt) {
			try {
				int palyaElemID = Integer.parseInt(cmd[1]);
				if (palyaElemID < 0)
					throw new Exception(
							"A PályaElemID nem egy pozitív egész szám.");
				int vegzetHegyeID = Integer.parseInt(cmd[2]);
				PalyaElem pe = palya.lekerPalyaElemIDvel(palyaElemID);
				if (pe == null)
					throw new Exception("A PályaElemID nem egy pályaelemé.");
				if (pe.vanUtja())
					throw new Exception(
							"A vég lerakása sikertelen, mert már van vég vagy út vagy start.");
				pe.legyelVegzetHegye(motor, vegzetHegyeID);
				start = (Start) pe.lekerUt();
				kiir("A végzet hegyének lerakása sikerült, " + palyaElemID
						+ "-re" + vegzetHegyeID + "-vel");
			} catch (Exception e) {
				kiir(e.getMessage());
			}
		} else
			kiir("A pályaszerkesztés nincs bekapcsolva, így sikertelen. A bekapcsoláshoz írd be, hogy “PalyaSzerkeszt kezd”");
	}

	private static void startLerak(String[] cmd) {
		if (palyaszerkeszt) {
			try {
				int palyaElemID = Integer.parseInt(cmd[1]);
				if (palyaElemID < 0)
					throw new Exception(
							"A PályaElemID nem egy pozitív egész szám.");
				int startID = Integer.parseInt(cmd[2]);
				PalyaElem pe = palya.lekerPalyaElemIDvel(palyaElemID);
				if (pe == null)
					throw new Exception("A PályaElemID nem egy pályaelemé.");
				if (pe.vanUtja())
					throw new Exception(
							"A start lerakása sikertelen, mert már van start vagy út vagy vég.");
				pe.legyelStart(startID);
				start = (Start) pe.lekerUt();
				kiir("A start lerakása sikerült " + palyaElemID + "-re"
						+ startID + "-vel");
			} catch (Exception e) {
				kiir(e.getMessage());
			}
		} else
			kiir("A pályaszerkesztés nincs bekapcsolva, így sikertelen. A bekapcsoláshoz írd be, hogy “PalyaSzerkeszt kezd”");
	}

	private static void utLerak(String[] cmd) {
		if (palyaszerkeszt) {
			try {
				int palyaElemID = Integer.parseInt(cmd[1]);
				if (palyaElemID < 0)
					throw new Exception(
							"A PályaElemID nem egy pozitív egész szám.");
				int utID = Integer.parseInt(cmd[2]);
				PalyaElem pe = palya.lekerPalyaElemIDvel(palyaElemID);
				if (pe == null)
					throw new Exception("A PályaElemID nem egy pályaelemé.");
				if (pe.vanUtja())
					throw new Exception(
							"Az út lerakása sikertelen, mert már van start vagy út vagy vég.");

				pe.legyelUt(utID);
				kiir("Az út lerakása sikerült " + palyaElemID + "-re" + utID
						+ "-vel");
			} catch (Exception e) {
				kiir(e.getMessage());
			}
		} else
			kiir("A pályaszerkesztés nincs bekapcsolva, így sikertelen. A bekapcsoláshoz írd be, hogy “PalyaSzerkeszt kezd”");
	}

	private static void epitesiTeruletLerak(String[] cmd) {
		if (palyaszerkeszt) {
			try {
				int palyaElemID = Integer.parseInt(cmd[1]);
				if (palyaElemID < 0)
					throw new Exception(
							"A PályaElemID nem egy pozitív egész szám.");
				int etID = Integer.parseInt(cmd[2]);
				PalyaElem pe = palya.lekerPalyaElemIDvel(palyaElemID);
				if (pe == null)
					throw new Exception("A PályaElemID nem egy pályaelemé.");
				pe.legyelEpitesiTerulet(etID);
				kiir("Építési terület létrejött " + palyaElemID + "-re " + etID
						+ "-vel");
			} catch (Exception e) {
				kiir(e.getMessage());
			}
		} else {
			kiir("A pályaszerkesztés nincs bekapcsolva, így sikertelen. A bekapcsoláshoz írd be, hogy “PalyaSzerkeszt kezd”");
		}
	}

	private static void palyaElemOsszekapcsol(String[] cmd) {
		if (palyaszerkeszt) {
			try {
				int egyesID = Integer.parseInt(cmd[1]);
				if (egyesID < 0)
					throw new Exception(
							"Az adott PalyaElemID1 nem egy pozitív egész szám.");
				int kettesID = Integer.parseInt(cmd[2]);
				if (kettesID < 0)
					throw new Exception(
							"Az adott PalyaElemID2 nem egy pozitív egész szám.");
				PalyaElem pe1 = palya.lekerPalyaElemIDvel(egyesID);
				if (pe1 == null)
					throw new Exception("A PalyaElemID1 nem egy PalyaElemID");
				PalyaElem pe2 = palya.lekerPalyaElemIDvel(kettesID);
				if (pe2 == null)
					throw new Exception("A PalyaElemID2 nem egy PalyaElemID");
				pe1.addSzomszed(pe2);
				pe2.addSzomszed(pe1);
				kiir("A két pályaelem összelinkelődött" + egyesID + "<->"
						+ kettesID);
			} catch (Exception e) {
				kiir(e.getMessage());
			}
		} else
			kiir("A pályaszerkesztés nincs bekapcsolva, így sikertelen. A bekapcsoláshoz írd be, hogy “PalyaSzerkeszt kezd”");
	}

	private static void palyaElemKeszit(String[] cmd) {
		if (palyaszerkeszt) {
			try {
				int palyaElemID = Integer.parseInt(cmd[1]);
				if (palyaElemID < 0)
					throw new Exception(
							"Az adott PalyaElemID nem egy pozitív egész szám.");
				PalyaElem pe1 = palya.lekerPalyaElemIDvel(palyaElemID);
				if (pe1 == null) {
					PalyaElem pe = new PalyaElem(palyaElemID);
					palya.hozzaAdPalyahoz(pe);
					kiir("A pályaelem elkészült " + palyaElemID + "-vel");
				} else {
					throw new Exception("Az adott PalyaElemID már foglalt.");
				}
			} catch (Exception e) {
				kiir(e.getMessage());
			}
		} else
			kiir("A pályaszerkesztés nincs bekapcsolva, így sikertelen. A bekapcsoláshoz írd be, hogy 'PalyaSzerkeszt kezd'");
	}

	private static void palyaSzerkeszt(String[] cmd) {
		try {
			String muvelet = cmd[1];
			switch (muvelet) {
			case "KEZD":
				palyaszerkeszt = true;
				kiir("A pályaszerkesztés megkezdődött.");
				break;
			case "VEG":
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
			ellen = new Ellensegek(motor, 1000, start, szaruman);
			motor = new Jatekmotor(ellen, szaruman, palya, program);
			ellen.beallitmotor(motor);
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
			case "ALL":
				kilistazEllensegek();
				kilistazMap();
				break;
			case "MAP":
				kilistazMap();
				break;
			case "ELLENSEGEK":
				kilistazEllensegek();
				break;
			case "ALLAPOT":
				switch (motor.lekerallapot()) {
				case 0:
					kiir("Folyamatban");
					break;
				case 1337:
					kiir("Győzelem");
					break;
				case -666:
					kiir("Vereség");
					break;
				default:
					System.out
							.println("FAILSAFE: Gáz van, ilyet nem kéne látnod!");
					break;
				}
				break;
			case "VARAZSKOVEK":
				varazskoListaz();
				break;
			case "TORNYOK":
				kilistaztornyok();
				break;
			case "AKADALYOK":
				kilistazakadalyok();
				break;
			case "UTAK":
				kilistazutak();
				break;
			case "ELLENSEGTAROLO":
				kilistaztarolo();
				break;
			default:
				kiir("Érvénytelen paraméter!");
			}
		} catch (Exception e) {
			kiir(e.getMessage());
		}

	}

	private static void kilistazakadalyok() {
		try {
			kiir("akadalyok:");
			for (PalyaElem tmp : palya.lekerlista()) {
				if (tmp.vanUtja()) {
					if (tmp.lekerUt().vanAkadalyRajta()) {
						Akadaly t = tmp.lekerUt().lekerAkadaly();
						kiir("akadalyid " + t.lekerID() + " akadalyhp "
								+ t.lekerhp());
					}
				}
			}

		} catch (Exception e) {
			kiir(e.getMessage());
		}
	}

	private static void kilistaztarolo() {
		kiir("spawnolhatoEllensegek " + ellen.lekerHanyEllensegVanMeg()
				+ " kintlevoEllensegek " + ellen.lekerspawnolt());
	}

	private static void elkodosit(String[] cmd) {
		try {
			int palyaElemID = Integer.parseInt(cmd[1]);
			if (palyaElemID < 0)
				throw new Exception(
						"A megadott paraméter nem egy pozitív egész szám.");
			PalyaElem pe = palya.lekerPalyaElemIDvel(palyaElemID);
			if (pe == null)
				throw new Exception("A megadott paraméter nem egy PalyaElemID.");
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
			kiir(ellen.lekerHanyEllensegVanMeg()
					+ "db ellenség spawnolható még");
		} catch (Exception e) {
			kiir(e.getMessage());
		}
	}

	private static void allitHanyEllensegVanMeg(String[] cmd) {
		try {
			int ertek = Integer.parseInt(cmd[1]);
			if (ertek < 0)
				throw new Exception(
						"A megadott paraméter nem egy pozitív egész szám.");
			ellen.allitHanyEllensegVanMeg(ertek);
			kiir(ertek + "db ellenség spawnolási határ beálltása sikeres.");
		} catch (Exception e) {
			kiir(e.getMessage());
		}
	}

	private static void tick(String[] cmd) {
		try {
			int tmp;
			int hanyszor = tmp = Integer.parseInt(cmd[1]);
			if (hanyszor < 0)
				throw new Exception(
						"A megadott paraméter nem egy pozitív egész szám.");
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
				kiir(" utid " + u.lekerID());
				if (u.vanAkadalyRajta()) {
					kiir(" akadályid " + u.lekerAkadaly().lekerID());
				}
			} catch (Exception ex) {
			}
			try {
				e = tmp.lekerEpitesiTerulet();
				kiir(" epitesiTeruletID " + e.lekerID());
				if (e.vanToronyRajta()) {
					kiir(" toronyID " + e.lekerTorony().lekerID());
					if (e.lekerTorony().lekerVarazskovek() != null) {
						for (Varazsko v : e.lekerTorony().lekerVarazskovek()) {
							for (Lovedek l : v.lekerLovedekek()) {
								kiir("varazskoID " + v.lekerID() + "lovedekID "
										+ l.lekerID());
							}
						}
					}
				}
			} catch (Exception ex) {
			}
		}
	}

	private static void torpIndit(String[] cmd) {
		try {
			int szint = Integer.parseInt(cmd[1]);
			int darab = Integer.parseInt(cmd[2]);
			if (darab < 0)
				throw new Exception(
						"a megadott intDarab paraméter nem egy pozitív egész szám.");
			int kezdo = Integer.parseInt(cmd[3]);
			if (kezdo < 0)
				throw new Exception(
						"a megadott kezdoID paraméter nem egy pozitív egész szám.");

			for (int i = 0; i < darab; i++) {
				Torp e = new Torp(start, ellen, szint, kezdo);
				kezdo++;
				ellen.beallitKezdohely(start);
				ellen.inditEllenseg(e);
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
			if (darab < 0)
				throw new Exception(
						"a megadott intDarab paraméter nem egy pozitív egész szám.");
			int kezdo = Integer.parseInt(cmd[3]);
			if (kezdo < 0)
				throw new Exception(
						"a megadott kezdoID paraméter nem egy pozitív egész szám.");

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
			if (darab < 0)
				throw new Exception(
						"a megadott intDarab paraméter nem egy pozitív egész szám.");
			int kezdo = Integer.parseInt(cmd[3]);
			if (kezdo < 0)
				throw new Exception(
						"a megadott kezdoID paraméter nem egy pozitív egész szám.");

			for (int i = 0; i < darab; i++) {
				Hobbit e = new Hobbit(start, ellen, szint, kezdo);
				kezdo++;
				ellen.beallitKezdohely(start);
				ellen.inditEllenseg(e);
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
			if (darab < 0)
				throw new Exception(
						"a megadott intDarab paraméter nem egy pozitív egész szám.");
			int kezdo = Integer.parseInt(cmd[3]);
			if (kezdo < 0)
				throw new Exception(
						"a megadott kezdoID paraméter nem egy pozitív egész szám.");

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

/*	private static void hullamIndit(String[] cmd) {
		try {// FIXME
			int szint = Integer.parseInt(cmd[1]);
			int darab = Integer.parseInt(cmd[2]);
			int id = Integer.parseInt(cmd[3]); // TODO DOKUMENTÁCIÓ CHECK
			if (random) {
				for (int i = 0; i != darab; i++) {
					int tipus = (int) (Math.random() * 4);
					switch (tipus) {
					case 0:
						ellen.inditEllenseg(new Ember(start, ellen, szint, id++));
						break;
					case 1:
						ellen.inditEllenseg(new Torp(start, ellen, szint, id++));
						break;
					case 2:
						ellen.inditEllenseg(new Hobbit(start, ellen, szint,
								id++));
						break;
					case 3:
						ellen.inditEllenseg(new Elf(start, ellen, szint, id++));
						break;
					}
				}

			} else { // if nem random
				for (int i = 0; i != darab; i++)
					ellen.inditEllenseg(new Ember(start, ellen, 1, id++));

			}
		} catch (Exception e) {
			kiir(e.getMessage());
		}
	}*/

	public static void hullamIndit(String[] cmd) {
		int szint = Integer.parseInt(cmd[1]);
		int id = Integer.parseInt(cmd[2]);
		final int[][] konstansok = new int[][] { 
				{ 0, 0, 1, 0 },
				{ 1, 0, 1, 0 }, 
				{ 2, 1, 2, 1 }, 
				{ 3, 2, 3, 2 }, 
				{ 4, 3, 5, 4 } 
		};

		if (random) {
			try {
				for (int i = 0; i != konstansok[szint][0]; i++) {
					ellen.inditEllenseg(new Ember(start, ellen, 1, id++));
				}
				for (int i = 0; i != konstansok[szint][1]; i++) {
					ellen.inditEllenseg(new Torp(start, ellen, 1, id++));
				}
				for (int i = 0; i != konstansok[szint][2]; i++) {
					ellen.inditEllenseg(new Hobbit(start, ellen, 1, id++));
				}
				for (int i = 0; i != konstansok[szint][3]; i++) {
					ellen.inditEllenseg(new Elf(start, ellen, 1, id++));
				}
			} catch (Exception e) {}
		} else {
			Random rnd = new Random();
			
			try {
				for (int i = 0; i != rnd.nextInt(5) + 1; i++) {
					ellen.inditEllenseg(new Ember(start, ellen, 1, id++));
				}
				for (int i = 0; i != rnd.nextInt(5) + 1; i++) {
					ellen.inditEllenseg(new Torp(start, ellen, 1, id++));
				}
				for (int i = 0; i != rnd.nextInt(5) + 1; i++) {
					ellen.inditEllenseg(new Hobbit(start, ellen, 1, id++));
				}
				for (int i = 0; i != rnd.nextInt(5) + 1; i++) {
					ellen.inditEllenseg(new Elf(start, ellen, 1, id++));
				}
			} catch (Exception e) {}
		}
	}

	private static void hullamOsszetetelRandom(String[] cmd) {
		try {
			String muvelet = cmd[1];
			switch (muvelet) {
			case "KI":
				random = false;
				kiir("Az összetétel az előre definiált szinteknek megfelelő");
				break;
			case "BE":
				random = true;
				kiir("Az összetétel véletlenszerű");
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
			Akadaly a;
			for (PalyaElem tmp : palya.lekerlista()) {
				kiir("palyaelemid:" + tmp.lekerID());
				if (tmp.vanEpitesiTerulete()) {
					if (tmp.lekerEpitesiTerulet().vanToronyRajta()) {
						e = tmp.lekerEpitesiTerulet();
						Torony t = e.lekerTorony();
						for (Varazsko v : t.lekerVarazskovek()) {
							kiir("palyaelemid: " + tmp.lekerID()
									+ "parentToronyid" + t.lekerID()
									+ " varazskoid: " + v.lekerID()
									+ " duration: " + v.lekerDuration());
						}
					}
				}
				if (tmp.vanUtja()) {
					if (tmp.lekerUt().vanAkadalyRajta()) {
						a = tmp.lekerUt().lekerAkadaly();
						for (Varazsko v : a.lekerVarazskovek()) {
							kiir("palyaelemid: " + tmp.lekerID()
									+ "parentAkadalyid" + a.lekerID()
									+ " varazskoid: " + v.lekerID()
									+ " duration: " + v.lekerDuration());
						}
					}
				}
			}
		} catch (Exception e) {
			kiir(e.getMessage());
		}
	}

	private static void varazskoLerak(String[] cmd) {
		try {
			int palyaElemID, varazskodictID, varazskoID;
			PalyaElem palyaElem;
			palyaElemID = Integer.parseInt(cmd[1]);
			palyaElem = palya.lekerPalyaElemIDvel(palyaElemID);
			if (palyaElem == null)
				throw new Exception(
						"A varázskő lerakása sikertelen, a PalyaElemID nem létezik.");
			varazskodictID = Integer.parseInt(cmd[2]);
			if (varazskodictID < 0)
				throw new Exception("A VarazskoDictID: " + cmd[2] + " hibás");
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
		try {
			int palyaElemID, akadalyID;
			PalyaElem palyaElem;
			palyaElemID = Integer.parseInt(cmd[1]);
			if (palyaElemID < 0)
				throw new Exception("A PalyaElemID nem egy pozitív egész szám");
			palyaElem = palya.lekerPalyaElemIDvel(palyaElemID);
			if (palyaElem == null)
				throw new Exception(
						"Az akadály lerakása sikertelen, a PalyaElemID nem létezik.");
			akadalyID = Integer.parseInt(cmd[2]);
			if (akadalyID < 0)
				throw new Exception("Az AkadalyID nem egy pozitív egész szám");
			if (!palyaElem.vanUtja())
				throw new Exception(
						"Az akadály lerakása sikertelen, a PalyaElemID nem Út");
			Ut u = palyaElem.lekerUt();
			if (u.vanAkadalyRajta())
				throw new Exception("Az akadály lerakása sikertelen, a"
						+ palyaElemID + "-n már van egy akadály.");
			u.lerakAkadaly(akadalyID);
			kiir("Az akadály lerakása sikeres " + palyaElemID + "-re"
					+ akadalyID + "-vel");
		} catch (Exception e) {
			kiir(e.getMessage());
		}
	}

	private static void toronyLerak(String[] cmd) {
		try {
			int palyaElemID, toronyID;
			PalyaElem palyaElem;
			palyaElemID = Integer.parseInt(cmd[1]);
			if (palyaElemID < 0)
				throw new Exception("A PalyaElemID nem egy pozitív egész szám");
			palyaElem = palya.lekerPalyaElemIDvel(palyaElemID);
			if (palyaElem == null)
				throw new Exception(
						"A torony lerakása sikertelen, a PalyaElemID nem létezik");
			toronyID = Integer.parseInt(cmd[2]);
			if (toronyID < 0)
				throw new Exception("A ToronyID nem egy pozitív egész szám");
			if (!palyaElem.vanEpitesiTerulete())
				throw new Exception(
						"A torony lerakása sikertelen, a PalyaElemID nem építési terület");
			EpitesiTerulet et = palyaElem.lekerEpitesiTerulet();
			if (et.vanToronyRajta())
				throw new Exception(
						"A torony lerakása sikertelen, a PalyaElemID-n már van egy torony.");
			et.lerakTornyot(toronyID);
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
				if (tmp.vanEpitesiTerulete()) {
					if (tmp.lekerEpitesiTerulet().vanToronyRajta()) {
						Torony t = tmp.lekerEpitesiTerulet().lekerTorony();
						kiir("toronyid " + t.lekerID() + " hatótáv "
								+ t.lekerhatotav() + "palyaelemid "
								+ tmp.lekerID());
					}
				}
			}

		} catch (Exception e) {
			kiir(e.getMessage());
		}
	}

	private static void kilistazutak() {
		try {
			kiir("utak:");
			for (PalyaElem tmp : palya.lekerlista()) {
				if (tmp.vanUtja()) {
					if (tmp.lekerUt().vanAkadalyRajta()) {
						Akadaly t = tmp.lekerUt().lekerAkadaly();
						kiir("akadalyid " + t.lekerID() + " akadalyhp "
								+ t.lekerhp() + "palyaelemid " + tmp.lekerID());
					} else {
						kiir("palyaelemid " + tmp.lekerID());
					}
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
