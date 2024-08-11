package graphs_2;

import java.util.Scanner;

public class Dijkstra {
	public static void dijkstraAlgo(int[][] adjMatrix) {
		int n=adjMatrix.length;
		boolean visited[] = new boolean[n];
		int dist[]=new int[n];
		dist[0]=0;
		for(int i=1;i<n;i++) {
			dist[i]=Integer.MAX_VALUE;
		}
		
		for(int i=0;i<n-1;i++) {
			int min=findMin(visited,dist);
			visited[min]=true;
			for(int j=0;j<n;j++) {
				if(adjMatrix[min][j]>0 && !visited[j] && adjMatrix[min][j]<Integer.MAX_VALUE) {
					//distance to reach j from source via min
					int newDist = dist[min]+adjMatrix[min][j];
					if(newDist<dist[j]);
					dist[j]=newDist;
				}
			}
		}
		for(int i =0;i<n;i++) {
			System.out.println(i + " "+ dist[i]);
		}
		
	}

	private static int findMin(boolean[] visited, int[] dist) {
		int min = -1;
		for(int i=0;i<visited.length;i++) {
			if(!visited[i] && (min==-1 || dist[i]<dist[min])) {
				min=i;
			}
		}
		return min;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int e= s.nextInt();
		
		int[][] adjMatrix=new int[n][n];
		
		for(int i =0;i<e;i++) {
			int src=s.nextInt();
			int dest=s.nextInt();
			int weight = s.nextInt();
			adjMatrix[src][dest]=weight;
			adjMatrix[dest][src]=weight;
			s.close();
		}
		dijkstraAlgo(adjMatrix);
	}
}
