import javax.swing.plaf.synth.SynthScrollBarUI;

public class RotationPoint {
	
	public RotationPoint(){
		String [] input = {"ptolemaic",
			    "retrograde",
			    "supplant",
			    "undulate",
			    "xenoepist",
			    "asymptote", 
			    "babka",
			    "banoffee",
			    "engender",
			    "karpatka",
			    "othellolagkage"};
		findRotationPoint(input);
	}

	private void findRotationPoint(String [] input) {
		int start=0;
		int end = input.length-1;
		while(start<=end && input[start].compareTo(input[end])>0 ){
			int mid=(start+end)/2;
			if(input[mid].compareTo(input[end])>0){
				start = mid+1;
			}else
				end = mid;
		}
	
	System.out.println(input[start]);
	}

}
