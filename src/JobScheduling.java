import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * given start and finish time array for n jobs schedule the jobs
 * @author Ankita
 *
 */
public class JobScheduling {
	public JobScheduling() {
		int [] startTime = {1,3,6,2};
		int [] endTime = {2,5,19,100};
		
		ArrayList<Integer> jobList = new ArrayList<>();
		scheduleJobs(startTime, endTime, jobList);
		System.out.println("Normal job scheduling "+jobList.toString());
		
		ArrayList<Job> jobs = new ArrayList<>();
		int endTimeNew [] = {2,5,19,100};
		int [] profit = {50,20,100,200};
		for(int i=0;i<startTime.length;i++){
			Job job = new Job(startTime[i],endTimeNew[i],profit[i]);
			jobs.add(job);
		}
		
		weightedJobScheduling(jobs);
		
	}
	private void scheduleJobs(int [] startTime,int [] endTime, ArrayList<Integer> jobList){
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0;i<startTime.length;i++){
			map.put(endTime[i], startTime[i]);
		}
		Arrays.sort(endTime);
		jobList.add(0);
		int prevFinishTime = endTime[0];
		for(int i=1;i<endTime.length;i++){
			if(map.get(endTime[i])>prevFinishTime){
				jobList.add(i);
				prevFinishTime = endTime[i];
			}
		}
	}
	private void weightedJobScheduling(ArrayList<Job> jobs){
		
		int [] maxProfit = new int[jobs.size()];
		maxProfit[0] = jobs.get(0).profit;
		
		for(int i=1;i<jobs.size();i++){
			
			int index = getNonOverlapingJob(jobs, i);
			int inclProfit = jobs.get(i).profit;
			if(index!=-1){
				inclProfit+= maxProfit[index];
			}
			maxProfit[i]= Math.max(inclProfit, maxProfit[i-1]);
		}
		
		System.out.println("Max profit = "+maxProfit[jobs.size()-1]);
	}
	
	private int getNonOverlapingJob(ArrayList<Job> jobs, int i){
		for(int j=i-1;j>=0;j--){
			if(jobs.get(j).endTime<=jobs.get(i).startTime){
				return j;
			}
		}
		
		return -1;
	}
}
class Job implements Comparable<Job>{
	int startTime;
	int endTime;
	int profit;
	
	public Job(int start,int end,int p) {
		this.startTime = start;
		this.endTime = end;
		this.profit = p;
	}
	
	@Override
	public int compareTo(Job arg0) {
	
		return Integer.compare(this.endTime, arg0.endTime);
	}
}