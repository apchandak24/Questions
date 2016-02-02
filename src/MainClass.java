import java.util.Stack;

public class MainClass {

	public static void main(String[] args) {
		//findSecondHighestElement();
		//printZigzag();
		getDirectoryPath();
	}

	private static void findSecondHighestElement() {
		int array [] = {2,0,23,473684};
		int h=array[0],sh=h;
		for(int i=1;i<array.length;i++){
			if(array[i]>h){
				sh = h;
				h = array[i];
			}
		}
		System.out.println(sh);
	}
	
	private static void printZigzag(){
		String s = "PAYPALISHIRING";
		int numRows = 3;
		
		 String [] nStr = new String[numRows];
	        int cnt=0;
	        int i=1;
	        int oddEven=0;
	        nStr[0] = s.charAt(0)+"";
	        for(int j=1;j<numRows;j++)
	        	nStr[j]="";
	        while(i<s.length()){
	            if(oddEven%2==0){
	                cnt =1;
	                int limit = numRows;
	                 while(cnt<limit){
	                    if(i==s.length())
	                      break;
	                    nStr[cnt] = nStr[cnt]+s.charAt(i);
	                    cnt++;
	                    i++;
	                   
	                }
	            }else{
	                cnt = numRows-2;
	                int limit = 0;
	                while(cnt>=limit){
	                    if(i==s.length())
	                        break;
	                     nStr[cnt] = nStr[cnt]+s.charAt(i);
	                    cnt--;
	                    i++;
	                    
	                }
	            }
	            oddEven++;
	          
	        }
	        String result = "";
	        for(int j=0;j<nStr.length;j++){
	        	System.out.println(nStr[j]);
	            result = result+nStr[j];
	        }
	       System.out.println(result);
	}
	
private static void getDirectoryPath(){
	String path = "dir1# dir11# dir12#  picture.jpeg#  file.txt#  mew.png#dir2# dir21";
	Stack<Directory> stack = new Stack<>();
	String array[] = path.split("#");
	int len= 0;
	int maxLen =-1;
	for(int i=0;i<array.length;i++){
		
		for(Directory s:stack){
			System.out.println(s.filename+" --- "+s.level+"");
		}
			
		if(!array[i].trim().contains("."))
		{	
			if(stack.isEmpty()){
				len =0;
				int level = array[i].indexOf(array[i].trim());
				len = array[i].trim().length()+1;
				stack.push(new Directory(len, array[i].trim(), level));
			}else{
				int level = array[i].indexOf(array[i].trim());
				len = len+array[i].trim().length()+1;
				Directory ele = stack.peek();
				if(level<=ele.level){
					//ele = stack.pop();
					while(!stack.isEmpty()){
						ele = stack.peek();
						if(level>ele.level)
							break;
						else{
							ele = stack.pop();
							len= len-ele.filename.length()-1;
						}
					}
				}
				stack.push(new Directory(len, array[i].trim(), level));
			}
		}else{
			Directory d = stack.peek();
			int tLen = array[i].trim().length()+d.len+1;
			maxLen = Math.max(tLen, maxLen);
		}
			
	}
	System.out.println(maxLen);
		
		
}
	

}
 class Directory{
	
	public int len;
	public String filename;
	public int level;
	public Directory(int len,String name,int level) {
		this.len = len;
		this.level = level;
		this.filename= name;
	}
	
}

