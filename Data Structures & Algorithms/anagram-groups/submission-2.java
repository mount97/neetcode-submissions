class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();
        for (String str : strs) {
            int[] frequency = new int[26];
            for (int i = 0; i < str.length(); i++) {
                frequency[str.charAt(i) - 'a']++;
            }

            StringBuilder b = new StringBuilder();
            for (int j : frequency) {
                b.append(j);
                b.append("#");
            }
            String key = b.toString();

            if (!anagramMap.containsKey(key)) {
                anagramMap.put(key, new ArrayList<>());
            }
            anagramMap.get(key).add(str);
        }
        return new ArrayList<>(anagramMap.values());
    }
}
