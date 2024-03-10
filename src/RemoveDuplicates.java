import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 6, 7, 7, 8};
        Set<Integer> set = new LinkedHashSet<>();
        for (int num : array) {
            set.add(num);
        }
        Integer[] newArray = set.toArray(new Integer[set.size()]);
        System.out.println(Arrays.toString(newArray));
    }
}