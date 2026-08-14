class Solution {
    public int maximumLengthSubstring(String s) {
        int left = 0, right = 0, len = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (right < s.length()) {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while (map.get(ch) > 2) {
                char charLeft = s.charAt(left);
                map.put(charLeft, map.get(charLeft) - 1);
                left++;
            }

            len = Math.max(len, right - left + 1);
            right++;
        }

        return len;
    }
}