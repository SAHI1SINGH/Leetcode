// 1 ms | 43.6 MB
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int n = candies.length;
        int max =0;
        for(int i =0; i<n;i++){
            max = Math.max(max,candies[i]);
        }
        List<Boolean> result = new ArrayList<>();
        for(int j =0;j<n;j++){
            if(candies[j]+extraCandies >= max){
                result.add(true);
            }
            else 
               result.add(false);
        }
        return result;
    }
}