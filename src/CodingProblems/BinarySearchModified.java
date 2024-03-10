package CodingProblems;

public class BinarySearchModified {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 6, 5, 7, 8, 10, 11, 9, 12};
        int target = 12;
        System.out.println(binarySearch(array, target));
    }

    public static String binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            System.out.println("mid is " + mid + " because left is " + left + " right is " + right);
            if (array[mid] == target || (mid > 0 && array[mid - 1] == target)) {
                return "the number youre looking for " + target + " does exist!";
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return "the number youre looking for does not exist! :(";
    }

}