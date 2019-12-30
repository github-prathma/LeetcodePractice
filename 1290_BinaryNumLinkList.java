import java.util.*;
import java.io.*;

class BinaryNumber {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			this.val = x;
			this.next = null;
		}
	}
	
	public static int decimal(ListNode head) {
		ListNode curr = head;

		int len = 1;
		while(curr.next != null) {
			curr = curr.next;
			len++;
		}

		// System.out.println(len);

		int sum = 0; 
		while (head != null) {
			sum = sum + head.val * (int)Math.pow(2, len-1);
			len--;
			head = head.next;
		}
		return sum;
	}

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line1 = br.readLine();
        String[] nums1 = line1.split(" ");

        ListNode head1 = new ListNode(Integer.parseInt(nums1[0]));
        ListNode temp1 = head1;

        for (int i=1; i<nums1.length; i++) {
            int x = Integer.parseInt(nums1[i]);
            temp1.next = new ListNode(x);
            temp1 = temp1.next;
        }

        int ans = decimal(head1);
        System.out.println(ans);
    }
}