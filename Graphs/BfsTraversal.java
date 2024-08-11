package graphs_1;
import java.util.*;

public class BfsTraversal {
	public static void bfs(int[][] AM) {
		boolean[] visited=new boolean[AM.length];
		for(int i=0;i<AM.length;i++) {
			if(visited[i]==false) {
				bfsHelper(AM,i,visited);
			}
		}
	}
	
	private static void bfsHelper(int[][] AM, int source, boolean[] visited) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(source);
		visited[source]=true;
		
		while(!q.isEmpty()) {
			int front=q.remove();
			System.out.print(front+" ");
			
			for(int i=0;i<AM.length;i++) {
				if(AM[front][i]==1 && visited[i]==false) {
					q.add(i);
					visited[i]=true;
				}
			}
		}
	}
	

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
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
		bfs(adjMatrix);
	}
}
