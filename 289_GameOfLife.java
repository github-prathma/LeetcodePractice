import java.util.*;
import java.io.*;

class GameOfLife {

	static int[][] dir = {{-1, 0}, {1,0}, {0, -1}, {0,1}, {1,1}, {1,-1}, {-1,1}, {-1,-1}};

	public static boolean isValid(int x, int y, int rows, int cols) {
		if (x < 0 || x >= rows) {
			return false;
		}

		if (y < 0 || y >= cols) {
			return false;
		}

		return true;
	}

	public static void game(int[][] board) {
		int m = board.length;
		int n = board[0].length;

		int[][] temp = new int[board.length][board[0].length];

		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				temp[i][j] = board[i][j];
			}
		}

		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {

				int liveNgs = 0;
				for (int k=0; k<dir.length; k++) {
					int ngr = i + dir[k][0];
					int ngc = j + dir[k][1];

					if (isValid(ngr, ngc, m, n) && !(ngr == i && ngc == j)) {
						if (temp[ngr][ngc] == 1) {
							liveNgs++;
						}
					}
				}

				if (temp[i][j] == 1) {
					if (liveNgs < 2 || liveNgs > 3) {
						board[i][j] = 0;
					} else {
						board[i][j] = 1;
					}
				} else {
					if (liveNgs == 3) {
						board[i][j] = 1;
					} else {
						board[i][j] = 0;
					}
				}
			}
		}

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

		game(board);

		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}

	}
}