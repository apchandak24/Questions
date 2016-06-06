import java.util.LinkedList;
import java.util.Queue;

public class RoundRobin {
	int startTime[]={0,0,6,7,8,150,151};
	int duration[]={16,10,4,6,10,15,5};
	int sliceTime=5;

	RoundRobin() {
		//doRoundRobin();
		doRoundRobin2();
	}

	public float doRoundRobin() {
		int avgWaitingTime = 0;
		int timer = 0;
		boolean firstTime = true;
		int remainingProcess = -1;

		Queue<Integer> process = new LinkedList<Integer>();
		Queue<Integer> waiting = new LinkedList<Integer>();

		for (int i = 0; i < startTime.length; i++) {
			process.add(i);
		}
		while(!process.isEmpty() || !waiting.isEmpty()){
			if(firstTime){
				int fProcess = process.remove();
				if(duration[fProcess]<=sliceTime){
					timer = timer+duration[fProcess];
				}else{
					timer = timer+sliceTime;
					duration[fProcess] = duration[fProcess] - sliceTime;
					startTime[fProcess] = timer;
					remainingProcess = fProcess;
				}
				firstTime=false;
			}
			while(process.peek()!=null && startTime[process.peek()]<=timer){
				waiting.add(process.remove());
			}
			if(remainingProcess!=-1){
				waiting.add(remainingProcess);
				remainingProcess = -1;
			}
			if(!process.isEmpty() && waiting.isEmpty()){
				int jobIndex = process.remove();
				timer = startTime[jobIndex];
				if(duration[jobIndex]<=sliceTime){
					timer =  timer+duration[jobIndex];
				}else{
					timer = timer+sliceTime;
					duration[jobIndex] = duration[jobIndex]-sliceTime;
					startTime[jobIndex]=timer;
					waiting.add(jobIndex);
				}
			}
			
			if(!waiting.isEmpty()){
				int wProcess = waiting.remove();
				avgWaitingTime =avgWaitingTime+timer-startTime[wProcess];
				if(duration[wProcess]<=sliceTime){
					timer=timer+duration[wProcess];
				}else{
					timer = timer+sliceTime;
					duration[wProcess] = duration[wProcess]-sliceTime;
					startTime[wProcess] = timer;
					remainingProcess = wProcess;
				}
			}
			
			
				
		}
		
		
		System.out.println(avgWaitingTime);
		return (float) avgWaitingTime / startTime.length;
	}
	public float doRoundRobin2(){
		int avgWaitingTime = 0;
		int timer = 0;
		int flag = -1;
		int hold = -1;
		
		Queue<Integer> proc = new LinkedList<Integer>();
		Queue<Integer> waiting = new LinkedList<Integer>();
		
		for(int i = 0; i < startTime.length; i++){
			proc.add(i);
		}
		
		while(!proc.isEmpty() || !waiting.isEmpty()){
			if(flag == -1){
				int firstProc = proc.remove();
				if(duration[firstProc] <= sliceTime){
					timer = timer + duration[firstProc];
				}else{
					timer = timer + sliceTime;
					duration[firstProc] = duration[firstProc] - sliceTime;
					startTime[firstProc] = timer;
					hold = firstProc;
				}
				flag = 0;
			}

			//Add all the process to the waiting list whose start time is less the timer
			while(proc.peek() != null && startTime[proc.peek()] <= timer){
				waiting.add(proc.remove());
			}
			
			if(hold != -1){
				waiting.add(hold);
				hold = -1;
			}
			
			//When there are no processes in the waiting list.
			if(!proc.isEmpty() && waiting.isEmpty()){
				int temp = proc.remove();
				timer = startTime[temp];
				if(duration[temp] <= sliceTime){
					timer = timer + duration[temp];
				}else{
					timer = timer + sliceTime;
					duration[temp] = duration[temp] - sliceTime;
					startTime[temp] = timer;
					waiting.add(temp);
				}
			}

			//get the index of the shortest job index
			if(!waiting.isEmpty()){				
				int JobIndex = waiting.remove();
				if(duration[JobIndex] <= sliceTime){
					avgWaitingTime = avgWaitingTime+ (timer  - startTime[JobIndex]);
					timer = timer + duration[JobIndex];
				}else{
					avgWaitingTime = avgWaitingTime+ (timer  - startTime[JobIndex]);
					timer = timer + sliceTime;
					duration[JobIndex] = duration[JobIndex] - sliceTime;
					startTime[JobIndex] = timer;
					hold = JobIndex;
				}
			}
		}
		
		System.out.println(avgWaitingTime);
		return (float)avgWaitingTime/startTime.length;
	}


}
