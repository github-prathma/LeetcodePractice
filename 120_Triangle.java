import java.util.*;
import java.io.*;

class Triangle {

	public static int minTotal(List<List<Integer>> triangle) {

        int nrows = triangle.size();
        
        if (nrows == 1) {
            return triangle.get(0).get(0);
        }
        int[] dp = new int[triangle.get(nrows-1).size()];
        
        dp[0] = triangle.get(0).get(0);
        
        for (int i=1; i<nrows; i++) {
            List<Integer> currRow = triangle.get(i);
            
            List<Integer> newRow = new ArrayList<>();
            
            for(int j=0; j<triangle.get(i).size(); j++) {
               
                    if (j==0) {
                        dp[j] = triangle.get(i).get(j) + triangle.get(i-1).get(j);
                    } else if (j==triangle.get(i).size()-1) {
                        dp[j] = triangle.get(i).get(j) + triangle.get(i-1).get(j-1);
                    } else {
                        dp[j] = triangle.get(i).get(j) + Math.min(triangle.get(i-1).get(j-1), triangle.get(i-1).get(j));
                    }
                    newRow.add(dp[j]);
            }
            triangle.remove(currRow);
            triangle.add(i, newRow);
        }
        System.out.println(triangle);
        
        int sum = dp[0];
        for (int i=1; i<dp.length; i++) {
            sum = Math.min(sum, dp[i]);
        }
        
        return sum;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter number of rows:");

		int nrows = sc.nextInt();

		List<List<Integer>> triangle = new ArrayList<>();

		for (int i=0; i<nrows; i++) {

			List<Integer> row = new ArrayList<>();

			for (int j=0; j<i+1; j++) {
				int el = sc.nextInt();
				row.add(el);
			}
			triangle.add(row);
		}

		int ans = minTotal(triangle);
		System.out.println(ans);
	}
}