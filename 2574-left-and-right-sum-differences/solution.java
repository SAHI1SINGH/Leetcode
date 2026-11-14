// 2 ms | 46.3 MB
class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int leftSum = 0;
        int totalSum =0;
        int[] result = new int[n];
        for(int i =0;i<n ;i++){
            totalSum +=nums[i];

        }
        for(int i =0;i<n;i++){
            int rightSum = totalSum -leftSum -nums[i];
            result[i]= Math.abs(rightSum-leftSum);
            leftSum += nums[i];
        }
        return result;
    }
}