package allelustwillewigkeit.twotowers.skeleton;

public class TeszterClass {

	public static void foo(){
		SkeletonController.fuggvenyBelep("TeszterClass.foo");
		SkeletonController.println("foo says : Ring-ding-ding-ding-dingeringeding");
		
		while(SkeletonController.kerdezIH("What are you going to do? STAB ME?")){
			bar();
		}
		SkeletonController.fuggvenyKilep("TeszterClass.foo");
	}
	
	public static void bar(){
		SkeletonController.fuggvenyBelep("TeszterClass.bar");
		SkeletonController.println("bar says : Wa-pa-pa-pa-pa-pa-pow");
		SkeletonController.kerdezLovedek("Kérek egy lövedéket!");
		SkeletonController.fuggvenyKilep("TeszterClass.bar");
	}
	
	public static void main(String[] args) {
		SkeletonController.fuggvenyBelep("TeszterClass.main");
		SkeletonController.println("main says : Joff-tchoff-tchoffo-tchoffo-tchoff");
		foo();
		SkeletonController.fuggvenyKilep("TeszterClass.main");
	}

}
