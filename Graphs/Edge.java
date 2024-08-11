package graphs_2;

public class Edge implements Comparable<Edge>{
	int src;
	int dest;
	int weight;
	
	@Override
	public int compareTo(Edge e) {
		return this.weight-e.weight;
	}
	
	
	public Edge(int s, int d, int w) {
		src=s;
		dest=d;
		weight=w;
	}
}
