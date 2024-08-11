package graphsQues;

import java.util.Scanner;

public class CodingNinjas {
  
// THIS IS CONNECTING DOTS CODE
	
    // Direction vectors for moving up, down, left, and right
    private static final int[] row_moves = {-1, 1, 0, 0};
    private static final int[] col_moves = {0, 0, -1, 1};

    // Function to check if the position is within matrix bounds
    private static boolean isValid(int x, int y, int n, int m) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        // Read dimensions of the game board
        int n = s.nextInt();
        int m = s.nextInt();
        s.nextLine(); // Consume newline
        
        // Read the game board
        char[][] game_board = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = s.nextLine();
            for (int j = 0; j < m; j++) {
                game_board[i][j] = line.charAt(j);
            }
        }
        s.close(); // Close the scanner
        
        // Initialize visited matrix to keep track of visited cells
        boolean[][] visited = new boolean[n][m];
        
        // Flag to track if a cycle of the same color is found
        boolean cycleExists = false;
        
        // Traverse through each cell on the game board
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    // Start DFS from unvisited cell
                    if (dfs(game_board, visited, i, j, -1, -1, game_board[i][j])) {
                        cycleExists = true;
                        break;
                    }
                }
            }
            if (cycleExists) {
                break;
            }
        }
        
        // Print whether a cycle of the same color exists
        System.out.println(cycleExists);
    }
    
    // Depth First Search (DFS) function to find cycles
    private static boolean dfs(char[][] board, boolean[][] visited, int x, int y, int parentx, int parenty, char color) {
        visited[x][y] = true;
        
        // Explore all 4 possible directions
        for (int i = 0; i < 4; i++) {
            int newX = x + row_moves[i];
            int newY = y + col_moves[i];
            
            // Check if the new position is within bounds
            if (isValid(newX, newY, board.length, board[0].length)) {
                // Check if the new position has the same color and is not the parent cell
                if (board[newX][newY] == color) {
                    if (visited[newX][newY]) {
                        // Cycle found: the new position is already visited and not the parent cell
                        return true;
                    } else {
                        // Continue DFS recursively
                        if (dfs(board, visited, newX, newY, x, y, color)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false; // No cycle found from this path
    }
}
