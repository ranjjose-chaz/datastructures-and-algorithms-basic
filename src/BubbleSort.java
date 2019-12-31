import java.util.Arrays;

/**
 * Normal impl as well as a recursive version
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1,10, 20, 5, 25, 35, 15, 50, 40};


        System.out.println(Arrays.toString(arr));
        recursiveBubbleSort(arr,0,1);
        System.out.println("\nAfter BubbleSort");
        System.out.println(Arrays.toString(arr));

        arr = new int[]{100,10, -20, 5, -25, 350, 15, 50, 40};
        System.out.println(Arrays.toString(arr));
        recursiveBubbleSort(arr,0,1);
        System.out.println("\nAfter BubbleSort");
        System.out.println(Arrays.toString(arr));

        arr = new int[]{10,20,30,40,50,40,30,20,10};
        System.out.println(Arrays.toString(arr));
        recursiveBubbleSort(arr,0,1);
        System.out.println("\nAfter BubbleSort");
        System.out.println(Arrays.toString(arr));

    }

    public static void bubbleSort(int[] arr){
        for(int i=0; i<arr.length; ++i){
            for(int j=1; j<arr.length-i; ++j){
                if(arr[j-1]>arr[j])
                    swap(arr, j-1, j);

            }
        }
    }

    public static void recursiveBubbleSort(int [] arr, int i, int j){
        if(i < arr.length) {

            if (j < arr.length - i) {

                if (arr[j - 1] > arr[j])
                    swap(arr, j - 1, j);

                recursiveBubbleSort(arr, i, j + 1);
            } else {
                recursiveBubbleSort(arr, i+1, 1);
            }
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
