import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {

        int[] arr = new int[]{1,10, 20, 5, 25, 35, 15, 50, 40};
        int[] sorted = mergeSort(arr, 0, arr.length);
        System.out.println("Sorted -> " + Arrays.toString(sorted));
    }

    private static int[] mergeSort(int[] arr, int i, int len) {


        if(len > 1){
            int[] arr1 = new int[len/2];
            int[] arr2 = new int[len-(len/2)];

            populateArray(arr1, i, len/2, arr);
            populateArray(arr2, len/2, len, arr);

            System.out.println(Arrays.toString(arr1));
            System.out.println(Arrays.toString(arr2));

            if(arr1.length > 1)
                arr1 = mergeSort(arr1, i, arr1.length);

            if(arr2.length > 1)
                arr2 = mergeSort(arr2, i, arr2.length);

            int[] merged = merge(arr1, arr2);

            System.out.println("Merged ->" + Arrays.toString(merged));

            return merged;
        }
        return arr;
    }

    private static int[] merge(int[] arr1, int[] arr2) {

        int[] merged = new int[arr1.length+arr2.length];

        int indx=0, i=0, j=0;

        while(indx < merged.length){
            if(i < arr1.length && j < arr2.length)
                merged[indx++] = (arr1[i]<arr2[j]) ? arr1[i++] : arr2[j++];
            else
                break;
        }

        if(i >= arr1.length)
            for(;j<arr2.length;++j)
                merged[indx++] = arr2[j];
        else if (j >= arr2.length)
            for(;i<arr1.length;++i)
                merged[indx++] = arr1[i];


        return merged;
    }

    private static void populateArray(int[] dest, int start, int end, int[] src) {
        for(int i=0; i<dest.length; ++i){
            dest[i]  = src[start++];
        }

    }

}
