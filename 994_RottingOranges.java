import java.util.*;
import java.io.*;

class RottingOranges {

	static class Cell {
		int x;
		int y;
		public Cell(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};

	public static boolean isValid(int x,int y, int rows, int cols) {
		if (x < 0 || x >= rows) {
			return false;
		}

		if (y < 0 || y >= cols) {
			return false;
		}
		return true;
	}

	public static int rotting(int[][] grid) {

		Queue<Cell> q = new LinkedList<>();

		for (int i=0; i<grid.length; i++) {
			for (int j=0; j<grid[i].length; j++) {
				if (grid[i][j] == 2) {
					q.add(new Cell(i,j));
				}
			}
		}

		int depth = 0;

		while (!q.isEmpty()) {
			int qsize = q.size();

			for (int qind = 0; qind<qsize; qind++) {
				Cell curr = q.poll();

				for (int i=0; i<dirs.length; i++) {
					int r = curr.x + dirs[i][0];
					int c = curr.y + dirs[i][1];

					if (isValid(r,c,grid.length, grid[0].length) && grid[r][c] == 1) {
						grid[r][c] = 2;
						q.add(new Cell(r,c));
					}
				}
			}
			depth+=1;
			
		}
		for (int[] row : grid) {
			for (int orange : row) {
				if (orange == 1) {
					return -1;
				}
			}
		}
 		if (depth == 0) {
            return depth;
        }
		return depth-1;	
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Enter rows and columns:");

		int m = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine()); 

		int[][] board = new int[m][n];

		for (int i=0; i<m; i++) {
			String s = br.readLine();
			String[] sArr = s.split(" ");
			for (int j=0; j<n; j++) {
				board[i][j] = Integer.parseInt(sArr[j]);
			}
		}

		int ans = rotting(board);
		System.out.println(ans);
	}
}