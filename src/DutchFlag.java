/**
 * Given a array containing R W and B.Partion it such that all R , W , B are together
 * @author Ankita
 *
 */
public class DutchFlag {

	public DutchFlag() {
		
		//char a[] = {'B','B','R','R','B','W','R','B','W','R','B','W','R', 'W','W','B','R','R', 'B','R'};
		//char a[] = {'B','B','W','W','R','R','B','W'};
		char a[]={'R','R','R','R'};
		partition(a);
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
	}
	
	
	private void partition(char[]input){
		int low = 0;
		int mid=0;
		int high = input.length-1;
		
		while(mid<=high){
			char ch = input[mid];
			switch(ch){
			case 'R':
				swap(input, low, mid);
				mid++;
				low++;
				break;
			case 'W':
				mid++;
				break;
			case 'B':
				swap(input, mid, high);
				high--;
				break;
			}
		}
	}
	private void swap(char [] input,int t1,int t2){
		char temp = input[t1];
		input[t1] = input[t2];
		input[t2] = temp;
	}
}
