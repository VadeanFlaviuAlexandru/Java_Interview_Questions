package CodingProblems;

public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(1234));
    }

    public static long reverse(int input) {
        long reversed = 0;
        while (input != 0) {
            reversed = reversed * 10 + input % 10;
            input /= 10;
            if (reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) {
                return 0;
            }
        }
        return reversed;
    }

}