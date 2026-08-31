class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev = head;
        ListNode curr = head.next;

        int currPosition = 1;
        int prevCriticalPos = 0;
        int firstCriticalPos = 0;

        int minDist = Integer.MAX_VALUE;

        while (curr.next != null) {
            if ((curr.val < prev.val && curr.val < curr.next.val)
                    || (curr.val > prev.val && curr.val > curr.next.val)) {

                if (prevCriticalPos == 0) {
                    prevCriticalPos = currPosition;
                    firstCriticalPos = currPosition;
                } else {
                    minDist = Math.min(minDist, currPosition - prevCriticalPos);
                    prevCriticalPos = currPosition;
                }
            }

            currPosition++;
            prev = curr;
            curr = curr.next;
        }

        if (minDist == Integer.MAX_VALUE) {
            return new int[]{-1, -1};
        }

        return new int[]{minDist, prevCriticalPos - firstCriticalPos};
    }
}