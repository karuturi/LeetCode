import java.util.Queue;
import java.util.LinkedList;

/*
* https://leetcode.com/problems/01-matrix/
*/
public class Solution542 {
    public static void main(String[] args) {
        // int[][] mat = {{0,0,0},{0,1,0},{0,0,0}};
        int[][] mat = {{0,0,0},{0,1,0},{1,1,1}};
        Solution542 solution = new Solution542();
        printMatrix(mat);
        printMatrix(solution.updateMatrixBFS(mat));
    }

    private static void printMatrix(int[][] mat) {
        for(int i =0; i< mat.length; i++) {
            System.out.print("[ ");
            for (int j=0; j< mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println("] ");
        }
    }

    public int[][] updateMatrixBFS(int[][] mat) {
        
        int[][] result = new int[mat.length][mat[0].length];
        
        Queue<int[]> queue = new LinkedList<>();
        
        for(int r =0 ; r< mat.length; r++) {
            for(int c=0; c< mat[0].length; c++) {
                if(mat[r][c] == 1) {
                    result[r][c] = Integer.MAX_VALUE;
                } else {
                    result[r][c] = 0;
                    queue.add(new int[]{r,c});
                }
            }
        }
        
        int[][] dirs = {{-1,0},{0,-1},{0,1},{1,0}};
        while(!queue.isEmpty()) {
            int[] curr = queue.remove();
            int rowCurr = curr[0];
            int colCurr = curr[1];
            for(int[] dir: dirs) {
                int rowNext = rowCurr+dir[0];
                int colNext = colCurr+dir[1];
                
                if(!isOutOfBounds(mat, rowNext, colNext)) {
                    if(result[rowNext][colNext] > result[rowCurr][colCurr] + 1) {
                        result[rowNext][colNext] = result[rowCurr][colCurr] + 1;
                        queue.add(new int[]{rowNext, colNext});
                    }
                }
            }
        }
        return result;
    }
    
    private boolean isOutOfBounds(int[][] mat, int r, int c) {
        return (r<0 || c<0 || r>=mat.length || c >= mat[0].length);
    }
}
