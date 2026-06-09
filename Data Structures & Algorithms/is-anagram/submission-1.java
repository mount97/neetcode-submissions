class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] firstChars = s.toCharArray();
        Arrays.sort(firstChars);
        char[] secondChars = t.toCharArray();
        Arrays.sort(secondChars);

        return Arrays.toString(firstChars).equals(Arrays.toString(secondChars));
    }
}
