package allelustwillewigkeit.twotowers.skeleton;

public class TeszterClass {

	public static void foo(){
		SkeletonController.tabNo();
		SkeletonController.println("foo says : Ring-ding-ding-ding-dingeringeding");
		
		while(SkeletonController.kerdezIH("What are you going to do? STAB ME?")){
			bar();
		}
		SkeletonController.tabCsokken();
	}
	
	public static void bar(){
		SkeletonController.tabNo();
		SkeletonController.println("bar says : Wa-pa-pa-pa-pa-pa-pow");
		SkeletonController.kerdezLovedek("Kérek egy lövedéket!");
		SkeletonController.tabCsokken();
	}
	
	public static void main(String[] args) {
		SkeletonController.tabNo();
		SkeletonController.println("main says : Joff-tchoff-tchoffo-tchoffo-tchoff");
		foo();
		SkeletonController.tabCsokken();
	}

}
