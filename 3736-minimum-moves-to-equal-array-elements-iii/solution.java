// 2 ms | 45.6 MB
class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        int max =Integer.MIN_VALUE;
        int count =0;
        for(int i =0;i<n ;i++){
            max = Math.max(max,nums[i]);
        }
        for(int i=0;i<n ;i++){
           count+= max - nums[i];
        }
        return count;
    }
}