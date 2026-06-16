class Solution {

    public String encode(List<String> strs) {
        if (strs.isEmpty()) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        for (String s : strs) {
            if (s.isEmpty()) {
                result.append("x");
            }
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (Character.isAlphabetic(chars[i])) {
                    result.append("c");
                } else if (Character.isDigit(chars[i])) {
                    result.append("d");
                } else if (Character.isEmoji(chars[i])) {
                    result.append("e");
                } else {
                    result.append("u");
                }
                result.append(Character.codePointAt(chars, i));
            }
            result.append(".");
        }
        return result.toString();
    }

    public List<String> decode(String str) {
        if (str.isBlank()) {
            return new ArrayList<>();
        }
        String[] strings = str.split("\\.+");
        List<String> result = new ArrayList<>(strings.length);
        for (String s : strings) {
            if (s.equals("x")) {
                result.add("");
            } else {
                StringBuilder builder = new StringBuilder();
                String[] codePoints = s.split("[cdeu]");
                for (String cp : codePoints) {
                    if (!cp.isEmpty()) {
                        builder.appendCodePoint(Integer.parseInt(cp));
                    }
                }
                result.add(builder.toString());
            }
        }
        return result;
    }
}
