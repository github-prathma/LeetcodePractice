import java.util.*;
import java.io.*;

class SourceToDest {

    public static boolean dfs(LinkedList<Integer>[] adj, int s, int d, int[] visited) {
        if (s != d && adj[s].size() == 0) {
            return false;
        }
        for (int v: adj[s]) {
            if (visited[v] == 1) {
                return false;
            }
            visited[v] = 1;
            if (!dfs(adj, v, d, visited)) {
                return false;
            }
            visited[v] = 0;
        }
        return true;
    }

    public static boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        LinkedList<Integer>[] adj = new LinkedList[n];
        
        for (int i=0; i<n; i++) {
            adj[i] = new LinkedList<>();
        }

        for (int i=0; i<edges.length; i++) {
            adj[edges[i][0]].offerLast(edges[i][1]);
        }
        
        int[] visited = new int[n];
        for (int i=0; i<n; i++) {
            visited[i] = 0;
        }
        visited[source] = 1;

        boolean finitePaths = dfs(adj, source, destination, visited);
        return finitePaths;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line1 = br.readLine();
        int noOfVertices = Integer.parseInt(line1);

        String line2 = br.readLine();
        int noOfEdges = Integer.parseInt(line2);

        int[][] edges = new int[noOfEdges][2];
        for (int i=0; i<noOfEdges; i++) {
            String line = br.readLine();
            String[] vs = line.split(" ");
            for (int j=0; j<vs.length; j++) {
                edges[i][j] = Integer.parseInt(vs[j]);
            }
        }

        System.out.println("Source:");
        String line3 = br.readLine();
        int source = Integer.parseInt(line3);

        System.out.println("Destination:");
        String line4 = br.readLine();
        int dest = Integer.parseInt(line4);

        boolean ans = leadsToDestination(noOfVertices, edges, source, dest);
        System.out.println(ans);
    }
}