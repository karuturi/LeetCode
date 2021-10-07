
/**
 * https://leetcode.com/problems/rotting-oranges/
 */
import java.util.Queue;
import java.util.LinkedList;

public class Solution994 {

    public static void main(String[] args) {
        Solution994 solution = new Solution994();
        int[][][] grids = { 
            { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } }, 
            { { 2, 1, 1 }, { 0, 1, 1 }, { 1, 0, 1 } },
            { { 0, 2 } }, 
            { { 0, 1 } }, 
            { { 0 } } 
        };
        for(int[][] grid: grids) {
            System.out.println(solution.orangesRotting(grid));
        }
    }

    public int orangesRotting(int[][] grid) {
        int nRows = grid.length;
        int mCols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        int goodOranges = 0;
        for (int row = 0; row < nRows; row++) {
            for (int col = 0; col < mCols; col++) {
                if (grid[row][col] == 2) {
                    queue.add(new int[] { row, col });
                }
                if (grid[row][col] == 1) {
                    goodOranges++;
                }
            }
        }
        int level = 0;
        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
        if (queue.isEmpty() && goodOranges == 0) {
            return level;
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] currCell = queue.remove();
                for (int[] dir : dirs) {
                    int adjRow = currCell[0] + dir[0];
                    int adjCol = currCell[1] + dir[1];
                    if (!isOutOfBounds(grid, adjRow, adjCol) && grid[adjRow][adjCol] == 1) {
                        queue.add(new int[] { adjRow, adjCol });
                        grid[adjRow][adjCol] = 2;
                    }
                }
            }
            level++;
        }
        for (int row = 0; row < nRows; row++) {
            for (int col = 0; col < mCols; col++) {
                if (grid[row][col] == 1) {
                    return -1;
                }
            }
        }

        return level - 1;

    }

    private boolean isOutOfBounds(int[][] grid, int row, int col) {
        return row < 0 || col < 0 || row > grid.length - 1 || col > grid[0].length - 1;
    }
}
