import java.util.*;
import java.io.*;

class MergeIntervals {

	public static class Interval {
		int x;
		int y;
		Interval (int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static int[][] merge(int[][] intervals) {
		List<Interval> input = new ArrayList<>();
		Set<Interval> result = new HashSet<>();
		if (intervals.length == 0) {
            return new int[0][2];
        }

		for (int i=0; i<intervals.length; ++i) {
			input.add(new Interval(intervals[i][0], intervals[i][1]));
		}

		Collections.sort(input, new Comparator<Interval>() {
           @Override
            public int compare(Interval a, Interval b) {
                int diff = a.x - b.x;
                return diff;
            }
        });
		Interval p = input.get(0);

		for (int i=1; i<input.size(); ++i) {
			if (input.get(i).x <= p.y && input.get(i).y >= p.x) {
                p.x = Math.min(p.x, input.get(i).x);
				p.y = Math.max(p.y, input.get(i).y);
			} else {
				// System.out.println("gdg === " + p.x + " " + p.y);
				result.add(p);
				p = input.get(i);
			}
		}
		result.add(p);
		int[][] ans = new int[result.size()][2];

        int i = 0;
        for (Interval intS : result) {
            ans[i][0] = intS.x;
            ans[i][1] = intS.y;
            i++;
        }
		return ans;	
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("No. of intervals : ");

		int n = Integer.parseInt(br.readLine());

		int[][] intervals = new int[n][2];

		for (int i=0; i<n; i++) {
			String s = br.readLine();
			String[] strNums = s.split(" ");
			intervals[i][0] = Integer.parseInt(strNums[0]);
			intervals[i][1] = Integer.parseInt(strNums[1]);
		}

		int[][] ans = merge(intervals);
		for (int[] i : ans) {
			System.out.println(i[0] + " " + i[1]);
		}
	}
}