class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 0 || k > nums.length) {
            return new int[0];
        }

        Map<Integer, Integer> freqMap = new HashMap<>();
        for (Integer num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        Map<Integer, List<Integer>> freqMapGroup = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            List<Integer> values = freqMapGroup.getOrDefault(entry.getValue(), new ArrayList<>());
            values.add(entry.getKey());
            freqMapGroup.put(entry.getValue(), values);
        }
        Integer[] freqRank = freqMapGroup.keySet().toArray(new Integer[0]);
        Arrays.sort(freqRank);

        List<Integer> numberByFreqRank = new LinkedList<>();
        for (Integer r : freqRank) {
            numberByFreqRank.addAll(freqMapGroup.get(r));
        }

        int[] result = new int[k];
        while (k > 0) {
            result[--k] = numberByFreqRank.removeLast();
        }

        return result;
    }
}
