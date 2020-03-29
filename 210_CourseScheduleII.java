import java.util.*;
import java.io.*;

class CourseScheduleII {

	public static int[] findOrder(int numCourses, int[][] prerequisites) {

		HashMap<Integer, List<Integer>> adjacency = new HashMap<>();
		HashMap<Integer, Integer> inDegreesOfNode = new HashMap<>();

		for (int i=0; i<prerequisites.length; i++) {
			if (adjacency.containsKey(prerequisites[i][1])) {
				adjacency.get(prerequisites[i][1]).add(prerequisites[i][0]);
			} else {
				List<Integer> adjNodes = new ArrayList<>();
				adjNodes.add(prerequisites[i][0]);
				adjacency.put(prerequisites[i][1], adjNodes);
			}

			inDegreesOfNode.put(prerequisites[i][0], inDegreesOfNode.getOrDefault(prerequisites[i][0], 0)+1);

		}

		// System.out.println(inDegreesOfNode);

		Queue<Integer> q = new LinkedList<>();

		for (int i=0; i<numCourses; i++) {
			if (!inDegreesOfNode.containsKey(i)) {
				q.offer(i);
			}
		}

		List<Integer> coursesOrder = new ArrayList<>();

		while (!q.isEmpty()) {
			int currCourse = q.poll();
			coursesOrder.add(currCourse);

			if (adjacency.containsKey(currCourse)) {
				List<Integer> connectedNodes = adjacency.get(currCourse);
				for (Integer node : connectedNodes) {
					inDegreesOfNode.put(node, inDegreesOfNode.get(node)-1);
					if (inDegreesOfNode.get(node) == 0) {
						q.offer(node);
					}
				}
			}
		}
		// System.out.println(coursesOrder);

		if (coursesOrder.size() != numCourses) {
			return (new int[0]);
		}

		return coursesOrder.stream().mapToInt(Integer::intValue).toArray();
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Number of nodes: ");

		int n = Integer.parseInt(br.readLine());

		System.out.println("Number of edges: ");

		int e = Integer.parseInt(br.readLine());

		int[][] prereqs = new int[e][2];

		for (int i=0; i<e; ++i) {
			String s = br.readLine();
			String[] nodes = s.split(" ");

			prereqs[i][0] = Integer.parseInt(nodes[0]);
			prereqs[i][1] = Integer.parseInt(nodes[1]);
		}

		int[] ans = findOrder(n, prereqs);
		for (int i=0; i<ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
		System.out.println();
	}
}