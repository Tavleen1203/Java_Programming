package graphs_1;
import java.util.ArrayList;
import java.util.Scanner;

public class GetPathDFS {
	public static ArrayList<Integer> getPathDFS(int[][] adjMatrix,int src, int dest){
		boolean visited[] = new boolean[adjMatrix.length];
		return getPathHelper(adjMatrix,src,dest,visited);
	}
	 private static ArrayList<Integer> getPathHelper(int[][] adjMatrix,int src, int dest, boolean[] visited){
		 if(src==dest) {
			 ArrayList<Integer> result = new ArrayList<Integer>();
			 result.add(src);
			 return result;
		 }
		 visited[src]=true;
		 
		 for(int i=0;i<adjMatrix.length;i++) {
			 if(adjMatrix[src][i]==1 && visited[i]==false) {
				 ArrayList<Integer> smallRes=getPathHelper(adjMatrix,i,dest,visited);
				 
				 if(smallRes!=null){
					 smallRes.add(src);
					 return smallRes;
				 }
			 } 
		 }
		 return null;	 
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
		
		System.out.println(getPathDFS(adjMatrix,2,3));

	}

}
