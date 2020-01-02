import java.util.Arrays;

public class RandomShit {

    public static void main(String[] args) {
        int[] arr1 = {2, 5,10};
        int[] arr2 = {1,3,6};

        int[] sorted = new int[arr1.length+arr2.length];

        int i=0, j=0, k=0;
        while(i<arr1.length && j<arr2.length){
            sorted[k++] = (arr1[i]<arr2[j])?arr1[i++]:arr2[j++];
        }

        if(i>=arr1.length){
            while (j<arr2.length) sorted[k++] = arr2[j++];
        } else if(j>=arr2.length){
            while (i<arr1.length) sorted[k++] = arr1[i++];
        }

        System.out.println(Arrays.toString(sorted));

    }
}
