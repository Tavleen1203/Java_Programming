package tries_ques;
import java.util.*;

class TrieNode1{
	char data;
	boolean isLast;
	TrieNode1 children[];
	int childCount;
	
	public TrieNode1(char data) {
		this.data = data;
		isLast = false;
		children = new TrieNode1[26];
		childCount=0;
	}
}

class Trie1{
	private TrieNode1 root;
	public int count;
	
	public Trie1() {
		root = new TrieNode1('\0');
	}
	
	private void add(TrieNode1 root, String word) {
		if(word.length()==0) {
			root.isLast=true;
			return;
		}
		int childIndex = word.charAt(0)-'a';
		TrieNode1 child = root.children[childIndex];
		if(child==null) {
			child = new TrieNode1(word.charAt(0));
			root.children[childIndex] = child;
			root.childCount++;
		}
		add(child, word.substring(1));
	}
	
	public void add(String word) {
		add(root,word);
	}
	
	public TrieNode1 findRoot(TrieNode1 root, String word) {
		if(word.length()==0) {
			return root;
		}
		int childIndex = word.charAt(0)-'a';
		TrieNode1 child = root.children[childIndex];
		if(child==null) {
			return null;
		}
		return findRoot(child, word.substring(1));
	}
	
	public void autoComplete(ArrayList<String> input, String word) {
		for(String w : input) {
			add(w);
		}
		TrieNode1 node = findRoot(root, word);
		if(node == null || node.childCount==0) {
			return;
		}
		String res = "";
		allPaths(node,res,word);
	}

	private void allPaths(TrieNode1 node, String res, String word) {
		if(node.childCount==0) {
			if(res.length()>0) {
				System.out.println(word+res);
			}
			return;
		}
		if(node.isLast==true) {
			System.out.println(word+res);
		}
		for(int i=0;i<node.children.length;i++){
			if(node.children[i]!=null) {
				String ans = res + node.children[i].data;
				allPaths(node.children[i], ans, word);
			}
		}
	}
}
public class AutoComplete {

}
