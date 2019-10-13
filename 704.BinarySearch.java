import java.util.Scanner;

class BinarySearch {
    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }
        int start = 0;
        int end = nums.length-1;

        while (start <= end) {
            int mid = (start + end - 1)/2;

            if (nums[mid] == target) {
                return mid;
            } else {
                if (nums[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            int n = sc.nextInt();

            int[] nums = new int[n];

            for (int i=0; i<n; i++) {
                int x = sc.nextInt();
                nums[i] = x;
            }

            int target = sc.nextInt();

            BinarySearch b = new BinarySearch();
            int ans = b.search(nums, target);
            System.out.println(ans);

        } finally {
            sc.close();
        }
        
    }
}