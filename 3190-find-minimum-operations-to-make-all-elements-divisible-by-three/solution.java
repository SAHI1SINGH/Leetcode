// 1 ms | 43.1 MB
class Solution {
    public int minimumOperations(int[] nums) {
        int count =0;
        for(int n : nums){
            if(n%3 !=0){
                count++;
            }
        }
        return count;
        
    }
}