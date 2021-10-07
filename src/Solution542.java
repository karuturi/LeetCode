import java.util.Queue;
import java.util.LinkedList;

/*
* https://leetcode.com/problems/01-matrix/
*/
public class Solution542 {
    public static void main(String[] args) {
        // int[][] mat = {{0,0,0},{0,1,0},{0,0,0}};
        int[][] mat = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };
        Solution542 solution = new Solution542();
        printMatrix(mat);
        printMatrix(solution.updateMatrixDP(mat));
    }

    private static void printMatrix(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println("] ");
        }
        System.out.println();
    }

    public int[][] updateMatrixDP(int[][] mat) {
        int max = 10000000;
        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[0].length; col++) {
                if (mat[row][col] != 0) {
                    int top = max;
                    int left = max;
                    if (row > 0) {
                        top = mat[row - 1][col];
                    }
                    if (col > 0) {
                        left = mat[row][col - 1];
                    }
                    mat[row][col] = Math.min(left, top) + 1;
                }
            }
        }
        for (int row = mat.length - 1; row >= 0; row--) {
            for (int col = mat[0].length - 1; col >= 0; col--) {
                int right = max;
                int bottom = max;
                if (row < mat.length - 1) {
                    right = mat[row + 1][col];
                }
                if (col < mat[0].length - 1) {
                    bottom = mat[row][col + 1];
                }
                mat[row][col] = Math.min(mat[row][col], Math.min(right, bottom) + 1);
            }
        }
        return mat;
    }

    public int[][] updateMatrixBFS(int[][] mat) {

        int[][] result = new int[mat.length][mat[0].length];

        Queue<int[]> queue = new LinkedList<>();

        for (int r = 0; r < mat.length; r++) {
            for (int c = 0; c < mat[0].length; c++) {
                if (mat[r][c] == 1) {
                    result[r][c] = Integer.MAX_VALUE;
                } else {
                    result[r][c] = 0;
                    queue.add(new int[] { r, c });
                }
            }
        }

        int[][] dirs = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };
        while (!queue.isEmpty()) {
            int[] curr = queue.remove();
            int rowCurr = curr[0];
            int colCurr = curr[1];
            for (int[] dir : dirs) {
                int rowNext = rowCurr + dir[0];
                int colNext = colCurr + dir[1];

                if (!isOutOfBounds(mat, rowNext, colNext)) {
                    if (result[rowNext][colNext] > result[rowCurr][colCurr] + 1) {
                        result[rowNext][colNext] = result[rowCurr][colCurr] + 1;
                        queue.add(new int[] { rowNext, colNext });
                    }
                }
            }
        }
        return result;
    }

    private boolean isOutOfBounds(int[][] mat, int r, int c) {
        return (r < 0 || c < 0 || r >= mat.length || c >= mat[0].length);
    }
}
