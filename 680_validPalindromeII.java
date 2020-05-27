import java.util.*;
import java.io.*;

class ValidPalindrome {

	public static boolean isPalin(String s, int l, int r) {

		while (l<=r) {
			if (s.charAt(l) != s.charAt(r)) {
				return false;
			}
			l++;
			r--;
		}
		return true;
	}

 	public static boolean validPalindrome(String s) {
        
        int r = s.length()-1;
        int l = 0;

        while (l <= r) {
        	if (s.charAt(l) != s.charAt(r)) {
        		return (isPalin(s, l+1, r) || isPalin(s, l, r-1));
        	} else {
        		l++;
        		r--;
        	}
        }
        return true;
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.nextLine();

		boolean ans = validPalindrome(s);
		System.out.println(ans);
	}
}