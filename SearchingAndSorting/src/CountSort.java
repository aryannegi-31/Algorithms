import java.util.Arrays;
import java.util.Scanner;

public class CountSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        System.out.println("enter 10 elements in array :");
        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }
        countSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void countSort(int[] arr){
        int n = arr.length;
        int k = arr[0];
        for(int i = 1; i < n; i++){
            if(k < arr[i]){
                k = arr[i];
            }
        }
        int[] count = new int[k+1];
        for(int i = 0; i <= k; i++){
            count[i] = 0;
        }
        for (int j : arr) {
            count[j]++;
        }
        for(int i = 1; i <= k; i++){
            count[i] += count[i-1];
        }
        int[] brr = new int[n];
        for(int i = n-1; i >= 0; i--){
            brr[--count[arr[i]]] = arr[i];
        }
        for(int i = 0; i < n; i++){
            arr[i] = brr[i];
        }
    }
}
