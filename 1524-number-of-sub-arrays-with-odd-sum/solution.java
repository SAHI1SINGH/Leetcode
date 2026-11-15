// 7 ms | 81.4 MB
class Solution {
    public int numOfSubarrays(int[] arr) {
        int mod = 1000000007;
        int evenCount = 1;
        int oddCount = 0;
        int count = 0;
        int prefixSum = 0;
        for (int n : arr) {
            prefixSum += n;

            if (prefixSum % 2 != 0) {
                count = (count + evenCount) % mod;
                oddCount++;
            } else {
                count = (count + oddCount) % mod;
                evenCount++;
            }
        }
        return count;

    }
}