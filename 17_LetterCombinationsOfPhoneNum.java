import java.util.*;
import java.io.*;

class LetterCombinations {

	public static void allCombinations(HashMap<Character, List<Character>> mp, String s, List<String> ans, String digits) {

		if (digits.length() == 0) {
			ans.add(s);
			return;
		} else {
			Character ch = digits.charAt(0);
			List<Character> chStr = mp.get(ch);
			for (Character c : chStr) {
					allCombinations(mp, s+c, ans, digits.substring(1));
			}
		}

	}

	public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) {
            return ans;
        }
        HashMap<Character, List<Character>> mp = new HashMap<>();

        List<Character> list = new ArrayList<>() {{ 
            				add('a'); 
            				add('b');
            				add('c'); 
            				} }; 
        mp.put('2', list);

		list = new ArrayList<>() {{ 
            				add('d'); 
            				add('e');
            				add('f'); 
            				} }; 
        mp.put('3', list);

		list = new ArrayList<>() {{ 
            				add('g'); 
            				add('h');
            				add('i'); 
            				} }; 
        mp.put('4', list);

        list = new ArrayList<>() {{ 
            				add('j'); 
            				add('k');
            				add('l'); 
            				} }; 
        mp.put('5', list);

        list = new ArrayList<>() {{ 
            				add('m'); 
            				add('n');
            				add('o'); 
            				} }; 
        mp.put('6', list);

        list = new ArrayList<>() {{ 
            				add('p'); 
            				add('q');
            				add('r'); 
            				add('s');
            				} }; 
        mp.put('7', list);

        list = new ArrayList<>() {{ 
            				add('t'); 
            				add('u');
            				add('v'); 
            				} }; 
        mp.put('8', list);

        list = new ArrayList<>() {{ 
            				add('w'); 
            				add('x');
            				add('y');
            				add('z'); 
            				} }; 
        mp.put('9', list);

        allCombinations(mp, "", ans, digits);
        return ans;
    }

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String l = br.readLine();
        List<String> ans = letterCombinations(l);

        for (String s : ans) {
        	System.out.print(s + " ");
        }
        System.out.println();
    }

}