class Solution {
    public int maxDepth(String s) {
        int current  = 0;
        int result = 0;
        for(char ch:s.toCharArray()){
            if(ch == '(' ){
                current++;
                result = Math.max(result,current);
            }
            if(ch ==')'){
                current--;
            }
        }
    return result;
        
    }
}