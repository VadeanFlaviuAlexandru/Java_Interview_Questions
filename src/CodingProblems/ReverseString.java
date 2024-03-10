package CodingProblems;

public class ReverseString {
    public static void main(String[] args) {
        //just reverse a string. two options:
        //use StringBuilder
        String string = "Hello..";
        System.out.println(new StringBuilder(string).reverse());
        //use manual approach
//        StringBuilder sb = new StringBuilder();
        char[] array = new char[string.length()];
        for (int i = string.length() - 1, j = 0; i >= 0; i--, j++) {
//            sb.append(string.charAt(i));
            array[j] = string.charAt(i);
        }
        System.out.println(new String(array));
    }
}