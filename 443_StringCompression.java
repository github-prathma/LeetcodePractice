import java.util.*;
import java.io.*;

class StringCompression {

	public static int compress(char[] chars) {
        if (chars.length == 1) {
            return 1;
        }
        int l = 1;
        int count = 1;
        int len = 0;
        
        while (l < chars.length) {
            if (chars[l] == chars[l-1]) {
                count++;
            } else {
                chars[len++] = chars[l-1];

                if (count > 1) {
                    for (char c : ("" + count).toCharArray()) {
                        chars[len++] = c;
                    }
                }
                count = 1;
            }
            l++;
        }
        
        if (count > 1) {
            chars[len++] = chars[l-1];

            for (char c : ("" + count).toCharArray()) {
                chars[len++] = c;
            }
        } else {
            chars[len++] = chars[l-1];
        }
        return len;
    }

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		//char array
		String inp = sc.next();

		char arr[] = new char[inp.length()];

		for (int i=0; i<inp.length(); i++) {
			arr[i] = inp.charAt(i);
		}

		int lenOfCompressed = compress(arr);

		// for (char c: arr) {
		// 	System.out.print(c + " ");
		// }
		// System.out.println();

		System.out.println(lenOfCompressed);

	}
}