class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] ans = new int[n];
        
        Stack<Integer>st = new Stack<>();
        for(int i = n-1;i>=0;i--){

            int count = 0;
            while(!st.empty() && heights[i]>st.peek()){
                st.pop();
                count++;
            }
            if(!st.empty()){
                count++;
            }
            ans[i] = count;

            st.push(heights[i]);
        }
        return ans;
        
    }
}