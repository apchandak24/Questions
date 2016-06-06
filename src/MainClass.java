import java.util.HashMap;
import java.util.Stack;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainClass {

	public static void main(String[] args) {
		// findSecondHighestElement();
		// printZigzag();
		// getDirectoryPath();
		// getMaxAreaRectangle();
		// minimumNumberOfReversals();
		// Trie trie = new Trie();
		// trie.insert("abbcd");
		// trie.insert("abe");
		// trie.search("bcd");
		// findSecondHighestElement();
		// printZigzag();
		// getDirectoryPath();
		// Graph graph = new Graph();
		// HeapSort sort = new HeapSort();
		// RoundRobinScheduling robinScheduling = new RoundRobinScheduling();
		// ShortestJobFirst sj = new ShortestJobFirst();
		// ShortestJobFirstArray sjf = new ShortestJobFirstArray();
		// MinimumDistancePair pair = new MinimumDistancePair();
		// RotationPoint point = new RotationPoint();
		// MaxProductOf3Integers max = new MaxProductOf3Integers();
		// MatrixRotation rotation =new MatrixRotation();
		// MouseInMaze m = new MouseInMaze();
		// new DutchFlag();
		// new KClosestPoints();
		// new LRUCache();
		// new VerticalOrderTraversalTree();
		// new MinMaxPathSumTree();
		// new JobScheduling();
		// new EightCellProblem();
		// new BinarySearchInfiniteArray();
		// new ShuffleArray();
//		MyThread a = new MyThread();
//		Thread t1 = new Thread(new Runnable() {
//
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//
//			}
//		});
//		Thread t2 = new Thread(a);
//		
//		t1.start();
//		t2.start();
//
//		// new MaximumSubarray();
//		try {
//			callableExample();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ExecutionException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		//new DeleteNode();
		//new MoveZerosToEnd();
		//new StringPermutation();
		//new RoundRobin();
		//new ShortestJobFirst();
		
		new InsertIntoCircularLinkedList();
		
	}

	private static void callableExample() throws InterruptedException, ExecutionException{
		  ExecutorService es = Executors.newSingleThreadExecutor(); 
		 System.out.println("submitted callable task to calculate factorial of 10");
		 Future result10 = es.submit(new CallableInterface(10)); 
		 System.out.println("submitted callable task to calculate factorial of 15"); 
		 Future result15 = es.submit(new CallableInterface(15)); 
		 System.out.println("submitted callable task to calculate factorial of 20"); 
		 Future result20 = es.submit(new CallableInterface(20)); 
		 
		 if(result20.isDone()){
		 System.out.println("Calling get method of Future to get result of factorial 20");
		 long factorialof20 = (long) result20.get(); 
		 System.out.println("factorial of 20 is : " + factorialof20); 
		 }
		 System.out.println("Calling get method of Future to fetch result of factorial 10"); 
		 long factorialof10 = (long) result10.get(); 
		 System.out.println("factorial of 10 is : " + factorialof10);
		 System.out.println("Calling get method of Future to get result of factorial 15"); 
		 long factorialof15 = (long) result15.get(); 
		 System.out.println("factorial of 15 is : " + factorialof15); 
		

		 
	}

	private static void findSecondHighestElement() {
		int array[] = { 2, 0, 23, 473684 };
		int h = array[0], sh = h;
		for (int i = 1; i < array.length; i++) {
			if (array[i] > h) {
				sh = h;
				h = array[i];
			}
		}
		System.out.println(sh);
	}

	private static void printZigzag() {
		String s = "PAYPALISHIRING";
		int numRows = 3;

		String[] nStr = new String[numRows];
		int cnt = 0;
		int i = 1;
		int oddEven = 0;
		nStr[0] = s.charAt(0) + "";
		for (int j = 1; j < numRows; j++)
			nStr[j] = "";
		while (i < s.length()) {
			if (oddEven % 2 == 0) {
				cnt = 1;
				int limit = numRows;
				while (cnt < limit) {
					if (i == s.length())
						break;
					nStr[cnt] = nStr[cnt] + s.charAt(i);
					cnt++;
					i++;

				}
			} else {
				cnt = numRows - 2;
				int limit = 0;
				while (cnt >= limit) {
					if (i == s.length())
						break;
					nStr[cnt] = nStr[cnt] + s.charAt(i);
					cnt--;
					i++;

				}
			}
			oddEven++;

		}
		String result = "";
		for (int j = 0; j < nStr.length; j++) {
			System.out.println(nStr[j]);
			result = result + nStr[j];
		}
		System.out.println(result);
	}

	private static void getDirectoryPath() {
		String path = "dir1# dir11# dir12#  picture.jpeg#  file.txt#  mew.png#dir2# dir21";
		Stack<Directory> stack = new Stack<>();
		String array[] = path.split("#");
		int len = 0;
		int maxLen = -1;
		for (int i = 0; i < array.length; i++) {

			for (Directory s : stack) {
				System.out.println(s.filename + " --- " + s.level + "");
			}

			if (!array[i].trim().contains(".")) {
				if (stack.isEmpty()) {
					len = 0;
					int level = array[i].indexOf(array[i].trim());
					len = array[i].trim().length() + 1;
					stack.push(new Directory(len, array[i].trim(), level));
				} else {
					int level = array[i].indexOf(array[i].trim());
					len = len + array[i].trim().length() + 1;
					Directory ele = stack.peek();
					if (level <= ele.level) {
						// ele = stack.pop();
						while (!stack.isEmpty()) {
							ele = stack.peek();
							if (level > ele.level)
								break;
							else {
								ele = stack.pop();
								len = len - ele.filename.length() - 1;
							}
						}
					}
					stack.push(new Directory(len, array[i].trim(), level));
				}
			} else {
				Directory d = stack.peek();
				int tLen = array[i].trim().length() + d.len + 1;
				maxLen = Math.max(tLen, maxLen);
			}

		}
		System.out.println(maxLen);

	}

	private static void addDuplicate() {
		int x = 4967;

		String s = x + "";
		int next = Integer.parseInt(s.charAt(0) + ""), prev;
		int dupIndex = 0;
		int i = 1;
		for (; i < s.length(); i++) {
			prev = next;
			next = Integer.parseInt(s.charAt(i) + "");
			if (next < prev) {
				dupIndex = i - 1;
				break;
			}
		}
		if (i == s.length())
			s = s + s.charAt(i - 1);
		else
			s = s.substring(0, dupIndex + 1) + s.charAt(dupIndex) + s.substring(dupIndex + 1, s.length());

		System.out.println(s);

	}

	private static void longestPalindrome() {
		String s = "ccc";
		String longest = s.substring(0, 1);
		for (int i = 0; i < s.length(); i++) {
			// get longest palindrome with center of i
			String tmp = helper(s, i, i);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}
			//
			// get longest palindrome with center of i, i+1
			tmp = helper(s, i, i + 1);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}
		}

		System.out.println(longest);
	}

	// Given a centre, either one letter or two letter,
	// Find longest palindrome
	private static String helper(String s, int begin, int end) {
		System.out.println(begin + "----- " + " " + end + " ");
		while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
			begin--;
			end++;
		}
		System.out.println(s.substring(begin + 1, end));
		return s.substring(begin + 1, end);
	}

	private static void getHint() {
		String secret = "1234";
		String guess = "0111";
		int cow = 0;
		int bull = 0;
		HashMap<String, Integer> occurences = new HashMap<String, Integer>();
		for (int i = 0; i < secret.length(); i++) {
			if (occurences.containsKey(secret.charAt(i) + "")) {
				int val = occurences.get(secret.charAt(i) + "");
				val++;
				occurences.put(secret.charAt(i) + "", val);
			} else {
				occurences.put(secret.charAt(i) + "", 1);
			}
		}

		int k = 0;
		while (k < secret.length()) {

			if (secret.charAt(k) == guess.charAt(k)) {
				bull++;
				int val = occurences.get(secret.charAt(k) + "");
				val--;
				occurences.put(secret.charAt(k) + "", val);

			}
			k++;
		}
		k = 0;

		while (k < secret.length()) {

			if (secret.charAt(k) != guess.charAt(k) && secret.contains(guess.charAt(k) + "")) {
				int val = occurences.get(guess.charAt(k) + "");
				if (val > 0)
					cow++;
				val--;
				occurences.put(guess.charAt(k) + "", val);

			}
			k++;
		}

		System.out.println(bull + "A" + cow + "B");
	}

	private static void findTheMissingAndRepeatingValue() {

		int a[] = { 1, 3, 5, 2, 2 };
		int missing = 0;
		int repeat = 0;
		for (int i = 0; i < a.length; i++) {
			int val = Math.abs(a[i]);
			if (a[val - 1] < 0) {
				repeat = Math.abs(a[i]);

			} else
				a[val - 1] = -a[val - 1];
		}

		for (int i = 0; i < a.length; i++) {
			if (a[i] > 0) {
				missing = i + 1;
			}
		}
		System.out.println("missing---- " + missing + " repeating---- " + repeat);

	}

	private static void getMaxAreaRectangle() {
		int[] height = { 2, 1, 5, 6, 2, 3 };
		Stack<Integer> stack = new Stack<Integer>();

		int max = 0;
		int i = 0;

		while (i < height.length) {
			// push index to stack when the current height is larger than the
			// previous one
			if (stack.isEmpty() || height[i] >= height[stack.peek()]) {
				stack.push(i);
				i++;
			} else {
				// calculate max value when the current height is less than the
				// previous one
				int p = stack.pop();
				int h = height[p];
				System.out.println(h);
				int w = stack.isEmpty() ? i : i - stack.peek() - 1;
				max = Math.max(h * w, max);
			}

		}

		while (!stack.isEmpty()) {
			int p = stack.pop();
			int h = height[p];
			int w = stack.isEmpty() ? i : i - stack.peek() - 1;
			max = Math.max(h * w, max);
		}
	}

	private static void minimumNumberOfReversals() {
		String expr = "{{{";
		int len = expr.length();

		// After this loop, stack contains unbalanced
		// part of expression, i.e., expression of the
		// form "}}..}{{..{"
		Stack<Character> s = new Stack<>();
		for (int i = 0; i < len; i++) {
			if (expr.charAt(i) == '}' && !s.empty()) {
				if (s.peek() == '{')
					s.pop();
				else
					s.push(expr.charAt(i));
			} else
				s.push(expr.charAt(i));
		}

		// Length of the reduced expression
		// red_len = (m+n)
		int red_len = s.size();
		System.out.println("new length " + red_len);
		// count opening brackets at the end of
		// stack
		int n = 0;
		while (!s.empty() && s.peek() == '{') {
			s.pop();
			n++;
		}

		// return ceil(m/2) + ceil(n/2) which is
		// actually equal to (m+n)/2 + n%2 when
		// m+n is even.
		System.out.println(red_len / 2 + n % 2);
	}

	private static void swapCall() {
		Directory d1 = new Directory(1);
		Directory d2 = new Directory(2);
		Directory d3 = new Directory(3);
		Integer a = 1;
		implementSwap(d1, d2, d3, a);
		System.out.println(d1.len + " === swap === " + d2.len + " " + d3.len + " " + a);
	}

	private static void implementSwap(Directory d1, Directory d2, Directory d3, Integer a) {
		Directory temp = d1;
		d1 = d2;
		d2 = temp;
		System.out.println(d1.len + " === swap === " + d2.len);
		Directory temp1 = new Directory(5);
		d3 = temp1;

	}

}

class Directory {

	public int len;
	public String filename;
	public int level;

	public Directory(int len, String name, int level) {
		this.len = len;
		this.level = level;
		this.filename = name;
	}

	public Directory(int i) {

	}

}
