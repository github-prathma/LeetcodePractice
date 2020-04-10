import java.util.*;
import java.io.*;

class ReorderLogFiles {

	public static class LogsComparator implements Comparator<String> {
 
    	@Override
    	public int compare(String log1, String log2) {
    		String[] log1split = log1.split(" ", 2);
    		String[] log2split = log2.split(" ", 2);

            boolean isDigit1 = Character.isDigit(log1split[1].charAt(0));
            boolean isDigit2 = Character.isDigit(log2split[1].charAt(0));
            
    		if (!isDigit1 && !isDigit2) {
    			if (log1split[1].compareTo(log2split[1]) == 0) {
    				return log1split[0].compareTo(log2split[0]);
    			}
    			return log1split[1].compareTo(log2split[1]);
    		}
    		if (isDigit1 && isDigit2) {
                return 0;
            } else if (isDigit1 && !isDigit2) {
                return 1;
            } else {
                return -1;
            }    	}
	}

	public static String[] reorderLogFiles(String[] logs) {
    	Arrays.sort(logs, new LogsComparator());   
		String[] ans = new String[logs.length];
        int ind=0;
        for (int i=0; i<logs.length; i++) {
            String[] logsplit = logs[i].split(" ", 2);
            if (!Character.isDigit(logsplit[1].charAt(0))) {
                ans[ind++] = logs[i];
            }
        }
        for (int i=0; i<logs.length; i++) {
            String[] logsplit = logs[i].split(" ", 2);
            if (Character.isDigit(logsplit[1].charAt(0))) {
                ans[ind++] = logs[i];
            }
        }
    	return ans;    }

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Enter number of strings");
		int n = Integer.parseInt(br.readLine());

		String[] logs = new String[n];

		for (int i=0; i<n; i++) {
			String s = br.readLine();
			logs[i] = s;
		}

		String[] ans = reorderLogFiles(logs);

		for (String a : ans) {
			System.out.print(a + " ");
		}
		System.out.println();
	}
}