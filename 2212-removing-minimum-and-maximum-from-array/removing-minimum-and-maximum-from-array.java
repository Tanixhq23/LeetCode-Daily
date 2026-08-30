class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length, minEl = 0, maxEl = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[minEl]) minEl = i;
            if (nums[i] > nums[maxEl]) maxEl = i;
        }

        int left = Math.min(minEl, maxEl);
        int right = Math.max(minEl, maxEl);

        return Math.min(right + 1, Math.min(n - left, left + 1 + n - right));
    }
}