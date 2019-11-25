import java.util.*;
import java.io.*;

class AddTwoNums {

    public static class Node {
        int val;
        Node next;
        Node (int x) {
            this.val = x;
            this.next = null;
        }
    }

    public static int linklistLen(Node head) {
        Node temp = head;
        int len = 0;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        return len;
    }

    public static int addTwoLists(Node l1, Node l2, int diff) {
        if (l1 == null && l2 == null) {
            return 0;
        }
        int prev = 0;
        if (diff != 0) {
            prev = addTwoLists(l1.next, l2, diff-1);
        } else {
            prev = addTwoLists(l1.next, l2.next, diff);
        }

        int res = 0;
        if (diff >= 1) {
            if (prev == 1) {
                res = l1.val + prev;
            } else {
                res = l1.val;
            }
        } else {
            res = l1.val+l2.val+prev;
        }
        l1.val = res % 10;
        return res > 9 ? 1:0;
    }

    public static Node sum(Node l1, Node l2) {
       int len1 = linklistLen(l1);
       int len2 = linklistLen(l2);
       int diff = Math.abs(len1 - len2);
       int lastCarry = len1 >= len2 ? addTwoLists(l1, l2, diff) : addTwoLists(l2, l1, diff);
       if (lastCarry == 1) {
           Node temp = new Node(1);
           if (len1 >= len2) {
               temp.next = l1;
           } else {
               temp.next = l2;
           }
           return temp;
       }
       if (len1 >= len2) {
           return l1;
       } else {
           return l2;
       }
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

        String line2 = br.readLine();
        String[] nums2 = line2.split(" ");

        Node head2 = new Node(Integer.parseInt(nums2[0]));
        Node temp2 = head2;

        for (int i=1; i<nums2.length; i++) {
            int x = Integer.parseInt(nums2[i]);
            temp2.next = new Node(x);
            temp2 = temp2.next;
        }

        Node resultHead = sum(head1, head2);

        System.out.println("Result:");
        while (resultHead != null) {
            System.out.print(resultHead.val + " -> ");
            resultHead = resultHead.next;
        }
        System.out.println();
    }
}