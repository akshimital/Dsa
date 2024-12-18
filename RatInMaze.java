package Backtracking;


public class RatInMaze {
        public static void main(String[] args) {
            int[][] arr = {
                    {1, 0, 0, 0 },
                    {1, 1, 0, 1},
                    {0, 1, 1, 0},
                    {1, 1, 1, 1}
            };
            int n = arr.length;
            int m = arr[0].length;
            int count = 0;
            StringBuilder res = new StringBuilder();
            maze(arr, 0, 0, n, m, count, res);
        }
        static void maze(int[][] arr, int row, int col, int n , int m , int count, StringBuilder res){
            if(row == n-1 && col == m-1 && arr[row][col] == 1){
                count++;
                System.out.println(res);
            }
            if(row+1 < n && arr[row+1][col] == 1){
                maze(arr, row+1, col, n, m, count, res.append("D"));
                res.deleteCharAt(res.length()-1);
            }
            if(col+1 < m && arr[row][col+1] == 1){
                maze(arr, row, col+1, n, m, count, res.append("R"));
                res.deleteCharAt(res.length()-1);
            }

        }
    }

