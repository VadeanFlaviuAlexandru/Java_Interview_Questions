public class LargestNumberInArray {
    public static void main(String[] args) {
        int[] nums = {1, 5, 3, 9, 7};
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        // or

        for (int num : nums) {
            max = Math.max(max, num);
        }
    }
}