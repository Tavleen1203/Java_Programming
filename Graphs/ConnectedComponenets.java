package graphs_1;
import java.util.*;
import java.util.Scanner;

public class ConnectedComponenets {
	public static List<List<Integer>> ConnectedComponentsBFS(List<List<Integer>> adjList){
		int n = adjList.size();
		boolean[] visited = new boolean[n];
		List<List<Integer>> ans = new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			if(visited[i]==false) {
				List<Integer> smallans=helper(adjList,i,visited);
				ans.add(smallans);
			}
		}	
		return ans;
	}
	
	private static List<Integer> helper(List<List<Integer>> adjList, int src, boolean[] visited){
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(src);
		ArrayList<Integer> ans = new ArrayList<Integer>();
		//ans.add();
		visited[src]=true;
		
		while(!q.isEmpty()) {
			int front = q.remove();
			ans.add(front);
			
			for(int nbr : adjList.get(front)) {
				if(visited[nbr]==false) {
					q.add(nbr);
					visited[nbr]=true;
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n=s.nextInt();
		int e=s.nextInt();
		
		List<List<Integer>> adjList = new ArrayList<List<Integer>>();
		for(int i=0;i<n;i++) {
			adjList.add(new ArrayList<>());
		}
		
		for(int i=0;i<e;i++) {
			int src=s.nextInt();
			int dest=s.nextInt();
			adjList.get(src).add(dest);
			adjList.get(dest).add(src);
			s.close();
		}
		
		List<List<Integer>> ans = ConnectedComponentsBFS(adjList);
		for(List<Integer> smallAns : ans) {
			for(int node : smallAns) {
				System.out.print(node+" ");
			}
			System.out.println();
		}
	}

}
