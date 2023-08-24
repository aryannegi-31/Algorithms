//two merge function of different approach

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        System.out.println("enter 10 elements in array :");
        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }
        mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }


    static void mergeSort(int[] arr, int s, int e){
        if(s < e){
            int mid = s + (e-s)/2;
            mergeSort(arr, s, mid);
            mergeSort(arr, mid+1, e);
            merge(arr,s,mid,e);
        }
    }

//    public static void merge(int[] arr, int l, int m, int r)
//    {
//        // Stores the number of elements in the first half
//        int num1 = m - l + 1;
//        // Stores the number of elements in the second half
//        int num2 =  r - m;
//
//        // Creating two temporary arrays of size
//        // 'num1' and 'num2' respectively.
//        int []L = new int[num1];
//        int []R = new int[num2];
//
//        // Copy data to temporary arrays
//        for(int i = 0; i < num1; ++i) {
//            L[i] = arr[l + i];
//        }
//        for(int j = 0; j < num2; ++j) {
//            R[j] = arr[m + 1 + j];
//        }
//
//        // Merge the temporary arrays back into
//        // arr[l ... r]
//
//        int i = 0; // Initial index of the first sub-array
//        int j = 0; // Initial index of the second sub-array
//        int k = l; // Initial index of the merged sub-array
//        while (i < num1 && j < num2)
//        {
//            // If the current element in array 'L'
//            // is less than current element in array 'R'
//            // assign the current element of 'arr' to current
//            // element of 'L' and increase index 'k' and 'i'.
//            if (L[i] < R[j])
//            {
//                arr[k] = L[i];
//                i++;
//            }
//            // assign the current element of 'arr' to current
//            // element of 'R' and increase index 'k' and 'j'.
//            else
//            {
//                arr[k] = R[j];
//                j++;
//            }
//            k++;
//        }
//
//        // Copy the remaining elements of array 'L' to array
//        // 'arr'
//        while (i < num1)
//        {
//            arr[k] = L[i];
//            i++;
//            k++;
//        }
//
//        // Copy the remaining elements of array 'R' to array
//        // 'arr'
//        while (j < num2)
//        {
//            arr[k] = R[j];
//            j++;
//            k++;
//        }
//    }
    static void merge(int[] arr, int s, int m, int e){
        int[] temp = new int[e - s + 1];
        int n1 = s;
        int n2 = m + 1;
        int k = 0;
        while(n1 <= m && n2 <= e){
            if(arr[n1] < arr[n2]){
                temp[k] = arr[n1];
                n1++;
            }
            else{
                temp[k] = arr[n2];
                n2++;
            }
            k++;
        }
        while(n1 <= m){
            temp[k] = arr[n1];
            n1++;
            k++;
        }
        while(n2 <= e){
            temp[k] = arr[n2];
            n2++;
            k++;
        }
        for(int i = 0; i < temp.length; i++){
            arr[s+i] = temp[i];
        }
    }
}
