// 71 ms | 258.4 MB
import java.util.Arrays;

class Solution {

    public int maximumSaleItems(int[][] items, int budget) {

        int n = items.length;

        // Step 1: Find the maximum factor
        int maxFactor = 0;

        for (int[] item : items) {
            maxFactor = Math.max(maxFactor, item[0]);
        }

        // Step 2: Count how many items have each factor
        int[] freq = new int[maxFactor + 1];

        for (int[] item : items) {
            freq[item[0]]++;
        }

        // Step 3: Calculate the number of free-item
        // opportunities available for each factor
        int[] gain = new int[maxFactor + 1];

        for (int factor = 1; factor <= maxFactor; factor++) {

            // Check all multiples of the current factor
            for (int multiple = factor;
                 multiple <= maxFactor;
                 multiple += factor) {

                gain[factor] += freq[multiple];
            }

            // Exclude the item itself
            gain[factor]--;
        }

        // Step 4: Sort items by price
        Arrays.sort(items, (a, b) ->
                Integer.compare(a[1], b[1]));

        // Step 5: Find the minimum price
        int minPrice = items[0][1];

        long remainingBudget = budget;
        long answer = 0;

        // Step 6: Buy items that provide free items
        for (int[] item : items) {

            int factor = item[0];
            int price = item[1];
            if (price > 2L * minPrice) {
                break;
            }
            int available = gain[factor];
            if (available <= 0) {
                continue;
            }
            long canBuy = remainingBudget / price;
            long buy = Math.min(canBuy, available);
            answer += 2 * buy;
            remainingBudget -= buy * price;
        }
        answer += remainingBudget / minPrice;

        return (int) answer;
    }
}