
public class MaxProductOf3Integers {
	
	public MaxProductOf3Integers() {
		int a[] = {-10,-10,10,3,4};
		findMaxProduct(a);
	}
	
	private void findMaxProduct(int array[]){
		int s=Integer.MIN_VALUE,m=Integer.MIN_VALUE,l=Integer.MIN_VALUE;
		int xs=Integer.MAX_VALUE,xxs=Integer.MAX_VALUE;
		for(int i=0;i<array.length;i++){
			if(l<array[i]){
				s=m;
				m=l;
				l=array[i];
			}else if(m<array[i]){
				s=m;
				m=array[i];
			}else if(s<array[i]){
				s=array[i];
			}
			if(array[i]<xxs){
				xs=xxs;
				xxs=array[i];
			}else if(array[i]<xs){
				xs=array[i];
			}
		}
		System.out.println(s+" "+m+" "+l+" "+xs+" "+xxs);
	}

}
