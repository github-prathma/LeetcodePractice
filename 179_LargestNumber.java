import java.io.*;
import java.util.*;

class LargestNumber {
	public static String largestNum(int[] nums) {
        List<String> str = new ArrayList<>();
        
        for (int x : nums) {
            String s = String.valueOf(x);
            str.add(s);
        }
        
        
        
        Collections.sort(str, new Comparator<String>() {
           @Override 
            public int compare(String a,String b) {
                String o1 = a+b;
                String o2 = b+a;
                return o2.compareTo(o1);
            }
        });
        
        if(str.get(0).compareTo("0") == 0) {
            return "0";
        }
        
        StringBuilder res = new StringBuilder();
        for (String st  : str) {
            res.append(st);
        }
        return res.toString();
    }

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		String[] str = s.split(" ");

		int[] nums = new int[str.length];

		for (int i=0; i<nums.length; ++i) {
			nums[i] = Integer.parseInt(str[i]);
		}

		String ans = largestNum(nums);

		System.out.println(ans);
	}

}