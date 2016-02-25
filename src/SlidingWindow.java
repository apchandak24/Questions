import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindow {
	
	public SlidingWindow(){
		
		int nums[]={8,6,5,7,2,9,10};
		maxSlidingWindow(nums, 3);
	}
	
	
	private void maxSlidingWindow(int nums[],int k){
		int result[] = new int[nums.length-k+1];

	    Deque<Integer> q = new LinkedList<Integer>();

	    // First of all we will enqueue k elements result in deque.
	    int index = 0;
	    for(index=0;index<k;index++)
	    {
	        // For every element, the previous smaller elements are useless so
	        // remove them from queue.

	        while(!q.isEmpty() && nums[q.getLast()] <= nums[index])
	            q.removeLast();

	        // now push them in queue.
	        q.addLast(index);
	    }


	    int n = nums.length;
	    // now start from k+1 to length n.
	    for(;index<n;index++)
	    {
	        // The element at the front of the queue is the largest element of
	        // previous window, so save in results.
	        result[index-k] = nums[q.getFirst()];

	        // need to remove unnecessary elements, which are now not part of sliding window.

	        while(!q.isEmpty() && q.getFirst() <= (index-k))
	            q.removeFirst();

	        // calculate and insert again for current item as like above we did in for loop.
	        // Remove all elements smaller than the currently
	        // being added element (remove useless elements)   
	        while(!q.isEmpty() && nums[q.getLast()] <= nums[index])
	            q.removeLast();

	        // Add current element at last of queue.
	        q.addLast(index);
	    }

	    // store last window result.
	    result[index-k] = nums[q.getFirst()];
	}

}
