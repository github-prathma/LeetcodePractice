import java.util.*;
import java.io.*;


class BFSMethod {
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

        Queue<Point> q = new LinkedList<>();
        
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid.length; j++) {
                if (grid[i][j] == 1) {
                    Point x = new Point(i,j);
                    q.add(x);
                }
            }
        }

        int maxDistance = -1;
        while (!q.isEmpty()) {
            maxDistance++;
            int l = q.size();

            for (int i=0; i<l; ++i) {
                Point p = q.peek();
                q.remove();

                for (int j=0; j<4; j++) {
                    int newX = p.x + dirs[j][0];
                    int newY = p.y + dirs[j][1];

                    if (newX < 0 || newX >= grid.length || newY < 0 || newY >= grid.length || grid[newX][newY] == 1) {
                        continue;

                    } else {
                        q.add(new Point(newX, newY));
                        grid[newX][newY] = 1;
                    }
                }
            }
        }
        return maxDistance;
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
        BFSMethod bfs = new BFSMethod();
        int ans = bfs.maxDistance(grid);
        System.out.println(ans);
        sc.close();
    }
}