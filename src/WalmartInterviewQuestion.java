import java.util.ArrayList;

public class WalmartInterviewQuestion {
	
public WalmartInterviewQuestion() {
	// TODO Auto-generated constructor stub
	reverseString("hello");
	sumOfPrimeNumber();
}
	
private void reverseString(String s){
	
	StringBuilder str = new StringBuilder();
	
	for(int i=s.length()-1;i>=0;i--){
		str.append(s.charAt(i));
	}
	System.out.println(str.toString());
	

	
}	
private void sumOfPrimeNumber(){
	
	ArrayList<Integer> nums = new ArrayList<>();
	int num = 2;
	nums.add(num);
	num++;
	int sum =2;
	while(nums.size()<10){
		
		if(checkIfPrime(num)){
			sum = sum + num;
			nums.add(num);
			System.out.print(num+" ");
		}
		num++;
	}
	
	System.out.println(sum);
	
	
}
private boolean checkIfPrime(int n){
	for(int i=2;i<n;i++){
		if(n%i==0)
			return false;
	}
	return true;
	
}


}
