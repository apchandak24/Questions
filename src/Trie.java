import java.util.HashMap;

class TrieNode {
	// Initialize your data structure here.
	public static char ch;
	HashMap<Character, TrieNode> map = new HashMap<Character, TrieNode>();
	boolean isLeaf;

	public TrieNode(char ch) {
		this.ch = ch;
	}

	public TrieNode() {

	}
	static {
		ch = 'a';
	}
}

public class Trie {
	private TrieNode root;
	HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();

	public Trie() {
		root = new TrieNode();
	}

	// Inserts a word into the trie.
	public void insert(String word) {
		children = root.map;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node;
			if (children.containsKey(ch)) {
				node = children.get(ch);
			} else {
				node = new TrieNode(ch);
				children.put(ch, node);
			}
			children = node.map;
			System.out.println(node.ch);
		}

	}

	// Returns if the word is in the trie.
	public boolean search(String word) {
		children = root.map;
		TrieNode n = null;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (children.containsKey(ch)) {
				n = children.get(ch);
				children = children.get(ch).map;
			} else
				return false;
		}
		if (n != null && n.isLeaf == true)
			return true;
		return false;
	}

	// Returns if there is any word in the trie
	// that starts with the given prefix.
	public boolean startsWith(String prefix) {
		children = root.map;
		TrieNode n = null;
		int i = 0;
		for (; i < prefix.length(); i++) {
			char ch = prefix.charAt(i);
			if (children.containsKey(ch)) {
				n = children.get(ch);
				children = children.get(ch).map;
			} else
				return false;
		}
		if (i == prefix.length())
			return true;
		else
			return false;

	}
}
