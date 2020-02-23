import java.util.*;
import java.io.*;

//greedy like allocating platform to trains arriving and leaving on times.
class MeetingRoomsII {

	public static int minMeetingRooms(int[][] intervals) {
		if (intervals.length == 0) {
            return 0;
        }
		List<Integer> startTimes = new ArrayList<>();
		List<Integer> endTimes = new ArrayList<>();

		for (int i=0; i<intervals.length; i++) {
			startTimes.add(intervals[i][0]);
			endTimes.add(intervals[i][1]);
		}

		Collections.sort(startTimes);
		Collections.sort(endTimes);

		int sp = 0;
		int ep = 0;

		int rooms = 0;
		while (sp < startTimes.size()) {
			if (startTimes.get(sp) < endTimes.get(ep)) {
				rooms++;
				sp++;
			}

			else if (startTimes.get(sp) >= endTimes.get(ep)) {
				ep++;
				sp++;
			}
		}

		return rooms;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] schedules = new int[n][2];

		for (int i=0; i<n; i++) {
			String s = br.readLine();
			String[] strArr = s.split(" ");
			schedules[i][0] = Integer.parseInt(strArr[0]);
			schedules[i][1] = Integer.parseInt(strArr[1]);
		}

		int ans = minMeetingRooms(schedules);
		System.out.println(ans);
	}
}