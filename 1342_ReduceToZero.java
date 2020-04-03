import java.util.*;
import java.io.*;

class ReduceToZero {

	public static int numberOfSteps(int num) {
		String binary = Integer.toBinaryString(num);

		int steps = 0;
		for (char bit : binary.toCharArray()) {
			if (bit == '1') {
				steps+=2;
			} else {
				steps+=1;
			}
		}
		return steps-1;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int ans = numberOfSteps(n);
		System.out.println(ans);

	}
}