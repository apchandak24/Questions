
public class BinarySearchInfiniteArray {

	public BinarySearchInfiniteArray() {

		int arr[] = { 3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170, 789 };
		int ans = findIndex(arr, 170);
		System.out.println(ans == -1 ? "Element not found " : "Element found at " + ans);
	}

	private int findIndex(int array[], int key) {

		int l = 0;
		int h = 1;
		int val = array[0];
		try {
			while (key > val) {
				l = h;
				h = 2 * h;
				val = array[h];
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			// array is assumed to be of infinite length so we don't need to handle this condition 
			h = array.length;
		}
		return performBinarySearch(l, h, array, key);

	}

	private int performBinarySearch(int l, int h, int[] array, int key) {

		while (l <= h) {
			int mid = (l + h) / 2;
			if (array[mid] == key) {
				return mid;
			} else if (array[mid] > key) {
				h = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return -1;
	}

}
