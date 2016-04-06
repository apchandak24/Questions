import java.util.Random;

public class ShuffleArray {
	
	public ShuffleArray() {
		int a[]={1,5,4,2,8,7,11,10};
		shuffleArrayElements(a);
	}
	
	private void shuffleArrayElements(int [] array){
		Random random= new Random();
		
		for(int i=0;i<array.length;i++){
			int n = random.nextInt(array.length);
			int temp = array[i];
			array[i] = array[n];
			array[n] = temp;
		}
		
		System.out.println("shuffled array"+array.toString());
		for(int i=0;i<array.length;i++)
			System.out.print(array[i]+" ");
		
	}
	

}
