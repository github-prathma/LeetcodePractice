import java.util.*;
import java.io.*;

class DoingHomework {

	 public static int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        
        int count=0;
        for (int i=0; i<startTime.length; i++) {
            if (queryTime >= startTime[i] && queryTime <= endTime[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter size of an array");
		int n = sc.nextInt();

		int[] startTime = new int[n];
		for (int i=0; i<n; i++) {
			startTime[i] = sc.nextInt();
		}
		
		int[] endTime = new int[n];
		for (int i=0; i<n; i++) {
			endTime[i] = sc.nextInt();
		}

		System.out.println("Enter queryTime:");

		int queryTime = sc.nextInt();

		int ans = busyStudent(startTime, endTime, queryTime);
		System.out.println(ans);

	}
}