package CodingProblems;

public class SwapTwoNumbersWithoutThirdVar {
    public static void main(String[] args) {
        int a = 5; // make it 10
        int b = 10; // make it 5

        a = a + b; // a = 15
        b = a - b; // b = 5
        a = a - b; // a = 10


        System.out.println(a + " and " + b);
    }
}