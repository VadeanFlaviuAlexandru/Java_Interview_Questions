package RandomTestFoundOnline2;

import java.util.HashMap;
import java.util.Map;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        String word = "Academic";
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char letter : word.toCharArray()) {
            frequencyMap.put(letter, frequencyMap.getOrDefault(letter, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            System.out.println(entry.getKey() + " with value " + entry.getValue());
        }
    }
}
