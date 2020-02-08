import java.util.*;
import java.io.*;


class Search2DMatrix {

	public static boolean search(int[][] matrix, int target) {
		for (int i=0; i<matrix.length; i++) {
			int l = 0;
			int h = matrix[i].length-1;

			while (l<=h) {
				int mid = (l+h)/2;

				if (matrix[i][mid] < target) {
					l = mid+1;
				} else if (matrix[i][mid] > target) {
					h = mid-1;
				} else {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[][] matrix = {{1,4,7,11,15}, {2,5,8,12,19}, {3,6,9,16,22}, {10,13,14,17,24}, {18,21,23,26,30}};

		// for (int i=0; i<matrix.length; i++) {
		// 	for (int j=0; j<matrix[i].length; j++) {
		// 		System.out.print(matrix[i][j] + " ");
		// 	}
		// 	System.out.println();
		// }
		int target = sc.nextInt();
		boolean ans = search(matrix, target);
		System.out.println(ans);
	}
}