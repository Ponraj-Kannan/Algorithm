package BackTracking;

public class SudokuSolver {

    // Function to check if it's safe to place a number in a given cell
    private static boolean safe(int row, int col, int val, int[][] sudoku) {
        // Check row and column for duplicate values
        for (int i = 0; i < 9; i++) {
            if (sudoku[row][i] == val || sudoku[i][col] == val) {
                return false;
            }
        }

        // Check the 3x3 subgrid for duplicate values
        int startRow = row - row % 3, startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (sudoku[i + startRow][j + startCol] == val) {
                    return false;
                }
            }
        }
        return true;
    }

    // Function to solve Sudoku using backtracking
    private static boolean solve(int row, int col, int[][] sudoku) {
        // If we reach the end of the board, return true (solution found)
        if (row == 9) {
            displaySudoku(sudoku);
            return true;
        }

        // Move to the next row if we reach the end of a column
        else if (col == 9) {
            return solve(row + 1, 0, sudoku);
        }

        // Skip already filled cells
        else if (sudoku[row][col] != 0) {
            return solve(row, col + 1, sudoku);
        }

        // Try placing numbers from 1 to 9
        for (int val = 1; val <= 9; val++) {
            if (safe(row, col, val, sudoku)) {
                sudoku[row][col] = val; // Place the number
                if (solve(row, col + 1, sudoku)) {
                    return true; // If solution is found, return true
                }
                sudoku[row][col] = 0; // Backtrack if no solution found
            }
        }

        return false; // No solution possible
    }

    // Wrapper function to start solving Sudoku
    private static void solveSudoku(int[][] sudoku) {
        if (!solve(0, 0, sudoku)) {
            System.out.println("No solution exists");
        }
    }

    // Function to display the Sudoku board
    private static void displaySudoku(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Main function to test the Sudoku solver
    public static void main(String[] args) {
        int[][] sudoku = {
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };

        solveSudoku(sudoku);
    }
}
