package graphs_1;
import java.util.*;

public class GetPathBFS {
	public static ArrayList<Integer> getPathBFS(int[][] adjMatrix, int src, int dest){
		boolean[] visited = new boolean[adjMatrix.length];
		return getPathHelper(adjMatrix,src,dest,visited);
	}
	
	private static ArrayList<Integer> getPathHelper(int[][] adjMatrix, int src, int dest, boolean[] visited){
		Map<Integer,Integer> map = new HashMap<>();
		Queue<Integer> q = new LinkedList<>();
		
		if(src>adjMatrix.length-1 || dest>adjMatrix.length-1) {
			return null;
		}
		
		if(src==dest) {
			ArrayList<Integer> ans = new ArrayList<Integer>();
			ans.add(src);
			return ans;
		}
		visited[src]=true;
		q.add(src);
		
		while(!q.isEmpty()) {
			int front = q.remove();
			for(int i=0;i<adjMatrix.length;i++) {
				if(adjMatrix[front][i]==1 && visited[i]==false) {
					map.put(i,front);
					q.add(i);
					visited[i]=true;
					
					if(i==dest){
						ArrayList<Integer> ans = new ArrayList<Integer>();
						ans.add(dest);
						int parent = map.get(dest);
						
						while(parent!=src) {
							ans.add(parent);
							parent=map.get(parent);
						}
						ans.add(parent);
						return ans;
					}
				}
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Start:");
		int n=s.nextInt();
		int adjMatrix[][] = new int[n][n];
		int e=s.nextInt();
		for(int i=0;i<e;i++){
			int first=s.nextInt();
			int second=s.nextInt();
			adjMatrix[first][second]=1;
			adjMatrix[second][first]=1;
			s.close();
		}
		
	System.out.println(getPathBFS(adjMatrix,1,4));
	}
}


