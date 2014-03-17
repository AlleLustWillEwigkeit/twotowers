package allelustwillewigkeit.twotowers.skeleton;

public class TeszterClass {

	public static void foo(){
		SkeletonController.tabNo();
		SkeletonController.println("foo");
		while(SkeletonController.kerdezIH("What are you going to do? STAB ME?")){
			bar();
			
		}
		SkeletonController.tabCsokken();
	}
	
	public static void bar(){
		SkeletonController.tabNo();
		SkeletonController.println("bar");
		SkeletonController.kerdezLovedek("Kérek egy lövedéket!");
		SkeletonController.tabCsokken();
	}
	
	public static void main(String[] args) {
		SkeletonController.tabNo();
		SkeletonController.println("main");
		foo();
		SkeletonController.tabCsokken();
		
	}

}
