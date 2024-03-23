package RandomTestFoundOnline.SectionTwo;

public class GreatestCommonDivisor {
    public static int gcd(int number1, int number2) {
        int gcd = Math.min(number1, number2);
        while (number1 % gcd != 0 || number2 % gcd != 0) {
            gcd--;
        }

        return gcd;
    }

    public static int gcdOfList(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Input array is empty or null");
        }

        int result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result = gcd(result, numbers[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input = {12, 18, 24};
        int gcd = gcdOfList(input);
        System.out.println("GCD of the list is: " + gcd);
    }
}
