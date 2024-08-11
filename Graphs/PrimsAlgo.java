package graphs_2;

import java.util.Scanner;

public class PrimsAlgo {
	public static void prims(int[][] adjMatrix) {
		int n = adjMatrix.length;
		boolean visited[] = new boolean[n];
		int parent[] = new int[n];
		int weight[]= new int[n];
		
		weight[0]=0;
		parent[0]=-1;
		
		for(int i =1;i<n;i++) {
			weight[i]=Integer.MAX_VALUE;		
		}
		
		for(int i =0;i<n;i++) {
			int min = findMin(weight, visited);
			visited[min]=true;
			
			for(int j=0;j<n;j++) {
				if(adjMatrix[min][j]>0 && !visited[j]) {
					if(adjMatrix[min][j]<weight[j]) {
						weight[j]=adjMatrix[min][j];
						parent[j]=min;
					}
				}
			}
		}
		for(int i =1;i<n;i++) {
			if(parent[i]<i) {
				System.out.println(parent[i]+" "+i+" "+ weight[i]);
			}else {
				System.out.println(i+" " +parent[i]+" "+ weight[i]);
			}
		}
		
	}
	
	private static int findMin(int[] weight, boolean[] visited) {
		int min=-1;
		for(int i=0;i<weight.length;i++) {
			if(!visited[i] && (min==-1 || weight[i]<weight[min])) {
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
		
		prims(adjMatrix);

	}

}
