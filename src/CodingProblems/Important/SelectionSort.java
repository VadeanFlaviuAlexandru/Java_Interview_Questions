package CodingProblems.Important;

//use this when: When the list is small and when memory space is limited
public class SelectionSort {

    void sort(int arr[]) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int min_idx = i; // keep track of the first value
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j; // if we find a lower value, we swap the values
                }
            }
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;//we put the lowest value at the beggining
        }
    }

    void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        SelectionSort ob = new SelectionSort();
        int arr[] = {64, 89, 25, 12, 22, 11};
        ob.sort(arr);
        System.out.println("Sorted array");
        ob.printArray(arr);
    }
}
