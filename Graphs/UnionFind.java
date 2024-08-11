package graphs_2;
import java.util.*;

public class UnionFind {
	
	public static Edge[] kruskalAlgo(Edge[] list, int n) {
		Arrays.sort(list);
		Edge ans[] = new Edge[n-1];
		int parent[]= new int[n];
		for(int j=0;j<n;j++) {
			parent[j]=j;
		}
		
		int count=0, i=0;
		while(count!=n-1) {
			Edge curr = list[i++];
			int srcParent = findParent(curr.src,parent);
			int destParent = findParent(curr.dest,parent);
			if(srcParent!=destParent) {
				///Include  current edge
				ans[count++]=curr;
				parent[srcParent]=destParent;
			}		
		}
		return ans;
	}
	
	private static int findParent(int src, int parent[]) {
		if(src==parent[src]) {
			return src;
		}
		return findParent(parent[src],parent);
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int e=s.nextInt();
		
		Edge adjList[] = new Edge[e];
		
		for(int i=0;i<e;i++) {
			int src= s.nextInt();
			int dest= s.nextInt();
			int weight= s.nextInt();
			Edge edge = new Edge(src, dest, weight);
			s.close();
			adjList[i]=edge;
		}
		Edge ans[]=kruskalAlgo(adjList,n);
		for(int i=0;i<ans.length;i++) {
			if(ans[i].src<ans[i].dest) {
				System.out.println(ans[i].src+" " +ans[i].dest+" "+ans[i].weight);
			}else {
				System.out.println(ans[i].dest+ " "+ ans[i].src+" "+ans[i].weight);
			}
		}

	}
	
}
