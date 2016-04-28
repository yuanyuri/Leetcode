public class Solution {
	public int findKthLargest(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
			return helper(nums, 0, nums.length, nums.length - k + 1);

	}
	private int helper(int[] nums, int left, int right, int k) {
		if (left == right) {
			return nums[left];
		}
		int position = partition(nums, left, right, k);
		if (position + 1 == k) {
			return nums[positon];
		} else if (postition + 1 < k) {
			return helper(nums, positon + 1, right, k);
		} else {
			return helper(nums, left, postion - 1, k);
		}
	}
	private int partition(int[]nums, int left, int right) {
		if (left == right) {
			return left;
		}
		int i = left, j = right;
		int povoite = nums[left];
		while (i < j) {
			while (i < j && nums[j] >= pivote) {
				--j;
			}
			nums[left] = nums[right];
			while (i < j && nums[i] <= pivote) {
				++i;
			}
			nums[right] = nums[left];
		}
			nums[i] = pivote;
			return i;
		
	}
}
