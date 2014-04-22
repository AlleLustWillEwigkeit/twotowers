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
				kiir("ervenytelen parancs!");
			}
		}

	}

	private static void utOsszekapcsol(String[] cmd) {
		if (palyaszerkeszt) {
			try {
				int egyesID = Integer.parseInt(cmd[1]);
				if (egyesID < 0)
					throw new Exception(
							"Az UtID_Honnan nem egy pozitiv egesz szam.");
				int kettesID = Integer.parseInt(cmd[2]);
				if (kettesID < 0)
					throw new Exception(
							"Az UtID_Hova nem egy pozitiv egesz szam.");
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
					throw new Exception("Nincs ut a PalyaElemID_Honnan-on");
				Ut hova = pe2.lekerUt();
				if (hova == null)
					throw new Exception("Nincs ut a PalyaElemID_Hova-n");
				pe1.addSzomszed(pe2);
				pe2.addSzomszed(pe1);
				honnan.beallitKovUt(hova);
				kiir("A ket ut osszelinkelodott: " + egyesID + "->" + kettesID);
			} catch (Exception e) {
				kiir(e.getMessage());
			}
		} else
			kiir("A palyaszerkesztes nincs bekapcsolva, igy sikertelen. A bekapcsolashoz irdd be, hogy “PalyaSzerkeszt kezd”");

	}

	private static void vegzetHegyeLerak(String[] cmd) {
		if (palyaszerkeszt) {
			try {
				int palyaElemID = Integer.parseInt(cmd[1]);
				if (palyaElemID < 0)
					throw new Exception(
							"A PalyaElemID nem egy pozitiv egesz szam.");
				int vegzetHegyeID = Integer.parseInt(cmd[2]);
				PalyaElem pe = palya.lekerPalyaElemIDvel(palyaElemID);
				if (pe == null)
					throw new Exception("A PalyaElemID nem egy palyaeleme.");
				if (pe.vanUtja())
					throw new Exception(
							"A veg lerakasa sikertelen, mert mar van veg vagy ut vagy start.");
				pe.legyelVegzetHegye(motor, vegzetHegyeID);
				kiir("A vegzet hegyenek lerakasa sikerult, " + palyaElemID
						+ "-re" + vegzetHegyeID + "-vel");
			} catch (Exception e) {
				kiir(e.getMessage());
			}
		} else
			kiir("A palyaszerkesztes nincs bekapcsolva, igy sikertelen. A bekapcsolashoz ird be, hogy “PalyaSzerkeszt kezd”");
	}

	private static void startLerak(String[] cmd) {
		if (palyaszerkeszt) {
			try {
				int palyaElemID = Integer.parseInt(cmd[1]);
				if (palyaElemID < 0)
					throw new Exception(
							"A PalyaElemID nem egy pozitiv egesz szam.");
				int startID = Integer.parseInt(cmd[2]);
				PalyaElem pe = palya.lekerPalyaElemIDvel(palyaElemID);
				if (pe == null)
					throw new Exception("A PalyaElemID nem egy palyaeleme.");
				if (pe.vanUtja())
					throw new Exception(
							"A start lerakasa sikertelen, mert mar van start vagy ut vagy veg.");
				pe.legyelStart(startID);
				start = (Start) pe.lekerUt();
				ellen.beallitKezdohely(start);
				kiir("A start lerakasa sikerult " + palyaElemID + "-re "
						+ startID + "-vel");
			} catch (Exception e) {
				kiir(e.getMessage());
			}
		} else
			kiir("A palyaszerkesztes nincs bekapcsolva, igy sikertelen. A bekapcsolashoz ird be, hogy “PalyaSzerkeszt kezd”");
	}

	private static void utLerak(String[] cmd) {
		if (palyaszerkeszt) {
			try {
				int palyaElemID = Integer.parseInt(cmd[1]);
				if (palyaElemID < 0)
					throw new Exception(
							"A PalyaElemID nem egy pozitiv egesz szam.");
				int utID = Integer.parseInt(cmd[2]);
				PalyaElem pe = palya.lekerPalyaElemIDvel(palyaElemID);
				if (pe == null)
					throw new Exception("A PalyaElemID nem egy palyaeleme.");
				if (pe.vanUtja())
					throw new Exception(
							"Az ut lerakasa sikertelen, mert mar van start vagy ut vagy veg.");

				pe.legyelUt(utID);
				kiir("Az ut lerakasa sikerult " + palyaElemID + "-re" + utID
						+ "-vel");
			} catch (Exception e) {
				kiir(e.getMessage());
			}
		} else
			kiir("A palyaszerkesztes nincs bekapcsolva, igy sikertelen. A bekapcsolashoz ird be, hogy “PalyaSzerkeszt kezd”");
	}

	private static void epitesiTeruletLerak(String[] cmd) {
		if (palyaszerkeszt) {
			try {
				int palyaElemID = Integer.parseInt(cmd[1]);
				if (palyaElemID < 0)
					throw new Exception(
							"A PalyaElemID nem egy pozitiv egesz szam.");
				int etID = Integer.parseInt(cmd[2]);
				PalyaElem pe = palya.lekerPalyaElemIDvel(palyaElemID);
				if (pe == null)
					throw new Exception("A PalyaElemID nem egy palyaeleme.");
				pe.legyelEpitesiTerulet(etID);
				kiir("epitesi terulet letrejott " + palyaElemID + "-re " + etID
						+ "-vel");
			} catch (Exception e) {
				kiir(e.getMessage());
			}
		} else {
			kiir("A palyaszerkesztes nincs bekapcsolva, igy sikertelen. A bekapcsolashoz ird be, hogy “PalyaSzerkeszt kezd”");
		}
	}

	private static void palyaElemOsszekapcsol(String[] cmd) {
		if (palyaszerkeszt) {
			try {
				int egyesID = Integer.parseInt(cmd[1]);
				if (egyesID < 0)
					throw new Exception(
							"Az adott PalyaElemID1 nem egy pozitiv egesz szam.");
				int kettesID = Integer.parseInt(cmd[2]);
				if (kettesID < 0)
					throw new Exception(
							"Az adott PalyaElemID2 nem egy pozitiv egesz szam.");
				PalyaElem pe1 = palya.lekerPalyaElemIDvel(egyesID);
				if (pe1 == null)
					throw new Exception("A PalyaElemID1 nem egy PalyaElemID");
				PalyaElem pe2 = palya.lekerPalyaElemIDvel(kettesID);
				if (pe2 == null)
					throw new Exception("A PalyaElemID2 nem egy PalyaElemID");
				pe1.addSzomszed(pe2);
				pe2.addSzomszed(pe1);
				kiir("A ket palyaelem osszelinkelodott " + egyesID + "<->"
						+ kettesID);
			} catch (Exception e) {
				kiir(e.getMessage());
			}
		} else
			kiir("A palyaszerkesztes nincs bekapcsolva, igy sikertelen. A bekapcsolashoz ird be, hogy “PalyaSzerkeszt kezd”");
	}

	private static void palyaElemKeszit(String[] cmd) {
		if (palyaszerkeszt) {
			try {
				int palyaElemID = Integer.parseInt(cmd[1]);
				if (palyaElemID < 0)
					throw new Exception(
							"Az adott PalyaElemID nem egy pozitiv egesz szam.");
				PalyaElem pe1 = palya.lekerPalyaElemIDvel(palyaElemID);
				if (pe1 == null) {
					PalyaElem pe = new PalyaElem(palyaElemID);
					palya.hozzaAdPalyahoz(pe);
					kiir("A palyaelem elkeszult " + palyaElemID + "-vel");
				} else {
					throw new Exception("Az adott PalyaElemID mar foglalt.");
				}
			} catch (Exception e) {
				kiir(e.getMessage());
			}
		} else
			kiir("A palyaszerkesztes nincs bekapcsolva, igy sikertelen. A bekapcsolashoz ird be, hogy 'PalyaSzerkeszt kezd'");
	}

	private static void palyaSzerkeszt(String[] cmd) {
		try {
			String muvelet = cmd[1];
			switch (muvelet) {
			case "KEZD":
				palyaszerkeszt = true;
				kiir("A palyaszerkesztes megkezdodott");
				break;
			case "VEG":
				palyaszerkeszt = false;
				kiir("A palyaszerkesztes befejezodott");
				break;
			default:
				kiir("ervenytelen parameter");
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
			motor = new Jatekmotor(null, szaruman, palya, program);
			ellen = new Ellensegek(motor, 1000, start, szaruman);
			motor.beallitellen(ellen);
			palyaszerkeszt = false;
			random = false;
			fileba = false;
			kiir("A reset sikerult.");
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
					kiir("Gyozelem");
					break;
				case -666:
					kiir("Vereseg");
					break;
				default:
					System.out
							.println("FAILSAFE: Gaz van, ilyet nem kene latnod!");
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
				kiir("ervenytelen parameter!");
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
						"A megadott parameter nem egy pozitiv egesz szam.");
			PalyaElem pe = palya.lekerPalyaElemIDvel(palyaElemID);
			if (pe == null)
				throw new Exception("A megadott parameter nem egy PalyaElemID.");
			EpitesiTerulet e = pe.lekerEpitesiTerulet();
			Torony t = e.lekerTorony();
			t.elkodosit();
			kiir("A torony elkodositese sikeres " + palyaElemID + "-en.");
		} catch (Exception e) {
			kiir(e.getMessage());
		}
	}

	private static void lekerHanyEllensegVanMeg(String[] cmd) {
		try {
			kiir(ellen.lekerHanyEllensegVanMeg()
					+ "db ellenseg spawnolhato meg");
		} catch (Exception e) {
			kiir(e.getMessage());
		}
	}

	private static void allitHanyEllensegVanMeg(String[] cmd) {
		try {
			int ertek = Integer.parseInt(cmd[1]);
			if (ertek < 0)
				throw new Exception(
						"A megadott parameter nem egy pozitiv egesz szam.");
			ellen.allitHanyEllensegVanMeg(ertek);
			kiir(ertek + "db ellenseg spawnolasi hatar bealltasa sikeres.");
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
						"A megadott parameter nem egy pozitiv egesz szam.");
			while (hanyszor != 0) {
				hanyszor--;
				motor.tick();
			}
			kiir(tmp + " lepes megtortent");
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
					kiir(" akadalyid " + u.lekerAkadaly().lekerID());
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
						"a megadott intDarab parameter nem egy pozitiv egesz szam.");
			int kezdo = Integer.parseInt(cmd[3]);
			if (kezdo < 0)
				throw new Exception(
						"a megadott kezdoID parameter nem egy pozitiv egesz szam.");

			for (int i = 0; i < darab; i++) {
				Torp e = new Torp(start, ellen, szint, kezdo);
				kezdo++;
				ellen.beallitKezdohely(start);
				ellen.inditEllenseg(e);
				kiir(darab + "ellenseg elkeszult!");
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
						"a megadott intDarab parameter nem egy pozitiv egesz szam.");
			int kezdo = Integer.parseInt(cmd[3]);
			if (kezdo < 0)
				throw new Exception(
						"a megadott kezdoID parameter nem egy pozitiv egesz szam.");

			for (int i = 0; i < darab; i++) {
				Elf e = new Elf(start, ellen, szint, kezdo);
				kezdo++;
				ellen.beallitKezdohely(start);
				ellen.inditEllenseg(e);
				kiir(darab + "ellenseg elkeszult!");
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
						"a megadott intDarab parameter nem egy pozitiv egesz szam.");
			int kezdo = Integer.parseInt(cmd[3]);
			if (kezdo < 0)
				throw new Exception(
						"a megadott kezdoID parameter nem egy pozitiv egesz szam.");

			for (int i = 0; i < darab; i++) {
				Hobbit e = new Hobbit(start, ellen, szint, kezdo);
				kezdo++;
				ellen.beallitKezdohely(start);
				ellen.inditEllenseg(e);
				kiir(darab + "ellenseg elkeszult!");
			}
		} catch (Exception e) {
			kiir(e.getMessage());
		}
	}

	private static void emberIndit(String[] cmd) {
		try {
			int szint = Integer.parseInt(cmd[1]);
			int darab = Integer.parseInt(cmd[2]);
			if (darab <= 0)
				throw new Exception(
						"a megadott intDarab parameter nem egy pozitiv egesz szam.");
			int kezdo = Integer.parseInt(cmd[3]);
			if (kezdo < 0)
				throw new Exception(
						"a megadott kezdoID parameter nem egy pozitiv egesz szam.");

			for (int i = 0; i < darab; i++) {
				Ember e = new Ember(start, ellen, szint, kezdo);
				kezdo++;
				ellen.beallitKezdohely(start);
				ellen.inditEllenseg(e);
				kiir(darab + " ellenseg elkeszult!");
			}
		} catch (Exception e) {
			kiir(e.getMessage());
		}
	}

	/*
	 * private static void hullamIndit(String[] cmd) { try {// FIXME int szint =
	 * Integer.parseInt(cmd[1]); int darab = Integer.parseInt(cmd[2]); int id =
	 * Integer.parseInt(cmd[3]); // TODO DOKUMENTaCIo CHECK if (random) { for
	 * (int i = 0; i != darab; i++) { int tipus = (int) (Math.random() * 4);
	 * switch (tipus) { case 0: ellen.inditEllenseg(new Ember(start, ellen,
	 * szint, id++)); break; case 1: ellen.inditEllenseg(new Torp(start, ellen,
	 * szint, id++)); break; case 2: ellen.inditEllenseg(new Hobbit(start,
	 * ellen, szint, id++)); break; case 3: ellen.inditEllenseg(new Elf(start,
	 * ellen, szint, id++)); break; } }
	 * 
	 * } else { // if nem random for (int i = 0; i != darab; i++)
	 * ellen.inditEllenseg(new Ember(start, ellen, 1, id++));
	 * 
	 * } } catch (Exception e) { kiir(e.getMessage()); } }
	 */

	public static void hullamIndit(String[] cmd) {
		int szint = Integer.parseInt(cmd[1]);
		int id = Integer.parseInt(cmd[2]);
		final int[][] konstansok = new int[][] { { 0, 0, 1, 0 },
				{ 1, 0, 1, 0 }, { 2, 1, 2, 1 }, { 3, 2, 3, 2 }, { 4, 3, 5, 4 } };

		if (!random) {
			try {
				kiir("Egy szint szerinti hullam elindult");

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
			} catch (Exception e) {
			}
		} else {
			Random rnd = new Random();
			kiir("Egy veletlen hullam elindult");

			try {
				for (int i = rnd.nextInt(5); i != 0; i--) {
					ellen.inditEllenseg(new Ember(start, ellen, 1, id++));
				}
				for (int i = rnd.nextInt(5); i != 0; i--) {
					ellen.inditEllenseg(new Torp(start, ellen, 1, id++));
				}
				for (int i = rnd.nextInt(5); i != 0; i--) {
					ellen.inditEllenseg(new Hobbit(start, ellen, 1, id++));
				}
				for (int i = rnd.nextInt(5); i != 0; i--) {
					ellen.inditEllenseg(new Elf(start, ellen, 1, id++));
				}
			} catch (Exception e) {
			}
		}
	}

	private static void hullamOsszetetelRandom(String[] cmd) {
		try {
			String muvelet = cmd[1];
			switch (muvelet) {
			case "KI":
				random = false;
				kiir("Az osszetetel az elore definialt szinteknek megfelelo");
				break;
			case "BE":
				random = true;
				kiir("Az osszetetel veletlenszeru");
				break;
			default:
				kiir("ervenytelen parameter");
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
				kiir("palyaelemid: " + tmp.lekerID());
				if (tmp.vanEpitesiTerulete()) {
					if (tmp.lekerEpitesiTerulet().vanToronyRajta()) {
						e = tmp.lekerEpitesiTerulet();
						Torony t = e.lekerTorony();
						for (Varazsko v : t.lekerVarazskovek()) {
							kiir("palyaelemid: " + tmp.lekerID()
									+ " parentToronyid " + t.lekerID()
									+ " varazskoid: " + v.lekerID()
									+ " duration: " + v.lekerDuration());
						}
					}
				}
				if (tmp.vanUtja()) {
					if (tmp.lekerUt().vanAkadalyRajta()) {
						a = tmp.lekerUt().lekerAkadaly();
						if (!a.lekerVarazskovek().isEmpty()) {
							for (Varazsko v : a.lekerVarazskovek()) {
								kiir("palyaelemid: " + tmp.lekerID()
										+ " parentAkadalyid " + a.lekerID()
										+ " varazskoid: " + v.lekerID()
										+ " duration: " + v.lekerDuration());
							}
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
						"A varazsko lerakasa sikertelen, a PalyaElemID nem letezik.");
			varazskodictID = Integer.parseInt(cmd[2]);
			if (varazskodictID < 0)
				throw new Exception("A VarazskoDictID: " + cmd[2] + " hibas");
			varazskoID = Integer.parseInt(cmd[3]);
			if (varazskoID < 0)
				throw new Exception("A VarazskoID: " + cmd[3] + " hibas.");
			if (!palyaElem.vanEpitesiTerulete()) {
				if (!palyaElem.vanUtja()) {
					throw new Exception(
							"A varazsko lerakasa sikertelen, a PalyaElemID nem epitesi terulet toronnyal, es nem ut akadallyal.");
				}
				Ut u = palyaElem.lekerUt();
				if (!u.vanAkadalyRajta()) {
					throw new Exception(
							"A varazsko lerakasa sikertelen, a PalyaElemID nem epitesi terulet toronnyal, es nem ut akadallyal.");
				}
				u.lekerAkadaly().felkovez(
						new Varazsko(varazskodictID, varazskoID));
			} else {
				EpitesiTerulet et = palyaElem.lekerEpitesiTerulet();
				if (!et.vanToronyRajta()) {
					throw new Exception(
							"A varazsko lerakasa sikertelen, a PalyaElemID nem epitesi terulet toronnyal, es nem ut akadallyal.");
				}
				et.lekerTorony().felkovez(
						new Varazsko(varazskodictID, varazskoID));
				kiir("A varazsko lerakasa sikeres " + palyaElemID + "-re "
						+ varazskoID + "-vel");
			}
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
				throw new Exception("A PalyaElemID nem egy pozitiv egesz szam");
			palyaElem = palya.lekerPalyaElemIDvel(palyaElemID);
			if (palyaElem == null)
				throw new Exception(
						"Az akadaly lerakasa sikertelen, a PalyaElemID nem letezik.");
			akadalyID = Integer.parseInt(cmd[2]);
			if (akadalyID < 0)
				throw new Exception("Az AkadalyID nem egy pozitiv egesz szam");
			if (!palyaElem.vanUtja())
				throw new Exception(
						"Az akadaly lerakasa sikertelen, a PalyaElemID nem ut");
			Ut u = palyaElem.lekerUt();
			if (u.vanAkadalyRajta())
				throw new Exception("Az akadaly lerakasa sikertelen, a"
						+ palyaElemID + "-n mar van egy akadaly.");
			u.lerakAkadaly(akadalyID);
			kiir("Az akadaly lerakasa sikeres " + palyaElemID + "-re"
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
				throw new Exception("A PalyaElemID nem egy pozitiv egesz szam");
			palyaElem = palya.lekerPalyaElemIDvel(palyaElemID);
			if (palyaElem == null)
				throw new Exception(
						"A torony lerakasa sikertelen, a PalyaElemID nem letezik");
			toronyID = Integer.parseInt(cmd[2]);
			if (toronyID < 0)
				throw new Exception("A ToronyID nem egy pozitiv egesz szam");
			if (!palyaElem.vanEpitesiTerulete())
				throw new Exception(
						"A torony lerakasa sikertelen, a PalyaElemID nem epitesi terulet");
			EpitesiTerulet et = palyaElem.lekerEpitesiTerulet();
			if (et.vanToronyRajta())
				throw new Exception(
						"A torony lerakasa sikertelen, a PalyaElemID-n mar van egy torony.");
			et.lerakTornyot(toronyID);
			kiir("A torony lerakasa sikeres " + palyaElemID + "-re " + toronyID
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
			kiir("Az [utvonal] helyre a naplozas megkezdodott.");
		} catch (Exception e) {
			kiir("Az [utvonal] helyre kezdodo naplozas sikertelen (valoszinuleg nincs jogosultsaga a szoftvernek oda irnia)");
		}
	}

	private static void betoltUtasitasok(String[] cmd) {

		String utvonal = cmd[1];
		try {
			File f1 = new File(utvonal);

			BufferedReader br = new BufferedReader(new FileReader(f1));
			String s;
			kiir("A fajl betoltese sikeres");
			while ((s = br.readLine()) != null) {
				ertelmez(s);
			}
			br.close();
		} catch (Exception e) {
			kiir("A fajl betoltese sikertelen. (Valoszinuleg A fajl nem talalhato, vagy nincs olvasasi jog.) ");
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
						kiir("toronyid " + t.lekerID() + " hatotav "
								+ t.lekerhatotav() + " palyaelemid "
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
