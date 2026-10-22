// 15 ms | 73.3 MB
class Solution {
    int[] left, right;
    long maxScore = 0;
    int count = 0, n;

    public int countHighestScoreNodes(int[] parents) {
         n = parents.length;
        left = new int[n];
        right = new int[n];
        Arrays.fill(left, -1);
        Arrays.fill(right, -1);

        for (int i = 1; i < n; i++) {
            int p = parents[i];
            if (left[p] == -1)
                left[p] = i;
            else
                right[p] = i;
        }
        dfs(0);
        return count;
    }
    public int dfs(int node){
        if(node == -1) return 0;
        int l = dfs(left[node]);
        int r = dfs(right[node]);
        int size = l+r+1;
        long score = (long) Math.max(1,l)* Math.max(1,r)*Math.max(1,n-size);
        if(score > maxScore) {
            maxScore = score;
            count = 1;
        }
        else if (score == maxScore){
            count++;
        }
        return size;
    }
}