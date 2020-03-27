import java.util.*;
import java.io.*;

class HandsOfStraights {

	public static boolean isNStraightHand(int[] hand, int W) {
		TreeMap<Integer, Integer> tp = new TreeMap<>();

		for (int i=0; i<hand.length; ++i) {
			tp.put(hand[i], tp.getOrDefault(hand[i], 0)+1);
		}

		while (tp.size() > 0) {
			int currHand = tp.firstKey();

			for (int k=currHand; k<currHand+W; k++) {
				if (!tp.containsKey(k)) {
					return false;
				}

				if (tp.get(k) == 1) {
					tp.remove(k);
				}

				if (tp.containsKey(k)) {
					tp.put(k, tp.get(k)-1);
				}

			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		String[] sArr = s.split(" ");

		int[] hand = new int[sArr.length];

		for (int i=0; i<hand.length; ++i) {
			hand[i] = Integer.parseInt(sArr[i]);
		}

		int maxGroups = Integer.parseInt(br.readLine());

		boolean ans = isNStraightHand(hand, maxGroups);
		System.out.println(ans);
	}
}