class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        while (true) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                // diff is the first number, nums[i] is the second one
                return new int[]{map.get(diff), i};
            }
            // as Map does not contain duplicate values
            // this condition to ensure the map contains only the number has the smallest index
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
            i++;
        }
    }
}
