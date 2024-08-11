package graphs_1;
import java.util.*;

public class AdjacencyMatrix {

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
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(adjMatrix[i][j]+" ");
			}
			System.out.println();
		}

	}

}
