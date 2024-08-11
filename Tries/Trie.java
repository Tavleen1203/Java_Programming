package tries;

public class Trie {
	private TrieNode root;
	private int numWords;
	
	public Trie() {
		root = new TrieNode('\0');
		numWords=0;
	}
	
	public void add(String word) {
		addHelper(root,word);
		numWords++;
	}

	private void addHelper(TrieNode root, String word) {
		if(word.length()==0) {
			root.isLast=true;
			return;
		}
		
		int childIndex = word.charAt(0)-'a';
		TrieNode child = root.children[childIndex];
		if(child==null) {
			child = new TrieNode(word.charAt(0));
			root.children[childIndex]=child;
		}
		addHelper(child, word.substring(1));
	}
	
	public boolean search(String word) {
		return searchHelper(root, word);
	}

	private boolean searchHelper(TrieNode root, String word) {
		if(word.length()==0) {
			return root.isLast;
		}
		int childIndex = word.charAt(0)-'a';
		TrieNode child = root.children[childIndex];
		if(child== null) {
			return false;
		}
		return searchHelper(child, word.substring(childIndex));
	}
	
	public void remove(String word) {
		removeHelper(root, word);
		numWords--;
	}

	private void removeHelper(TrieNode root, String word) {
		if(word.length()==0) {
			root.isLast=false;
			return;
		}
		
		int childIndex=word.charAt(0)-'a';
		TrieNode child = root.children[childIndex];
		if(child==null) {
			return;
		}
		removeHelper(child, word.substring(1));
		if(!child.isLast) {
			int numChildren = 0;
			for(int i=0;i<26;i++) {
				if(child.children[i]!=null) {
					numChildren++;
				}
				if(numChildren==0) {
					root.children[childIndex]=null;
					child=null;
				}
			}
		}
	}
	
	public int wordCount() {
		return numWords;
	}
}
