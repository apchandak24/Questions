public class InheritanceTest {

	public static void main(String[] args) {
		Parent p = new child();
		System.out.println(Parent.x);
		System.out.println(tryCatchTest());
		
	}
	private static int tryCatchTest(){
		try{
			return 0;
		}finally{
			System.out.println("hello");
		}
	}
}
