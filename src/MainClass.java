import java.util.HashMap;
import java.util.Stack;

public class MainClass {

	public static void main(String[] args) {
		// findSecondHighestElement();
		// printZigzag();
		getDirectoryPath();
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

}
