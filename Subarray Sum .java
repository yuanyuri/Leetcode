public class Solution {
	public ArrayList<Integer> subArraySum (int[] nums) {
		ArrayList<Integer> ans = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return 0;
		}

		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (map.containsKey(sum)) {
				ans.add(map.get(sum) + 1);
				ans.add(i);
			} else {
				map.put(sum, i);
			}
		}
		return ans;
	}
}