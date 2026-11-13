// 1 ms | 44.1 MB
class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int n = operations.length;
        int x =0;
        for(int i =0;i<n;i++){
            if(operations[i].equals("--X")){
                --x;
            }
            else if(operations[i].equals("++X")){
                ++x;
            }
            else if(operations[i].equals("X++")){
                x++;
            }
            else if(operations[i].equals("X--")){
                x--;
            }
        }
        return x;
    }
}