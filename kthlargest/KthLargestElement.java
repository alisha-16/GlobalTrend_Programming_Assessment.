package kthlargest;

import java.util.*;

public class KthLargestElement {

    public static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1 || k > nums.length)
            throw new IllegalArgumentException("Invalid input");

        // Convert kth largest to index (0-indexed)
        int targetIndex = nums.length - k;

        // Perform Quickselect
        return quickselect(nums, 0, nums.length - 1, targetIndex);
    }

    private static int quickselect(int[] nums, int left, int right, int k) {
        while (left <= right) {
            int pivotIndex = partition(nums, left, right);

            if (pivotIndex == k) {
                return nums[pivotIndex];
            } else if (pivotIndex < k) {
                left = pivotIndex + 1;
            } else {
                right = pivotIndex - 1;
            }
        }
        return -1; // This should not happen for valid inputs
    }

    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (nums[j] <= pivot) {
                i++;
                swap(nums, i, j);
            }
        }

        swap(nums, i + 1, right);
        return i + 1;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input array
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // Input k
        System.out.print("Enter the value of k (1-based): ");
        int k = scanner.nextInt();

        // Find the kth largest element
        int kthLargest = findKthLargest(nums, k);
        System.out.println("The " + k + "th largest element in the array is: " + kthLargest);

        scanner.close();
    }
}
