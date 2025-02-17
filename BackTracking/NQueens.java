package BackTracking;

public class NQueens {

    // Function to check if it's safe to place a queen at board[row][col]
    private static boolean safe(char[][] board, int row, int col, int n) {
        // Check left row
        for (int i = col - 1; i >= 0; i--) {
            if (board[row][i] == 'Q') {
                return false;
            }
        }

        // Check upper diagonal (left side)
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check lower diagonal (left side)
        for (int i = row + 1, j = col - 1; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    // Recursive function to place queens
    private static void placeQueens(char[][] board, int n, int col) {
        // Base case: If all queens are placed, print the board
        if (col == n) {
            displayBoard(board, n);
            return;
        }

        // Try placing queen in each row of the current column
        for (int i = 0; i < n; i++) {
            if (safe(board, i, col, n)) {
                board[i][col] = 'Q';  // Place queen
                placeQueens(board, n, col + 1);  // Recur for next column
                board[i][col] = '.';  // Backtrack
            }
        }
    }

    // Function to display the board
    private static void displayBoard(char[][] board, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 5;
        char[][] board = new char[n][n];

        // Initialize board with empty spaces ('.')
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        // Start placing queens
        placeQueens(board, n, 0);
    }
}
