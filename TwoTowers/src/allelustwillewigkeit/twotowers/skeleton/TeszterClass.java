package allelustwillewigkeit.twotowers.skeleton;

public class TeszterClass {

	public static void foo(){
//		SkeletonController.tabNo();
		while(SkeletonController.kerdezIH("What are you going to do? STAB ME?")){
			bar();
		}
//		SkeletonController.tabCsokken();
	}
	
	public static void bar(){
		SkeletonController.tabNo();
		SkeletonController.println("That wasn't a good idea");
		SkeletonController.tabCsokken();
	}
	
	public static void main(String[] args) {
//		SkeletonController.tabNo();
		foo();
//		SkeletonController.tabCsokken();
		
	}

}
