class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 0 || k > nums.length) {
            return new int[0];
        }

        Map<Integer, Integer> freqMap = new HashMap<>();
        for (Integer num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        List<Integer>[] bucket =  new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (bucket[entry.getValue()] == null) {
                bucket[entry.getValue()] = new ArrayList<>();
            }
            bucket[entry.getValue()].add(entry.getKey());
        }

        int[] result = new int[k];
        // result index start from 0 to k
        int resultIndex = 0;
        // bucket index (i) start from the most frequency array and down to the least frequency array (freq = 1)
        for (int i = bucket.length - 1; i > 0 && resultIndex < k; i--) {
            if (bucket[i] != null) {
                for (int num : bucket[i]) {
                    result[resultIndex++] = num;
                    if (resultIndex == k) {
                        return result;
                    }
                }
            }
        }
        return result;
    }
}
