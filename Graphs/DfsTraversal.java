package graphs_1;
import java.util.Scanner;

public class DfsTraversal {
	public static void dfs(int adjMatrix[][]) {
		boolean[] visited=new boolean[adjMatrix.length];
		dfsHelper(adjMatrix,0,visited);
	}
	private static void dfsHelper(int[][] adjMatrix, int source, boolean[] visited) {
		System.out.print(source);
		visited[source]=true;
		for(int i=0;i<adjMatrix.length;i++) {
			if(adjMatrix[source][i]==1 && visited[i]==false) {
				dfsHelper(adjMatrix,i,visited);
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
		
		dfs(adjMatrix);
	}
}


