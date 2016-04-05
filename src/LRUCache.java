import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class LRUCache {

	
	public LRUCache() {
		//int []array = {2,3,1,3,2,1,4,3,2};
		int []array = {2,3,3,3,3,1,4,3,2,3};
		int capacity = 2;
		System.out.println("Number of misses "+getCacheMisses(array,capacity));
	}
	
	private int getCacheMisses(int array[],int capacity){
		int missCount =0;
		Queue<Integer> queue = new LinkedList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		
		
		for(int i=0;i<array.length;i++){
			if(!map.containsKey(array[i])){
				missCount++;
				if(map.size()==capacity){
					int val = queue.remove();
					System.out.println("removing --- "+val);
					map.remove(val);
				}
				queue.add(array[i]);
				map.put(array[i], array[i]);
			}else{
				queue.remove(array[i]);
				queue.add(array[i]);
			}
		}
		
		return missCount;
	}
}
