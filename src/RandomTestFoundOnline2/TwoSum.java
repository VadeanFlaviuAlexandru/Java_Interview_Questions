package RandomTestFoundOnline2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Given an array of integers and a target sum, write a Java function to find all
// pairs of numbers that add up to the target sum.
public class TwoSum {
    public static List<List<Integer>> findPairs(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> complementMap = new HashMap<>();

        for (int num : nums) {
            int complement = target - num;
            if (complementMap.containsKey(complement)) {
                List<Integer> pair = new ArrayList<>();
                pair.add(num);
                pair.add(complement);
                result.add(pair);
            }
            complementMap.put(num, complement);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15, 3, 6, 9};
        int target = 9;
        List<List<Integer>> pairs = findPairs(nums, target);

        System.out.println("Pairs that add up to " + target + ":");
        for (List<Integer> pair : pairs) {
            System.out.println(pair);
        }
    }
}
