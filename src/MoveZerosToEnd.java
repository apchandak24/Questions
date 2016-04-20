/**
 * 
 * @author Ankita
 *
 */

public class MoveZerosToEnd {
	
	public MoveZerosToEnd() {
		
		int a[]={0,0,0,1,51,3,4,6};
		moveZerosToEnd(a);
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
	}
	
	private void moveZerosToEnd(int a[]){
		int start=0;
		int end = a.length-1;
		while(start<end){
			if(a[start]==0){
				int k = findNextNonZero(a, start);
				if(k!=-1)
				swap(a,start, k);
				start++;
			}else if(a[start]==0 && a[end]==0){
				end--;
			}else
				start++;
		}
		
	}
	private void swap(int[]a,int i,int j){
		int temp= a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	private int findNextNonZero(int []a,int j){
		for(int i=j;i<a.length;i++){
			if(a[i]!=0)
				return i;
		}
		return -1;
	}

}
