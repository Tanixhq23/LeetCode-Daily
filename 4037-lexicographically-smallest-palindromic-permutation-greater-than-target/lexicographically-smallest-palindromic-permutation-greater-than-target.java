class Solution {
    String result = "";
    char midChar = '$';
    int halfLen = 0;

    public boolean solve(StringBuilder curr, int[] count, String target,
            int i, boolean greater) {
        if (curr.length() == halfLen) {

            String candidate = curr.toString();

            StringBuilder rightHalf = new StringBuilder(curr);
            rightHalf.reverse(); 

            if (midChar != '$') {
                candidate += midChar;
            }

            candidate += rightHalf.toString();

            if (candidate.compareTo(target) > 0) {
                result = candidate;
                return true;
            }

            return false;
        }

        for (char ch = 'a'; ch <= 'z'; ch++) {

            if (count[ch - 'a'] == 0) {
                continue;
            }

            if (greater == false && ch < target.charAt(i)) {
                continue;
            }

            curr.append(ch);
            count[ch - 'a']--;

            boolean isGreater = greater || ch > target.charAt(i);

            if (solve(curr, count, target, i + 1, isGreater)) {
                return true;
            }
            curr.deleteCharAt(curr.length() - 1);
            count[ch - 'a']++;
        }

        return false;
    }

    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
         int[] count = new int[26];

        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }
        int oddCount = 0;
        for(int c = 0; c<26; c++){
            if(count[c]%2==1){
                oddCount++;
                midChar = (char)(c+'a');
            }
        }
        if(oddCount>1){
            return "";
        }

        for(int c = 0; c<26; c++){
            count[c]/=2;
        }

        halfLen = n/2;

        StringBuilder curr = new StringBuilder();

        solve(curr, count, target, 0, false);

        return result;
    }
}