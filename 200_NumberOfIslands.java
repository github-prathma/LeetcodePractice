import java.io.*;
import java.util.*;

class NumberOfIslands {

	static int[][] dir = {{0, 1}, {1,0}, {0,-1}, {-1, 0}};

	public static class Point {
		int x;
		int y;

		Point (int r, int c) {
			this.x = r;
			this.y = c;
		}
	}

	public static boolean isValid(int x, int y, int r, int c) {
		if (x >= 0 && x < r && y >= 0 && y < c) {
			return true;
		}
		return false;
	}

	public static void BFS(char[][] grid, Point source) {

		Queue<Point> q = new LinkedList<>();
		q.add(source);
		grid[source.x][source.y] = '0';

		while (!q.isEmpty()) {
			Point p = q.remove();

			for (int i=0; i<dir.length; ++i) {
				int newX = p.x + dir[i][0];
				int newY = p.y + dir[i][1];

				if (isValid(newX, newY, grid.length, grid[0].length)) {
					if (grid[newX][newY] == '1') {
						q.add(new Point(newX, newY));
						grid[newX][newY] = '0';
					}
				}
			}
		}
	}

	public static int numOfIslands(char[][] grid) {

		int count = 0;

		for (int i = 0; i<grid.length; i++) {
			for (int j=0; j<grid[i].length; j++) {
				if (grid[i][j] == '1') {
					count++;
					BFS(grid, new Point(i,j));
				}
			}
		}
		return count;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int r = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());

		char[][] grid = new char[r][c];
		for (int i=0; i<r; i++) {
			String s = br.readLine();
			char[] ch = s.toCharArray();
			for (int j=0; j<c; j++) {
				grid[i][j] = ch[j];
			}
		}

		int ans = numOfIslands(grid);
		System.out.println(ans);
	}
}