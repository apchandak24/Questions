
public class RoundRobinScheduling {
	int burst[] = {4,5,6,7};
	int turnArndTime[] = new int[4];
	int tq = 4;
	int cWaiting = 0;

	public RoundRobinScheduling() {
		
		int total = 0;
		for(int i=0;i<burst.length;i++)
			total+=burst[i];
		
		
		scheduleJobs(total);

	}

	private void scheduleJobs(int total) {
		int sum = 0;

		do {
			for (int i = 0; i < burst.length; i++) {
				if (burst[i] > 0) {
					if (burst[i] <= tq) {
						turnArndTime[i] = cWaiting + burst[i];
						cWaiting = turnArndTime[i];
						sum = sum + burst[i];
						burst[i] = 0;
					} else {
						turnArndTime[i] = cWaiting + tq;
						cWaiting = turnArndTime[i];
						sum = sum + tq;
						burst[i]-=tq;
					}

				}

			}

		} while (sum != total);
		sum=0;
		for(int i=0;i<turnArndTime.length;i++){
			sum = sum+turnArndTime[i];
			System.out.print(turnArndTime[i]+" ");
		}
		System.out.println("Average turn around time "+sum/4.0);
	}
}
