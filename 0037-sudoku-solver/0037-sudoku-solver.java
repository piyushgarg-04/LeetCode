public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Arrays to track seen numbers in rows, columns, and sub-boxes
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        // Iterate through the board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];

                // Skip empty cells
                if (c == '.') continue;

                int num = c - '1'; // Convert '1'-'9' to 0-8
                int boxIndex = (i / 3) * 3 + (j / 3); // Calculate sub-box index

                // Check if the number is already seen in the current row, column, or box
                if (rows[i][num] || cols[j][num] || boxes[boxIndex][num]) {
                    return false;
                }

                // Mark the number as seen
                rows[i][num] = true;
                cols[j][num] = true;
                boxes[boxIndex][num] = true;
            }
        }

        return true; // All checks passed
    }

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c; // Place the number

                            if (solve(board)) {
                                return true; // If solving succeeds, return true
                            }

                            board[i][j] = '.'; // Backtrack
                        }
                    }
                    return false; // If no valid number, return false
                }
            }
        }
        return true; // Solved
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        int boxIndex = (row / 3) * 3 + (col / 3);
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == c || board[i][col] == c || board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example
        char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        solution.solveSudoku(board);

        // Print the solved board
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}
