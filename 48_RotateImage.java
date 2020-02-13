import java.util.*;
import java.io.*;

class RotateImage {

	public static void rotate(int[][] matrix) {
		int r = matrix.length;
		int c = matrix[0].length;
		for (int i=0; i<r; i++) {
			for (int j=i; j<c; j++) {
				int t = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = t;
			}
		}


		for (int i=0; i<r; i++) {
			for (int j=0; j<c/2; j++) {
				int t = matrix[i][j];
				matrix[i][j] = matrix[i][c-j-1];
				matrix[i][c-j-1] = t;
			}
		}
	}

	public static void main(String[] args) throws IOException {

		int[][] matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};

		rotate(matrix);

		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
  	}
}