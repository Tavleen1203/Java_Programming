package tries;

public class CountWords {
	public static int count(TrieNode root) {
		return countHelper(root);
	}

	private static int countHelper(TrieNode root) {
		if(root==null) {
			return 0;
		}
		int count=0;
		if(root.isLast) {
			count++;
		}
		
		for(TrieNode child : root.children) {
			count+=countHelper(child);
		}
		
		return count;
	}
}
