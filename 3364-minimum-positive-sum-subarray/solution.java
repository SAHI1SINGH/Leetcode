// 4 ms | 45.8 MB
class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int min = Integer.MAX_VALUE;
        int n = nums.size();
        for (int k = l; k <= r; k++) {
            int sum = 0;
            for (int i = 0; i < k; i++) {
                sum += nums.get(i);
            }
            if (sum > 0) {
                min = Math.min(min, sum);
            }
            for (int j = k; j < n; j++) {
                sum = sum - nums.get(j - k) + nums.get(j);

                if (sum > 0) {
                    min = Math.min(min, sum);
                }
            }

        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}