import java.util.*;
import java.io.*;

class AvailableCaptures {
    public static int rookCaptures(char[][] board) {
        int rookX = -1;
        int rookY = -1;

        int captures = 0;

        boolean rookFound = false;
        for (int i=0; i<board.length; ++i) {
            for (int j=0; j<board.length; ++j) {
                if (board[i][j] == 'R') {
                    rookX = i;
                    rookY = j;
                    rookFound = true;
                    break;
                }
            }
            if (rookFound) {
                break;
            }
        }

        int r1 = rookX;
        while (r1 >= 0) {
            if (board[r1][rookY] == 'p') {
                captures++;
                break;
            } else if (board[r1][rookY] == 'B') {
                break;
            }
            r1--;
        }

        int r2 = rookX;
        while (r2 < board.length) {
            if (board[r2][rookY] == 'p') {
                captures++;
                break;
            } else if (board[r2][rookY] == 'B') {
                break;
            }
            r2++;
        }

        int y1 = rookY;
        while (y1 >= 0) {
            if (board[rookX][y1] == 'p') {
                captures++;
                break;
            } else if (board[rookX][y1] == 'B') {
                break;
            }
            y1--;
        }

        int y2 = rookY;
        while (y2 < board.length) {
            if (board[rookX][y2] == 'p') {
                captures++;
                break;
            } else if (board[rookX][y2] == 'B') {
                break;
            }
            y2++;
        }
        return captures;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[][] board = new char[8][8];

        for (int i=0; i<8; i++) {
            for (int j=0; j<8; j++) {
                board[i][j] = sc.next().charAt(0);
            }
        }

        int ans = rookCaptures(board);
        System.out.println(ans);
        sc.close();
    }
}