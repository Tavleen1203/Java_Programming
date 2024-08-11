package tries_ques;

import java.util.*;

class SuffixTrieNode{
	HashMap<Character, SuffixTrieNode> children = new  HashMap<Character, SuffixTrieNode>();
	
	public SuffixTrieNode() {
		
	}
}

class SuffixTrie{
	private final SuffixTrieNode root = new SuffixTrieNode();
	
	public SuffixTrie(String s) {
		for(int i =0; i<s.length();i++) {
			add(s.substring(i));
		}
	}
	
	private void add(String suffix) {
		SuffixTrieNode curr = root;
		for(char c : suffix.toCharArray()) {
			curr = curr.children.computeIfAbsent(c, k-> new SuffixTrieNode() );
		}
	}
	
	public boolean search(String s) {
		SuffixTrieNode curr = root;
		for(char c: s.toCharArray()) {
			curr = curr.children.get(c);
			if(curr==null) {
				return false;
			}
		}
		return true;
	}
}

public class PatternMatching {
	public static boolean patternFound(String w, String p) {
		SuffixTrie trie = new SuffixTrie(w);
		return trie.search(p);
	}
	
	public static void main(String[] args) {
		String w = "bananabandana";
		String p1  = "band";
		String p2 = "bandna";
		
		System.out.println(patternFound(w, p1));
		System.out.println(patternFound(w, p2));
	}
}

