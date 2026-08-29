class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[] vec = Arrays.copyOf(nums, n);
        Arrays.sort(vec);

        int groupNum = 0;
        HashMap<Integer, Integer> numToGroup = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> groupToList = new HashMap<>();

        numToGroup.put(vec[0], groupNum);

        groupToList.put(groupNum, new ArrayList<>());
        groupToList.get(groupNum).add(vec[0]);

        for (int i = 1; i < n; i++) {
            if (Math.abs(vec[i] - vec[i - 1]) > limit) {
                groupNum++;
            }
            numToGroup.put(vec[i], groupNum);
            if (!groupToList.containsKey(groupNum)) {
                groupToList.put(groupNum, new ArrayList<>());
            }
            groupToList.get(groupNum).add(vec[i]);
        }

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int group = numToGroup.get(num);
            result[i] = groupToList.get(group).get(0);
            groupToList.get(group).remove(0);
        }

        return result;
    }
}