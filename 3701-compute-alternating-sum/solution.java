// 2 ms | 46.1 MB
class Solution {
    public int alternatingSum(int[] nums) {
        int total =0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(i%2 ==0){
                total+=nums[i];
            }
            else if(i%2 !=0){
                total-=nums[i];
            }
        }
        return total;
    }
}