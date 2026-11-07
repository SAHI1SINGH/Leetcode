// 6 ms | 44 MB
class Solution {
    int max = 0;
    public int maxProduct(int[] nums) {
        for(int i =0;i< nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int mul =((nums[i]-1)*(nums[j]-1));
                if(mul>max){
                    max = mul;
                }
            }
        }
        return max;
    }
}