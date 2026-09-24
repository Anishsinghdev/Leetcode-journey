class Solution {
    public int characterReplacement(String s, int k) {
        int low =0;
        int maxfreq = 0;
        int maxlen = Integer.MIN_VALUE;
        int[] freq = new int[26];
        for(int high = 0;high<s.length();high++){
            char ch = s.charAt(high);
            freq[ch- 'A']++;
            maxfreq = Math.max(maxfreq, freq[ch-'A']);

            int windowlen = high-low+1;
            int replacement = windowlen - maxfreq;

            while(replacement > k){
                char leftchar = s.charAt(low);
                freq[leftchar - 'A']--;
                low++;

                windowlen = high-low+1;
                replacement = windowlen - maxfreq;
            }
            maxlen = Math.max(maxlen , high-low+1);

        }
        return maxlen;
    }
}