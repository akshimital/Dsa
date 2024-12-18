package Backtracking;

public class NQueen {
        public static void main(String[] args) {
            int N = 4;
            int arr[][] = new int[N][N];
            nqueen(arr, 0, N);

        }
        static void printBoard(int arr[][]){
            for(int i=0;i<arr.length;i++){
                for(int j=0;j<arr.length;j++){
                    if(arr[i][j]==1){
                        System.out.print(j+" ");
                    }
                }
            }
            System.out.println();
        }
        static void nqueen(int[][] board, int col, int n){
            if(col >= n){
                printBoard(board);
                return;
            }
            for(int row=0; row<n; row++){
                if (isSafe(board, row, col) == true) {
                    board[row][col] = 1;
                    nqueen(board, col+1, n);
                    board[row][col] = 0;
                }

            }
        }
        static boolean isSafe(int[][] board, int row, int col){
            for(int i=0;i<col;i++){
                if(board[row][i] == 1){
                    return false;
                }
            }
            for(int i=row,j=col; i>=0 && j>=0; i--,j--){
                if(board[i][j] == 1){
                    return false;
                }
            }
            for(int i=row,j=col;i<board.length && j>=0; i++,j--){
                if(board[i][j] == 1) {
                    return false;
                }
            }
            return true;
        }


}
