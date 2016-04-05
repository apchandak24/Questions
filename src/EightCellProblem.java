/**
 * There is a colony of 8 cells arranged in a straight line where each day every
 * cell competes with its adjacent cells(neighbor). Each day, for each cell, if
 * its neighbors are both active or both inactive, the cell becomes inactive the
 * next day,. otherwise it becomes active the next day. Assumptions: The two
 * cells on the ends have single adjacent cell, so the other adjacent cell can
 * be assumed to be always inactive. Even after updating the cell state.
 * consider its previous state for updating the state of other cells. Update the
 * cell information of all cells simultaneously. Write a function cellCompete
 * which takes takes one 8 element array of integers cells representing the
 * current state of 8 cells and one integer days representing number of days to
 * simulate. An integer value of 1 represents an active cell and value of 0
 * represents an inactive cell.
 * 
 * INPUT: [1,0,0,0,0,1,0,0],1 EXPECTED RETURN VALUE: [0,1,0,0,1,0,1,0] INPUT:
 * [1,1,1,0,1,1,1,1,],2 EXPECTED RETURN VALUE: [0,0,0,0,0,1,1,0]
 * 
 * @author Ankita
 *
 */
public class EightCellProblem {

	public EightCellProblem() {
		int[] input = { 1, 1, 1, 0, 1, 1, 1, 1 };
		int k = 2;
		cellCompete(input, k);
	}

	private void cellCompete(int[] input, int k) {
		int[] result = new int[input.length];
		
		
		for (int j = 0; j < k; j++) {
			int i = 0;
			int prev = 0;
			int end = 0;
			for (i = 0; i < input.length - 1; i++) {
				result[i] = prev ^ input[i + 1];
				prev = input[i];
			}
			result[i] = input[i] ^ end;
			if (j < k - 1) {
				for (int m = 0; m < result.length; m++) {
					input[m] = result[m];
				}
			} else
				break;
		}
		for (int j = 0; j < result.length; j++)
			System.out.print(result[j] + " ");
	}
}
