import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;
import java.util.*;
import java.io.BufferedReader;
import java.Queue;

// bfs solution 45ms

class Matrix01 {
    private class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public boolean isValid(Point p, int numRows, int numCols) {
        if (p.r < 0 || p.r >= numRows || p.c < 0 || p.c >= numCols) {
            return false;
        }
        return true;
    }

    public int[][] adjacent0s(int[][] matrix) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;

        int[][] dist = new int[numRows][numCols];
        int[][] visited = new int[numRows][numCols];

        Queue<Point> bfsQueue = new LinkedList<Point>();

        for (int i=0; i<numRows; i++) {
            for (int j=0; j<numCols; j++) {
                if (matrix[i][j] == 0) {
                    dist[i][j] = 0;
                    bfsQueue.add(new Point(i, j));
                } else {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int newR = 0;
        int newC = 0;

        while (!bfsQueue.isEmpty()) {
            Point p = bfsQueue.poll();
            visited[p.r][p.c] = 1;

            newR = p.r + 1;
            newC = p.c;
            if (isValid(new Point(newR, newC), numRows, numCols) && visited[newR][newC] != 1) {
                dist[newR][newC] = Math.min(dist[newR][newC], dist[p.r][p.c] + 1);
                bfsQueue.add(new Point(newR, newC));
            }

            newR = p.r - 1;
            newC = p.c;
            if (isValid(new Point(newR, newC), numRows, numCols) && visited[newR][newC] != 1) {
                dist[newR][newC] = Math.min(dist[newR][newC], dist[p.r][p.c] + 1);
                bfsQueue.add(new Point(newR, newC));
            }
            
            newR = p.r;
            newC = p.c + 1;
            if (isValid(new Point(newR, newC), numRows, numCols) && visited[newR][newC] != 1) {
                dist[newR][newC] = Math.min(dist[newR][newC], dist[p.r][p.c] + 1);
                bfsQueue.add(new Point(newR, newC));
            }

            newR = p.r;
            newC = p.c - 1;
            if (isValid(new Point(newR, newC), numRows, numCols) && visited[newR][newC] != 1) {
                dist[newR][newC] = Math.min(dist[newR][newC], dist[p.r][p.c] + 1);
                bfsQueue.add(new Point(newR, newC));
            }
        }
        return dist;
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter no. of rows");
        int r = Integer.parseInt(br.readLine());

        System.out.println("Enter no. of cols");
        int c = Integer.parseInt(br.readLine());

        int[][] input = new int[r][c];

        for (int i=0; i<r; i++) {
            String l1 = br.readLine();
            String[] l1Split = l1.split(" ");
            for (int j = 0; j<c; j++) {

                input[i][j] = Integer.parseInt(l1Split[j]);
            }
        }

        System.out.println("Distance matrix");
        Matrix01 m = new Matrix01();
        int[][] dist = m.adjacent0s(input);

        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }      
    }
}
