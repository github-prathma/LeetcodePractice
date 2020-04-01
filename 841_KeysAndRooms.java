import java.util.*;
import java.io.*;

class KeysAndRooms {

	public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
		Stack<Integer> st = new Stack<>();
		int visitedRooms = rooms.size();

		boolean[] visited = new boolean[rooms.size()];

		st.push(0);
		visited[0] = true;

		while (!st.isEmpty()) {
			Integer currRoom = st.pop();
			visitedRooms--;

			for (Integer key : rooms.get(currRoom)) {
				if (!visited[key]) {
					st.push(key);
					visited[key] = true;
				}
			}
		}
		return (visitedRooms == 0);
 	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Number of rooms: ");

		int n = Integer.parseInt(br.readLine());

		List<List<Integer>> roomsList = new ArrayList<>();

		for (int i=0; i<n; i++) {
			String s = br.readLine();
			String[] sArr = s.split(" ");
			List<Integer> keys = new ArrayList<>();

			for (String k : sArr) {
				Integer currKey = Integer.parseInt(k);
				keys.add(currKey);
			}
			roomsList.add(keys);
		}

		boolean ans = canVisitAllRooms(roomsList);
		System.out.println(ans);
	}
}