package RandomTestFoundOnline2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindingDuplicates {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 6, 7, 7, 8};
        List<Integer> duplicates = findDuplicates(array); // a list because of dynamic resizing
        System.out.println("Duplicates: " + duplicates);
    }

    private static List<Integer> findDuplicates(int[] array) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : array) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > 1) {
                result.add(entry.getKey());
            }
        }

        return result;
    }

}
