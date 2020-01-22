import java.util.*;
import java.io.*;

class DecompressEList {
	public static int[] decompressRLElist(int[] nums) {
        int sum = 0;
        for (int i=0; i<nums.length; i+=2) {
        	sum = sum + nums[i];
        }

        int[] res = new int[sum];
        int pos = 0;

        for (int i=1; i<nums.length; i+=2) {
        	int len = nums[i-1];
        	while (len != 0) {
        		res[pos++] = nums[i];
        		len--;
        	}
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		String[] str = s.split(" ");

		int[] nums = new int[str.length];

		for (int i=0; i<nums.length; ++i) {
			nums[i] = Integer.parseInt(str[i]);
		}

		int[] ans = decompressRLElist(nums);

		for (int x : ans) {
			System.out.print(x + " ");
		}
		System.out.println();
	}

}