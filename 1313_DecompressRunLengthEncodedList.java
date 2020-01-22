import java.util.*;
import java.io.*;

class DecompressList {
	public static int[] decompressRLElist(int[] nums) {
        List<Integer> res = new ArrayList<>();
        
        int i = 0;
        
        while (((2*i)+1) < nums.length) {
            int x = 2*i;
            int y = (2*i)+1;
            for (int k=1; k<=nums[x]; k++) {
                res.add(nums[y]);
            }
            i++;
        }
        
        return res.stream().mapToInt(Integer::intValue).toArray();
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