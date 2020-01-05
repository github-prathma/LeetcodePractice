import java.util.*;
import java.io.*;

class LinkedListCycle {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			this.val = x;
			this.next = null;
		}
	}

	public static ListNode findIntersection(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (fast == slow) {
				fast = head;
				while (slow != fast) {
					slow = slow.next;
					fast = fast.next;
				}
				return fast;
			}
		}
		return null;
	}

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line1 = br.readLine();
        int pos = Integer.parseInt(br.readLine());

        String[] nums1 = line1.split(" ");

        ListNode head1 = new ListNode(Integer.parseInt(nums1[0]));
        ListNode temp1 = head1;

        for (int i=1; i<nums1.length; i++) {
            int x = Integer.parseInt(nums1[i]);
            temp1.next = new ListNode(x);
            temp1 = temp1.next;
        }


        ListNode ptr = head1;
        int c = 0;

        while (c != pos) {
        	c++;
        	ptr = ptr.next;
        }

        temp1.next = ptr;

        ListNode intersect = findIntersection(head1);
        if (intersect == null) {
        	System.out.println("no cycle");
        } else {
        	System.out.println(intersect.val);

        }

    }
}