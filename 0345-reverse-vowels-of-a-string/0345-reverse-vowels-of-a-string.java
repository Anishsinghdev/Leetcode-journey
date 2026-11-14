class Solution {
    public String reverseVowels(String s) {
        int n = s.length();
        int left = 0;
        int right = n-1;
        char ch[] = s.toCharArray();
        while(left<right){
            
            if("aeiouAEIOU".indexOf(ch[left]) == -1){
                left++;
            }
            else if("aeiouAEIOU".indexOf(ch[right]) == -1){
                right--;
            }
            else{
                char temp = ch[left];
                ch[left] = ch[right];
                ch[right] = temp;
                left++;
                right--;
            }
        }
        return new String(ch);
    }
}