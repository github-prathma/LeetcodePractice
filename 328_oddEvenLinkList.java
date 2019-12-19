import java.util.*;
import java.io.*;

class OddEvenLinkList {
    public static class Node {
        int val;
        Node next;
        Node (int x) {
            this.val = x;
            this.next = null;
        }
    }

    public static Node oddEvenGrouping (Node head) {
        Node h = head;
        Node p = head.next;
        Node tmp = p;

        while ((h.next != null && h.next.next != null) || (p.next != null && p.next.next != null)) {
            if (h.next != null && h.next.next != null) {
                h.next = h.next.next;
                h = h.next;
            }
            if (p.next != null && p.next.next != null) {
                p.next = p.next.next;
                p = p.next;
            }
        }
        p.next = null;
        h.next = tmp;
        return head;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line1 = br.readLine();
        String[] nums1 = line1.split(" ");

        Node head1 = new Node(Integer.parseInt(nums1[0]));
        Node temp1 = head1;

        for (int i=1; i<nums1.length; i++) {
            int x = Integer.parseInt(nums1[i]);
            temp1.next = new Node(x);
            temp1 = temp1.next;
        }

        Node resultHead = oddEvenGrouping(head1);

        System.out.println("Result:");
        while (resultHead != null) {
            System.out.print(resultHead.val + " -> ");
            resultHead = resultHead.next;
        }
        System.out.println();
    }
}