import java.util.*;
import java.io.*;

class ShortestPath {

	static class NodeColorEdge {
		int node;
		char color;

		public NodeColorEdge(int node, char color) {
			this.node = node;
			this.color = color;
		}
	}

 	public static int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        	
        HashMap<Integer, List<NodeColorEdge>> adjacency = new HashMap<>();

        for (int i=0; i<red_edges.length; i++) {
        	if (adjacency.containsKey(red_edges[i][0])) {
        		adjacency.get(red_edges[i][0]).add(new NodeColorEdge(red_edges[i][1], 'R'));
        	} else {
        		List<NodeColorEdge> cnodes = new ArrayList<>();
        		cnodes.add(new NodeColorEdge(red_edges[i][1], 'R'));
        		adjacency.put(red_edges[i][0], cnodes);
        	}
        }

        for (int i=0; i<blue_edges.length; i++) {
        	if (adjacency.containsKey(blue_edges[i][0])) {
        		adjacency.get(blue_edges[i][0]).add(new NodeColorEdge(blue_edges[i][1], 'B'));
        	} else {
        		List<NodeColorEdge> cnodes = new ArrayList<>();
        		cnodes.add(new NodeColorEdge(blue_edges[i][1], 'B'));
        		adjacency.put(blue_edges[i][0], cnodes);
        	}
        }

        // System.out.println(adjacency);

        int[] dr = new int[n];
        int[] db = new int[n];
        int[] d = new int[n];


        for (int i=0;i<n; i++) {
        	dr[i] = -1;
        	db[i] = -1;
        }
        dr[0] = 0;
        db[0] = 0;

        //N for no Color
        Queue<NodeColorEdge> q = new LinkedList<>();
        q.add(new NodeColorEdge(0, 'N'));

        while (!q.isEmpty()) {
        	NodeColorEdge currNode = q.poll();

        	if (adjacency.containsKey(currNode.node)) {

        		for (NodeColorEdge cn : adjacency.get(currNode.node)) {
        			// System.out.println(cn.node + " " + cn.color);
        			if (cn.color != currNode.color) {

        				if (cn.color == 'R' && (dr[cn.node] == -1 || dr[cn.node] > db[currNode.node]+1)) {
        					dr[cn.node] = db[currNode.node]+1;
        					q.add(cn);
        				} 
        				if (cn.color == 'B' && (db[cn.node] == -1 || db[cn.node] > dr[currNode.node]+1)) {
        					db[cn.node] = dr[currNode.node]+1;
        					q.add(cn);
        				}
        			}
        		}
        	}
        }

        for (int i=0; i<n; i++) {
        	if (db[i] == -1 && dr[i] == -1) {
        		d[i] = -1;
        	} else if (db[i] == -1 || dr[i] == -1) {
        		d[i] = Math.max(db[i], dr[i]);
        	} else {
        		d[i] = Math.min(db[i], dr[i]);
        	}
        }
        return d;
    }


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int nodes = Integer.parseInt(br.readLine());

		System.out.println("Number of blue edges: ");

		int nb = Integer.parseInt(br.readLine());

		int[][] blueEdges = new int[nb][2];

		for (int i=0; i<nb; i++) {
			String s = br.readLine();
			String[] sArr = s.split(" ");
			blueEdges[i][0] = Integer.parseInt(sArr[0]);
			blueEdges[i][1] = Integer.parseInt(sArr[1]);
		}

		System.out.println("Number of red edges: ");

		int nr = Integer.parseInt(br.readLine());

		int[][] redEdges = new int[nr][2];

		for (int i=0; i<nr; i++) {
			String s = br.readLine();
			String[] sArr = s.split(" ");
			redEdges[i][0] = Integer.parseInt(sArr[0]);
			redEdges[i][1] = Integer.parseInt(sArr[1]);
		}

		int[] ans = shortestAlternatingPaths(nodes, redEdges, blueEdges);
		for (int dist : ans) {
			System.out.print(dist + " ");
		}
		System.out.println();
	}
}