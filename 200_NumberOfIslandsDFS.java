import java.io.*;
import java.util.*;

class NumberOfIslandsDFS {

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

	public static void DFS(char[][] grid, Point source) {

		if (!isValid(source.x, source.y, grid.length, grid[0].length) || grid[source.x][source.y] == '0') {
			return;
		}

		grid[source.x][source.y] = '0';

	
		for (int i=0; i<dir.length; ++i) {
			int newX = source.x + dir[i][0];
			int newY = source.y + dir[i][1];

			DFS(grid, new Point(newX, newY));
		}
		
	}

	public static int numOfIslands(char[][] grid) {

		int count = 0;

		for (int i = 0; i<grid.length; i++) {
			for (int j=0; j<grid[i].length; j++) {
				if (grid[i][j] == '1') {
					count++;
					DFS(grid, new Point(i,j));
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