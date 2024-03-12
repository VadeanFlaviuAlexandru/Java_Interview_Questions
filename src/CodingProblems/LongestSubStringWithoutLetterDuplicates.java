package CodingProblems;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutLetterDuplicates {
    public static void main(String[] args) {
        String string = "geeksforgeeks";
        int resultWithSlidingWindow = longestSubstringWithWindow(string);
        int resultWithHashMap = longestSubstringWithHashMap(string);
        System.out.println("the results are in: " + resultWithSlidingWindow + " and " + resultWithHashMap);
    }

    public static int longestSubstringWithWindow(String string) {
        if (string.length() == 0) {
            return 0;
        }

        if (string.length() == 1) {
            return 1;
        }

        int left = 0;
        int right = 0;
        int maxLength = 0;
        boolean[] visitedChars = new boolean[256];

        while (right < string.length()) {

            if (visitedChars[string.charAt(right)]) {
                while (visitedChars[string.charAt(right)]) {
                    visitedChars[string.charAt(left)] = false;
                    left++;
                }
            }

            visitedChars[string.charAt(right)] = true;

            maxLength = Math.max(maxLength, (right - left + 1));
            right++;

        }

        return maxLength;
    }

    public static int longestSubstringWithHashMap(String string) {
        if (string == null) {
            return 0;
        }

        if (string.length() == 1) {
            return 1;
        }

        int maxLength = 0;
        int currentLength = 0;

        Map<Character, Integer> hashMap = new HashMap<Character, Integer>();

        for (int i = 0; i < string.length(); i++) {
            char character = string.charAt(i);

            if (hashMap.containsKey(character)) {
                maxLength = Math.max(maxLength, currentLength);
                currentLength = 0;
                hashMap.clear();
            }

            currentLength++;
            hashMap.put(character, i);
        }

        maxLength = Math.max(maxLength, currentLength);

        return maxLength;
    }


}