/**
 * Question: Given an array of positive numbers, find the maximum sum of a
 * subsequence with the constraint that no 2 numbers in the sequence should be
 * adjacent in the array. So 3 2 7 10 should return 13 (sum of 3 and 10) or 3 2
 * 5 10 7 should return 15 (sum of 3, 5 and 7).Answer the question in most
 * efficient way.
 * 
 * @author Ankita
 *
 */
public class MaximumSubarray {

	public MaximumSubarray() {
		int elements[] = {3,200,5,10,7};
		
		System.out.println("Maximum sum is "+getMaximumSubArraySum(elements));
	}

	private int getMaximumSubArraySum(int[] elements) {
		
		if(elements.length==1)
			return elements[0];
		if(elements.length==2){
			return Math.max(elements[0], elements[1]);
		}
		int [] maxSum = new int[elements.length];
		maxSum[0] =elements[0];
		maxSum[1] = elements[1];
		maxSum[2] = elements[2]+elements[0];
		int max = Math.max((Math.max(maxSum[0], maxSum[1])),maxSum[2]);
		for(int i=3;i<elements.length;i++){
			maxSum[i] = Math.max((Math.max(maxSum[i-2],maxSum[i-3])+elements[i]),elements[i]);
			if(maxSum[i]>max)
				max = maxSum[i];
		}

		return max;
	}

}
