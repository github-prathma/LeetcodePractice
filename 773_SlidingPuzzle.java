import java.io.*;
import java.util.*;

class SlidingPuzzle {

	static int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1, 0}};
	static int[][] outputBoard = {{1,2,3}, {4,5,0}};

	public static class BoardState {
		int x;
		int y;
		int[][] board;
		int moves;

		public BoardState(int xcoord, int ycoord, int[][] currBoard, int currMoves) {
			this.x = xcoord;
			this.y = ycoord;
			this.board = currBoard;
			this.moves = currMoves;
		}
	}

// can use Arrays.deepToString to add 2d array in hashset
	public static String getVisitedBoardKey(int[][] board) {
		StringBuilder sb = new StringBuilder();

		sb.append("[");

		for (int i=0; i<board.length; i++) {
			sb.append(Arrays.toString(board[i]) + ", ");
		}

		sb.deleteCharAt(sb.length()-1);
		sb.deleteCharAt(sb.length()-1);

		sb.append("]");

		return sb.toString();
	}

	public static boolean isValid(int newX, int newY, int rows, int cols) {

		if (newX < 0 || newX >= rows) {
			return false;
		}

		if (newY < 0 || newY >= cols) {
			return false;
		}

		return true;
	}

	public static boolean isSolved(int[][] board) {
		for (int i=0; i<board.length; ++i) {
			for (int j=0; j<board[i].length; ++j) {
				if (outputBoard[i][j] != board[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	public static int slidingPuzzle(int[][] board) {
		int zeroX = -1;
		int zeroY = -1;

		boolean zeroFound = false;
		for (int i=0; i<board.length; i++) {
			for (int j=0; j<board[0].length; j++) {
				if (board[i][j] == 0) {
					zeroX = i;
					zeroY = j;
					zeroFound = true;
					break;
				}
			}
			if (zeroFound == true) {
				break;
			}
		}

		Queue<BoardState> q = new LinkedList<>();

		HashSet<String> visited = new HashSet<>();

		q.add(new BoardState(zeroX, zeroY, board, 0));
		visited.add(getVisitedBoardKey(board));


		while (!q.isEmpty()) {
			BoardState currState = q.poll();

			if (isSolved(currState.board)) {
				return currState.moves;
			}

			for (int i=0; i<4; i++) {
				int newX = currState.x + dirs[i][0];
				int newY = currState.y + dirs[i][1];

				if (isValid(newX, newY, board.length, board[0].length)) {

					int[][] boardCopy = new int[2][3];
					for (int r=0; r<currState.board.length; r++) {
						for (int c=0; c<currState.board[0].length; c++) {
							boardCopy[r][c] = currState.board[r][c];
						}
					}

					// System.out.println(currState.x + " " + currState.y);
					int tmp = boardCopy[currState.x][currState.y];
					boardCopy[currState.x][currState.y] = boardCopy[newX][newY];
					boardCopy[newX][newY] = tmp;

					String currKey = getVisitedBoardKey(boardCopy);

					if (!visited.contains(currKey)) {
						q.add(new BoardState(newX, newY, boardCopy, currState.moves+1));
						visited.add(currKey);
					}
				}

			}
		}
		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] board = new int[2][3];

		for (int i=0; i<board.length; i++) {
			String s = br.readLine();
			String[] sArr = s.split(" ");
			for (int j=0; j<board[0].length; j++) {
				board[i][j] = Integer.parseInt(sArr[j]);
			}
		}

		int minMoves = slidingPuzzle(board);
		System.out.println(minMoves); 
	}
}