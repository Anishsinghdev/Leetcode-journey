import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int wordLen = words[0].length();
        int numWords = words.length;
        int totalLen = wordLen * numWords;

        if (s.length() < totalLen) {
            return result;
        }

        // Store the target frequency of each word
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Slide the window starting from each possible offset (0 to wordLen - 1)
        for (int i = 0; i < wordLen; i++) {
            int left = i;
            int count = 0;
            Map<String, Integer> currentWindow = new HashMap<>();

            // Move right pointer in steps of wordLen
            for (int right = i; right + wordLen <= s.length(); right += wordLen) {
                String word = s.substring(right, right + wordLen);

                if (wordCount.containsKey(word)) {
                    currentWindow.put(word, currentWindow.getOrDefault(word, 0) + 1);
                    count++;

                    // If a word appears more times than required, shrink from the left
                    while (currentWindow.get(word) > wordCount.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        currentWindow.put(leftWord, currentWindow.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }

                    // All words matched in the current window
                    if (count == numWords) {
                        result.add(left);
                    }
                } else {
                    // Reset the window if an invalid word is encountered
                    currentWindow.clear();
                    count = 0;
                    left = right + wordLen;
                }
            }
        }

        return result;
    }
}
