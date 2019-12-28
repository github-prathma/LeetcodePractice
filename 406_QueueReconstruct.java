import java.util.*;
import java.io.*;

class QueueReconstructByHeights {

    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1]-o2[1];
                } else {
                    return o2[0]-o1[0];
                }
            }
        });

        System.out.println("sorted array");
        for (int i=0; i<people.length; i++) {
            for (int j=0; j<2; j++) {
                System.out.print(people[i][j] + " ");
            }
            System.out.println();
        }

        List<int[]> ans = new ArrayList<>();

        for (int[] p : people) {
            ans.add(p[1], p);
        }


        return ans.toArray(new int[people.length][2]);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] hi = new int[n][2];
        for (int i=0; i<n; ++i) {
            String s = br.readLine();
            String[] s1 = s.split(" ");
            hi[i][0] = Integer.parseInt(s1[0]);
            hi[i][1] = Integer.parseInt(s1[1]);
        }

        int[][] ans = reconstructQueue(hi);
        for (int i=0; i<n; ++i) {
            for (int j=0; j<2; ++j) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}