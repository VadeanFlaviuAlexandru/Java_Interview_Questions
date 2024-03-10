public class Palindrome {
    public static void main(String[] args) {
        String str = "racecar";
        int i = 0;
        int j = str.length() - 1;
        boolean isPalindrome = true;
        while (i < j) {
            System.out.println(str.charAt(i) + " " + str.charAt(j));
            if (str.charAt(i) != str.charAt(j)) {
                System.out.println("Not palindrome");
                isPalindrome = false;
                break;
            }
            i++;
            j--;
        }
        if (isPalindrome) {
            System.out.println(str + " is a palindrom");
        }
    }
}