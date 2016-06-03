public class HeapSort {
	public HeapSort() {
		int a[] = { 1,2, 3, 4, 1, 10, 5, 11 };
		createHeap(a);
		int size = a.length - 1;
		for (int i = 0; i < a.length; i++) {
			swap(a, 0, size);
			size--;
			heapify(a, 0, size);
		}

		 for (int i = 0; i < a.length; i++)
		 System.out.print(a[i] + " ");

	}

	private void swap(int a[], int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	private void createHeap(int a[]) {
		for (int i = (a.length / 2) - 1; i >= 0; i--) {
			heapify(a, i, a.length);
			
		}
	}  

	private void heapify(int a[], int index, int size) {

		int left = 2 * index + 1;
		int right = 2 * index + 2;
		int largeIndex = index;
		if (left < size && a[index] < a[left])
			largeIndex = left;
		if (right < size && a[largeIndex] < a[right])
			largeIndex = right;
		if (largeIndex != index) {
			swap(a, index, largeIndex);
			heapify(a, largeIndex, size);
		}
	}

}
