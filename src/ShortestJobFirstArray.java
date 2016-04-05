
public class ShortestJobFirstArray {
	int n = 3;
	int[] burst = {};
	int[] arrival = {};

	public ShortestJobFirstArray() {
		SJFScheduling();
	}

	private void SJFScheduling() {

		int at[] = { 0, 55, 60 };
		int bt[] = { 3, 2, 1 };
		int tbt = 0;
		for (int i = 0; i < bt.length; i++) {
			tbt += bt[i];
		}
		int bt2[] = { 3, 2, 1 };
		int wt[] = new int[n];
		int q2 = -1;
		for (int i = 0; i <= 60; i++) {

			int q = Min(bt, at, tbt, i, n);
			if (q!=-1) {
				if (q != q2) {
					wt[q] = i - (bt2[q] - bt[q]);
				}
				bt[q] = bt[q] - 1;
				q2 = q;
			}
		}
		int tWaitingTime = 0, tTurnArndTime = 0;
		for (int i = 0; i < wt.length; i++) {
			int wait = wt[i] - at[i];
			tWaitingTime += wait;
			tTurnArndTime += (wait + bt2[i]);
			System.out.print(wt[i] - at[i] + " ");
		}
		System.out.println("\nAvg wait time = " + (double) tWaitingTime / n + " \nAvg turn around time = "
				+ (double) tTurnArndTime / n);

	}

	public int Min(int b[], int a[], int tbt, int r, int n) {
		int j = -1;
		int min = tbt;
		for (int i = n - 1; i >= 0; i--) {
			if (b[i] < min && b[i] > 0 && r >= a[i]) {
				min = b[i];
				j = i;
			}
		}
		return j;
	}
}
