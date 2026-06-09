class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> firstCharsMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            firstCharsMap.put(s.charAt(i), firstCharsMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        HashMap<Character, Integer> secondCharsMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {  
            if (!firstCharsMap.containsKey(t.charAt(i))) {
                return false;
            } else {
                secondCharsMap.put(t.charAt(i), secondCharsMap.getOrDefault(t.charAt(i), 0) + 1);
            }
        }

        for (Character c : secondCharsMap.keySet()) {
            if (!Objects.equals(firstCharsMap.get(c), secondCharsMap.get(c))) {
                return false;
            }
        }
        return true;
    }
}
