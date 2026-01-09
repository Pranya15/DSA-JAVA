 public class NQueen {

     static void solveNQueens(int n) {
         char[][] board = new char[n][n];

         for (int i = 0; i < n; i++) {
             for (int j = 0; j < n; j++) {
                 board[i][j] = '.';
             }
         }

         placeQueens(board, 0, n);
     }

     static void placeQueens(char[][] board, int row, int n) {
         if (row == n) {
             printBoard(board);
             System.out.println();
             return;
         }

         for (int col = 0; col < n; col++) {
             if (isSafe(board, row, col)) {
                 board[row][col] = 'Q';
                 placeQueens(board, row + 1, n);
                 board[row][col] = '.';
             }
         }
     }

     static boolean isSafe(char[][] board, int row, int col) {
         for (int i = 0; i < row; i++) {
             if (board[i][col] == 'Q') return false;
         }

         for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
             if (board[i][j] == 'Q') return false;
         }

         for (int i = row, j = col; i >= 0 && j < board.length; i--, j++) {
             if (board[i][j] == 'Q') return false;
         }

         return true;
     }

     static void printBoard(char[][] board) {
         for (char[] row : board) {
             for (char c : row) {
                 System.out.print(c + " ");
             }
             System.out.println();
         }
     }

     public static void main(String[] args) {
         int n = 4;
         solveNQueens(n);
     }
 }
