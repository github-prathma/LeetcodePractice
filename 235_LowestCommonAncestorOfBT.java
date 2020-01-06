import java.io.*;
import java.util.*;

//do not use NULL in input array....


class LowestCAOfBTree {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode (int x) {
			this.val = x;
			this.left = null;
			this.right = null;
		}
	}

	TreeNode root;

	public static TreeNode insertLevelOrder(TreeNode root, String[] arr, int i) {

		if ( i < arr.length) {
			if (arr[i].compareTo("null") == 0) {
				root = null;
			} else {
				TreeNode temp = new TreeNode(Integer.parseInt(arr[i]));
				root = temp;
			}
			root.left = insertLevelOrder(root.left, arr, 2*i+1);
			root.right = insertLevelOrder(root.right, arr, 2*i+2);
		}
		return root;
	}

	public static void inOrder(TreeNode root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.val + " ");
			inOrder(root.right);
		}
	}

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (p.val > root.val && q.val > root.val) {
			return lowestCommonAncestor(root.right, p, q);
		} else if (p.val < root.val && q.val < root.val) {
			return lowestCommonAncestor(root.left, p, q);
		} else {
			return root;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		String[] nodes = s.split(" ");

		LowestCAOfBTree t = new LowestCAOfBTree();
		t.root = insertLevelOrder(t.root, nodes, 0);
		inOrder(t.root);

		System.out.println();

		TreeNode ans = lowestCommonAncestor(t.root, t.root.left.right, t.root.right.left);
		System.out.println(ans.val);
	}
}