package CodingProblems;

public class SecondLargestNumber {
    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 6, 8, 9, 2, 10, 23, 21, 100};
        int max = Integer.MIN_VALUE;
        int secondmax = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                secondmax = max;
                max = nums[i];
            } else if (nums[i] > secondmax && nums[i] < max) {
                secondmax = nums[i];
            }
        }
        System.out.println("biggest number " + max + " and second biggest " + secondmax);
    }
}