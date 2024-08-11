package tries;

public class TrieNode {
	char data;
	boolean isLast;
	TrieNode children[];
	
	public TrieNode(char data) {
		this.data = data;
		isLast = false;
		children = new TrieNode[26];
   }
}
