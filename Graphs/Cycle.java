package graphsQues;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cycle {
    // Function to find cycles using DFS in an undirected graph represented by adjacency list
    public static int findCycles(List<List<Integer>> graph) {
        int n = graph.size();
        boolean[] visited = new boolean[n];
        int[] parent = new int[n];
        int cycleCount = 0;

        // Perform DFS from each unvisited node
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (dfs(graph, i, visited, parent)) {
                    cycleCount++;
                }
            }
        }
        return cycleCount;
    }

    // Helper function for DFS traversal
    private static boolean dfs(List<List<Integer>> graph, int node, boolean[] visited, int[] parent) {
        visited[node] = true;

        // Recur for all adjacent vertices
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                parent[neighbor] = node;
                if (dfs(graph, neighbor, visited, parent)) {
                    return true;
                }
            } else if (neighbor != parent[node]) {
                // If neighbor is visited and not parent of current node, cycle detected
                return true;
            }
        }
        return false; // No cycle found in this path
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the number of nodes (assuming it's n)
        int n = scanner.nextInt();
        
        // Initialize adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // Read the number of edges (assuming it's m)
        int m = scanner.nextInt();
        
        // Read each edge and populate the adjacency list
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph.get(u).add(v); // Directed edge from u to v
            graph.get(v).add(u); // Undirected graph, so add bidirectional edges
        }
        
        // Call findCycles method
        int cycleCount = findCycles(graph);
        
        // Output the number of cycles found
        System.out.println("Number of cycles in the graph: " + cycleCount);
        
        scanner.close();
    }
}


//
//import java.util.Scanner;
//
//public class Cycle {
//	
//	// Method to find cycles in a graph represented by an adjacency matrix
//	public static int findCycles(int[][] graph, int n) {
//		int count = 0; // Initialize a counter to count cycles
//		
//		// Iterate over all triplets (i, j, k) where i < j < k
//		for (int i = 0; i < n - 2; i++) {
//			for (int j = i + 1; j < n - 1; j++) {
//				for (int k = j + 1; k < n; k++) {
//					// Check if there is an edge between (i, j), (j, k), and (k, i)
//					if (graph[i][j] == 1 && graph[j][k] == 1 && graph[k][i] == 1) {
//						count++; // If a cycle is found, increment the count
//					}
//				}
//			}
//		}
//		return count; // Return the total count of cycles found
//	}
//
//
//	public static void main(String[] args) {
//		Scanner s = new Scanner(System.in);
//		System.out.println("Start:");
//		int n=s.nextInt();
//		int adjMatrix[][] = new int[n][n];
//		int e=s.nextInt();
//		for(int i=0;i<e;i++){
//			int first=s.nextInt();
//			int second=s.nextInt();
//			adjMatrix[first][second]=1;
//			adjMatrix[second][first]=1;
//			s.close();
//		}
//		
//		System.out.println(findCycles(adjMatrix, n));
//
//	}
//
//}
