import java.util.*;
import java.io.*;


class BFSMethod2 {
    class Point {
        int x;
        int y;
    
        Point(int i, int j) {
            this.x = i;
            this.y = j;
        }
    }

    public int maxDistance(int[][] grid) {
        int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int[][] cost = new int[grid.length][grid.length];

        for (int i=0; i<cost.length; ++i) {
            for (int j=0; j<cost.length; ++j) {
                cost[i][j] = Integer.MAX_VALUE;
            }
        }
        Queue<Point> q = new LinkedList<>();

        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid.length; j++) {
                if (grid[i][j] == 1) {
                    q.add(new Point(i,j));
                    cost[i][j] = 0;
                }
            }
        }

        if (q.size() == 0 || q.size() == grid.length*grid.length) {
            return -1;
        }
        while(!q.isEmpty()) {
            Point p = q.peek();
            q.remove();

            for (int i=0; i<4; i++) {
                int nx = p.x+dirs[i][0];
                int ny = p.y+dirs[i][1];

                if (nx < 0 || nx >= grid.length || ny < 0 || ny >= grid.length || grid[nx][ny] == 1) {
                    continue;
                } else {
                    if (cost[p.x][p.y]+1 < cost[nx][ny]) {
                        cost[nx][ny] = cost[p.x][p.y] + 1;
                        q.add(new Point(nx, ny));
                    }
                }
            }
        }

        int maxDist = 0;
        for (int i=0; i<cost.length; ++i) {
            for (int j=0; j<cost.length; ++j) {
                if (cost[i][j] > maxDist) {
                    maxDist = cost[i][j];
                }
            }
        }
        return maxDist;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] grid = new int[n][n];

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        BFSMethod2 bfs = new BFSMethod2();
        int ans = bfs.maxDistance(grid);
        System.out.println(ans);
        sc.close();
    }
}