package CodingProblems;

public class SlidingWindowTechnique {
    //  The problems based on this technique:
    //Maximum/Minimum Subarray Sum:
    //Longest Substring with K Distinct Characters:
    //Longest Subarray with Ones after Replacement:
    //Find All Anagrams in a String:
    //Smallest Subarray with Sum at Least K:
    //Maximum Consecutive Ones after Flipping Zeros:
    //Minimum Window Substring:
    //Longest Repeating Character Replacement:
    //Fruit Into Baskets:
    //Subarrays with Product Less than K
    public static void main(String[] args) {
        int[] array = {4, 5, 2, 0, 1, 8, 12, 3, 6, 9};
        int windowSize = 3;
        int result = maxSubarraySum(array, windowSize);
        int result2 = maxSubarraySumDynamic(array, 15);
        System.out.println("max subarray sum: " + result);
        System.out.println("longest subarray with sum 15: " + result2);

    }

    //this function is kinda slow.
    public static int maxSubarraySum(int[] array, int windowSize) {
        int maxSum = Integer.MIN_VALUE;
        int windowSum = 0;

        for (int i = 0; i < windowSize; i++) {
            windowSum += array[i]; // used to calculate the sum of the first window ( 2,1,5 )
        }

        for (int i = windowSize; i < array.length; i++) {
            windowSum += array[i] - array[i - windowSize]; // first iteration: 8 + 1 - 2
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    //longest subarray with sum < S
    public static int maxSubarraySumDynamic(int[] array, int target) {
        int minus = -1;
        int sum = 0;
        int best = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            while (sum >= target) {
                minus += 1;
                sum -= array[minus];
            }
            best = Math.max(best, i - minus);
            System.out.println(minus + " " + sum + " " + best);
        }

        return best;
    }
}