// 1 ms | 94 MB
class Solution {
    int minPrice = Integer.MAX_VALUE;
    int maxShare = 0;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        for(int i=0; i<n;i++){
            if(prices[i]<minPrice){
                minPrice = prices[i];
            }
            int profit = prices[i] - minPrice;

            if(profit>maxShare){
                maxShare =profit;
            }

        }
        return maxShare;
    }
}