
public class StringPermutation {

	public StringPermutation() {
		String s = "ABC";
		
		printPermutations(s.toCharArray(), 0, s.length()-1);
		
	}
	private void printPermutations(char a[],int l,int r){
		
		if(l==r){
			System.out.println(String.valueOf(a));
			return;
		}else{
			for(int i=l;i<=r;i++){
				swap(a,l,i);
				printPermutations(a, l+1, r);
				swap(a,l,i);
			}
		}
	}
	
	private void swap(char a[],int l,int r){
		char temp = a[l];
		a[l] = a[r];
		a[r] =temp;
	}
}
