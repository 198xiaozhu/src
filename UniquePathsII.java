/**
 * Created by Christina on 2/21/16.
 */
public class UniquePathsII {

    /**
     * use dp
     * for each place, if it has the obstacle, set the item = 0
     * else, adds [i-1][j] and [i][j-1]
     * */

    //O(m * n), O(1)
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length < 1 || obstacleGrid[0].length < 1) return 0;
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] paths = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    paths[i][j] = 0;
                } else if (i == 0 && j == 0) {
                    paths[i][j] = 1;
                } else if (i == 0) {
                    paths[i][j] = paths[i][j-1];
                } else if (j == 0) {
                    paths[i][j] = paths[i - 1][j];
                } else {
                    paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
                }
            }
        }
        return paths[m-1][n-1];
    }

    public static void main(String[] arg) {
        UniquePathsII a = new UniquePathsII();
        int[][] grid = new int[][]{
                {0, 0, 0}, {0, 1, 0}, {0, 0, 0}
        };
        System.out.println(a.uniquePathsWithObstacles(grid));
        grid = new int[][]{
                {0, 0, 1}, {0, 0, 0}, {1, 0, 0}
        };
        System.out.println(a.uniquePathsWithObstacles(grid));
    }
}
