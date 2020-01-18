import java.io.*;
import java.util.*;

class DecodeWays {

	public static int decodeNumWays (String s, int n) {
		int k = (s.length()-1)-n;
        if (s.length() > 0 && s.charAt(k) == '0') {
			return 0;
		}

        if (n <= 0) {
			return 1;
		}
		

		Integer x = Integer.parseInt(s.substring(k, k+2)); 

		if (x > 26) {
			return decodeNumWays(s.substring(k+1), n-1);
		}
		return decodeNumWays(s.substring(k+1), n-1)+decodeNumWays(s.substring(k+2), n-2);

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		
		int x = decodeNumWays(s, s.length()-1);
		System.out.println(x);
	}

}