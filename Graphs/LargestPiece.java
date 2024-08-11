package graphsQues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LargestPiece {
    
    public static final int[] row_moves = {-1, 1, 0, 0};
    public static final int[] col_moves = {0, 0, -1, 1};
    
    private static int bfs(int[][] cake, boolean[][] visited, int startx, int starty, int n) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {startx, starty});
        visited[startx][starty] = true;
        int count = 0;
        
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];
            count++; // Increment count for each valid cell
            
            for (int i = 0; i < 4; i++) {
                int newx = x + row_moves[i];
                int newy = y + col_moves[i];
                
                if (isValid(newx, newy, n) && cake[newx][newy] == 1 && !visited[newx][newy]) {
                    visited[newx][newy] = true;
                    q.add(new int[] {newx, newy});
                }
            }
        }
        return count;
    }
    
    private static boolean isValid(int x, int y, int n) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[][] cake = new int[n][n];
        
        // Reading the cake grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cake[i][j] = s.nextInt();
            }
        }
        
        boolean[][] visited = new boolean[n][n];
        int largestPiece = 0;
        
        // Iterate through each cell in the cake grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cake[i][j] == 1 && !visited[i][j]) {
                    int currentPiece = bfs(cake, visited, i, j, n);
                    largestPiece = Math.max(largestPiece, currentPiece);
                }
            }
        }
        
        System.out.println(largestPiece);
        s.close();
    }
}

