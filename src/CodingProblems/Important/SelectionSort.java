package CodingProblems.Important;

//use this when: When the list is small and when memory space is limited
public class SelectionSort {

    // so basically, we go through the entire array. when we find a min number
    // we keep it in a min number variable and we repeat this each iteration

    void sort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
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
        int arr[] = {9, 1, 8, 2, 7, 3, 6, 4, 5};
        ob.sort(arr);
        System.out.println("Sorted array");
        ob.printArray(arr);
    }
}
