// 1 ms | 44 MB
class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x =0;
        for(String n : operations){
            if(n.charAt(1)=='+') x++;
            else x--;
        }
        return x;
    }
}