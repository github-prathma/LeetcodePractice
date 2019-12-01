import java.util.*;
import java.io.*;

class CourseSched {
    public static boolean dfsCycle(LinkedList<Integer>[] adj, boolean[] visited, int s) {

        for (int v : adj[s]) {
            if (visited[v]) {
                return true;
            }
            visited[v] = true;
            if (dfsCycle(adj, visited, v)) {
                return true;
            }
            visited[v] = false;
        }
        return false;
    }

    public static boolean canFinish(int numCourses, int[][] prereqs) {
        LinkedList<Integer>[] adj = new LinkedList[numCourses];

        for (int i=0; i<numCourses; ++i) {
            adj[i] = new LinkedList<>();
        }

        for (int i=0; i<prereqs.length; i++) {
            // System.out.println(prereqs[i][0] + " == " + prereqs[i][1]);
            adj[prereqs[i][0]].offerLast(prereqs[i][1]);
        }

        for (int i=0; i<numCourses; ++i) {
            boolean[] visited = new boolean[numCourses];
            visited[i] = true;
            boolean isCycle = dfsCycle(adj, visited, i);
            if (isCycle) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line1 = br.readLine();
        int numCourses = Integer.parseInt(line1);

        System.out.println("Num of prereqs:");
        String line2 = br.readLine();
        int noPrereqs = Integer.parseInt(line2);

        int[][] prereqs = new int[noPrereqs][2];
        
        for (int i=0; i<noPrereqs; ++i) {
            String l = br.readLine();
            String[] vs = l.split(" ");
            prereqs[i][0] = Integer.parseInt(vs[0]);
            prereqs[i][1] = Integer.parseInt(vs[1]);
        }

        boolean canF = canFinish(numCourses, prereqs);
        System.out.println(canF);
    }
}