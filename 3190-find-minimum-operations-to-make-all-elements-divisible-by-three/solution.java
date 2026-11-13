// 1 ms | 42.9 MB
class Solution {
    public int minimumOperations(int[] nums) {
        int count =0;
        for(int i =0;i<nums.length;i++){
            if(nums[i]%3 !=0){
                count++;
            }
        }
        return count;
        
    }
}