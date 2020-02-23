import java.util.Arrays;

public class RandomShit {

    public static int[] mergeSortedArrays(int[] arr1, int[] arr2){

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

        return sorted;
    }


    public static void permutations(char[] str, int i){

        if(str.length == 1){
            System.out.println(str);
        } else if(str.length == 2){
            System.out.println(""+str[0]+str[1]);
            System.out.println(""+str[1]+str[0]);
        } else {

        }

    }

    public static void main(String[] args) {

        int[] arr1 = {25, 50,100};
        int[] arr2 = {2,5,10};

        int[] merged = mergeSortedArrays(arr1, arr2);
        System.out.println(Arrays.toString(merged));

        permutations("bc".toCharArray(), 0);




    }
}
