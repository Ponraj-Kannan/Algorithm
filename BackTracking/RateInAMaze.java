package BackTracking;
import java.util.ArrayList;

public class RateInAMaze {

    // Possible moves in the order: Right, Down, Left, Up
    private static final int[] nxtRow = {0, 1, 0, -1}; // The next row index
    private static final int[] nxtCol = {1, 0, -1, 0}; // The next column index
    private static final char[] dir = {'R', 'D', 'L', 'U'};

    /**
     * Checks if the next position is within the maze and is a valid path (1 means path, 0 means wall)
     * Return True if the next position is valid, false otherwise
     */
    private static boolean isValidMove(int[][] maze, int n, int nextRow, int nextCol) {
        return (nextRow >= 0 && nextRow < n) && (nextCol >= 0 && nextCol < n) && (maze[nextRow][nextCol] == 1);
    }

    // Recursive function to find all possible paths from the top-left to bottom-right of the maze
    private static void findPath(int[][] maze, int n, int row, int col, StringBuilder path, ArrayList<String> result) {
        // Base case: if we reach the bottom-right corner, store the path
        if (row == n - 1 && col == n - 1) {
            result.add(path.toString());
            return;
        }

        // Mark the current cell as visited (to prevent cycles)
        maze[row][col] = 0;

        // Try all possible moves (Right, Down, Left, Up)
        for (int k = 0; k < 4; k++) {
            int nextRow = row + nxtRow[k];
            int nextCol = col + nxtCol[k];

            if (isValidMove(maze, n, nextRow, nextCol)) {
                path.append(dir[k]); // Add direction to path
                findPath(maze, n, nextRow, nextCol, path, result);
                path.deleteCharAt(path.length() - 1); // Backtrack
            }
        }

        // Unmark the cell (backtrack to explore other paths)
        maze[row][col] = 1;
    }

    public static void main(String[] args) {

//        Test case 1
        int[][] maze = { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 1, 1, 1, 1 } }; // The maze matrix

/*
        Test case 2
        int[][] maze = { { 1, 0, 1, 1, 1 },
                { 1, 1, 1, 0, 1 },
                { 0, 0, 0, 1, 1 },
                { 0, 0, 0, 1, 0 },
                { 0, 0, 0, 1, 1 } };

        Test case 3
        int[][] maze = {
                { 1, 1, 0, 1 },
                { 1, 1, 0, 1 },
                { 1, 1, 0, 0 },
                { 0, 1, 1, 1 }
        };
*/

        int n = maze.length; // The size of the maze
        int row = 0, col = 0;

        ArrayList<String> result = new ArrayList<>(); // The list storing all valid paths
        StringBuilder path = new StringBuilder(); // The path taken so far

        // Start searching only if the start position is valid
        if (maze[row][col] == 1) {
            findPath(maze, n, row, col, path, result);
        }

        // Print all possible paths from start to end
        System.out.println(result);
    }
}