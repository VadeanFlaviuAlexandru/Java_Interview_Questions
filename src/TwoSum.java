import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        //given an array, use two indices to reach the sum given as input
        int[] numbers = new int[]{2, 3, 7, 4, 8};
        int target = 7;
        int[] resultIndices = getTwoSumIndices(numbers, target);
        System.out.println(resultIndices[0] + " and " + resultIndices[1]);
    }

    public static int[] getTwoSumIndices(int[] array, int target) {
        Map<Integer, Integer> visitedNumbers = new HashMap<>();
        for (int i = 0; i <= array.length; i++) {
            int delta = target - array[i];
            if (visitedNumbers.containsKey(delta)) {
                return new int[]{visitedNumbers.get(delta), i}; //change this to numbersVisited.get(delta), array[i] for returing values
            }
            visitedNumbers.put(array[i], i); // change to numbersVisited.put(array[i], array[i]); for returning values
        }
        return new int[]{-1, -1}; //please ask the interviewer ' what's the expected value if there's an error? '
    }

}
