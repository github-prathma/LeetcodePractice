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

    // public LinkedList insert(LinkedList list, int data) {
    //     Node newNode = new Node(data);
    //     newNode.next = null;

    //     if (list.head == null) {
    //         list.head = newNode;
    //     } else {
    //         Node temp = list.head;
    //         while (temp.next != null) {
    //             temp = temp.next;
    //         }
    //         temp.next = newNode;
    //     }
    //     return list;
    // }

    public static Node sum(Node l1, Node l2) {
        List<Integer> l1Digs = new ArrayList<>();
        List<Integer> l2Digs = new ArrayList<>();
        List<Integer> sumRes = new ArrayList<>();
        
        Node temp1 = l1;
        Node temp2 = l2;
        
        
        while (temp1 != null) {
            l1Digs.add(temp1.val);
            temp1 = temp1.next;
        }
        
        while(temp2 != null) {
            l2Digs.add(temp2.val);
            temp2 = temp2.next;
        }
        
        int len = (l1Digs.size() >= l2Digs.size()) ? l1Digs.size() : l2Digs.size();
        
        int smallLen;
        if (len == l1Digs.size()) {
            smallLen = l2Digs.size();
        } else {
            smallLen = l1Digs.size();
        }
        
        
        int i = len-1;
        int j = smallLen-1;
        int carry = 0;
        int sum = 0;
        int val = 0;
        
        while (i>=0 || j>=0) {
            
            // System.out.println(i + " " + j);
            if (j<=smallLen-1 && j>=0) {
                if (i<len && j<smallLen && smallLen == l1Digs.size()) {
                    sum = l1Digs.get(j) + l2Digs.get(i) + carry;
                } else if (i<len && j<smallLen && smallLen == l2Digs.size()){
                    sum = l1Digs.get(i) + l2Digs.get(j) + carry;                
                }
            } else {
                if (smallLen == l1Digs.size()) {
                   sum = l2Digs.get(i) + carry;
                } else {
                   sum = l1Digs.get(i) + carry;
                }
            }
            carry = sum/10;
            val = sum%10;
            

            sumRes.add(val);
            
            i--;
            j--;
        }
        
        if (carry == 1) {
            sumRes.add(1);
        }
        
        Collections.reverse(sumRes);
        // System.out.println(sumRes);
        Node newNode = new Node(sumRes.get(0));
        Node t = newNode;
        
        for (int k=1; k<sumRes.size(); k++) {
            t.next = new Node(sumRes.get(k));
            t = t.next;
        }
        
        return newNode;
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