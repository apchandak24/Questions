import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestJobFirst {
	
		int[] startTimes = { 0,55,60 };
		int[] Durations = { 3,2,1};
	
		public ShortestJobFirst() {
			// int[] startTime = { 0, 2, 4, 20, 20, 20 };
						// int[] Durations = { 4, 7, 1, 4, 3, 5 };
						// int[] startTime = { 1, 1, 1, 3 };
						// int[] Durations = { 4, 7, 1, 8 };
						// int[] startTime = { 0, 2, 5, 7 };
						// int[] Durations = { 4, 1, 2, 3 };
						// int[] startTime = { 2, 2, 2 };
						// int[] Durations = { 4, 4, 4 };
						// int[] startTime = { 2, 2, 2, 20, 20, 20 };
						// int[] Durations = { 4, 7, 1, 4, 3, 5 };
						// int[] startTime = { 0, 2, 4, 20, 25, 26 };
						// int[] Durations = { 4, 7, 1, 4, 1, 5 };
						// int[] startTime = { 0, 3 };
						// int[] Durations = { 4, 5 };
						// int[] startTime = { 3, 3 };
						// int[] Durations = { 4, 5 };
						
						float result = doSJF();
						System.out.println(result);
		}
		private float doSJF(){
			int timer = 0;

			// Variable to check if it is first process or not
			int flag = -1;

			// Stores the process ids of similar start times
			List<Integer> tempList = new ArrayList<Integer>();
			// TODO Auto-generated constructor stub
		
			Queue<Integer> proc = new LinkedList<Integer>();

			// Waiting Queue
			List<Integer> waiting = new ArrayList<Integer>();

			// Total waiting time
			int waitingTime = 0;

			// Add the indices of all the processes in a queue
			for (int i = 0; i < startTimes.length; i++) {
				proc.add(i);
			}

			// If the initial processes arrive at the same time as the first
			// process, then
			// mark the indecies of all process with equal time into a temporary
			// list. This
			// list will be used to fetch the next process in queue.
			for (int j = 0; j < startTimes.length - 1; j++) {
				if (startTimes[j] == startTimes[j + 1]) {
					if (!tempList.contains(j))
						tempList.add(new Integer(j));
					tempList.add(new Integer(j + 1));
				} else {
					break;
				}
			}

			if (!tempList.isEmpty()) {
				int shortestIndex = getShortestJob(tempList, startTimes, Durations);

				// Process has been processed so remove it from the temporary holder
				tempList.remove(new Integer(shortestIndex));

				// Time is continuous entity. So to reflect that we initialize the
				// timer to be the
				// time it took for the first process to run.
				timer = startTimes[shortestIndex];

				// First process is running, hence put rest of the process that is
				// not currently
				// running in waiting queue.
				for (Integer each : tempList) {
					proc.remove(new Integer(each));
					waiting.add(new Integer(each));
				}
			}
			tempList.clear();

			while (!proc.isEmpty() || !waiting.isEmpty()) {

				if (flag == -1) {
					// Current time plus the duration of the ONLY first process
					timer = startTimes[0];
					timer = timer + Durations[proc.remove()];
					flag = 0;
				}

				// Add all the process to the waiting list whose start time is less
				// the timer
				while (proc.peek() != null && startTimes[proc.peek()] <= timer) {
					waiting.add(proc.remove());
				}

				/*
				 * When waiting queue is empty and Processes queue is not empty.
				 * When we face this scenario, the we have to take into
				 * consideration the case when two processes arrive at the same
				 * time. CPU is free as nothing in the waiting queue, but process
				 * are present in the list to be processed. This is similar to
				 * starting for loop
				 */
				if (!proc.isEmpty() && waiting.isEmpty()) {
					int top = proc.peek();
					for (int j = top; j < startTimes.length - 1; j++) {
						if (startTimes[j] == startTimes[j + 1]) {
							// Similar bug as above
							if (!tempList.contains(j))
								tempList.add(new Integer(j));
							tempList.add(new Integer(j + 1));
						} else {
							break;
						}
					}

					if (!tempList.isEmpty()) {
						int shortestIndex = getShortestJob(tempList, startTimes, Durations);
						tempList.remove(new Integer(shortestIndex));
						// Fourth Bug: this happens when jobs arrive at same time
						// not initially. We need to
						// maintain the timer and execute off the first one
						// timer = startTimes[shortestIndex];
						// timer = timer + Durations[shortestIndex];
						// proc.remove(shortestIndex);
						for (Integer each : tempList) {
							proc.remove(new Integer(each));
							waiting.add(new Integer(each));
						}
					}
					// fifth bug: not in code
					int temp = proc.remove();
					timer = startTimes[temp];
					timer = timer + Durations[temp];

				}

				// get the index of the shortest job index
				if (!waiting.isEmpty()) {
					int shortestJobIndex = getShortestJob(waiting, startTimes, Durations);
					waiting.remove(new Integer(shortestJobIndex));

					// waiting time of current process is current time - arrival
					// time of the process
					waitingTime = waitingTime + (timer - startTimes[shortestJobIndex]);
					timer = timer + Durations[shortestJobIndex];
				}
			}
			return (float) waitingTime / startTimes.length;
		}

		// Returns an index of a process with smallest running time.
		private  int getShortestJob(List<Integer> waiting, int[] startTimes, int[] Durations) {
			int min = waiting.get(0);
			for (int each : waiting) {
				if (Durations[min] > Durations[each]) {
					min = each;
				}
			}
			return min;
		}

			

}
