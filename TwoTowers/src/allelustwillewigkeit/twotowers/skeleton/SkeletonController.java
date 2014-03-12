package allelustwillewigkeit.twotowers.skeleton;

public class SkeletonController {
	private static int tabok = 0;
	public static void tabNo(){
		tabok++;
	}
	public static void tabCsokken(){
		if(tabok < 0) // csak a biztons�g kedv��rt, igaz�b�l nem t�l l�nyeges, a forciklus max nem futna le egyszer sem.
			tabok--;
	}
	private static void kiiro(String mit){ // Forr�scsere eset�re.
		System.out.print(mit);
	}
	
	public static void print(String mit){
		for(int i=0; i!= tabok; i++){
			SkeletonController.kiiro("\t");
		}
		SkeletonController.kiiro(mit);
	}
	public static void println(String mit){
		SkeletonController.print(mit);
		SkeletonController.kiiro("\n");
	}
}
