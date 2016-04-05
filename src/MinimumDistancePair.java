import java.util.ArrayList;
import java.util.Arrays;

public class MinimumDistancePair {
	
	public MinimumDistancePair() {
		int [] input = {-20, -3916237, -357920, -3620601, 7374819, -7330761, 30, 6246457, -6461594, 266854};
		
		findMinimumDistancePairs(input);
	}

	private void findMinimumDistancePairs(int array[]) {
		int max = array[0];
		int dist = Math.abs(array[1]-array[0]);
		ArrayList<Integer> result  = new ArrayList<>();
		int j=0;
		for(int i=1;i<array.length;i++){
			
			int cdist = Math.abs(array[i]-max);
			if(cdist==dist){
				result.add(array[j]);
				result.add(array[i]);
			}
			else if(cdist<dist){
				result = new ArrayList<>();
				result.add(array[j]);
				result.add(array[i]);
				
				dist= cdist;
			}
			if(max>=array[i]){
				max = array[i];
				j=i;
			}
		}
		
		System.out.println(result.toString());
	}
	

}
