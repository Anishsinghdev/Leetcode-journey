class Solution {
    public void reverseString(char[] s) {
        int n  = s.length-1;
        int left = 0;
        int right = n;
        while(left<right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
        right--;
        }
        
    }
}