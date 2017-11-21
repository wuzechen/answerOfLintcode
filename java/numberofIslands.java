public class Solution {
    /*
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    public int numIslands(boolean[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int result = 0;
        int n = grid.length;
        int m = grid[0].length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j]) {
                    convertRound(grid, i, j);
                    result++;
                }
            }
        }
        
        return result;
    }
    
    private void convertRound(boolean[][] grid, int x, int y) {
        
        int[] moveX = {0,1,-1,0};
        int[] moveY = {1,0,0,-1};
        
        Queue<pair> points = new LinkedList<>();
        points.offer(new pair(x, y));
        grid[x][y] = false;
        
        while (!points.isEmpty()) {
            pair point = points.poll();
            for (int i = 0; i < 4; i++) {
                pair newPoint = new pair(point.x + moveX[i], 
                                         point.y + moveY[i]);
                if (!inBound(grid, newPoint)) {
                    continue;
                } 
                if (grid[newPoint.x][newPoint.y]) {
                    grid[newPoint.x][newPoint.y] = false;
                    points.offer(newPoint);
                }
                
            }
        }
    }
    
    private boolean inBound(boolean[][] grid, pair point) {
        return point.x >= 0 && point.x < grid.length &&
               point.y >= 0 && point.y < grid[0].length;
    } 
    
    private class pair {
        int x;
        int y;
        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}