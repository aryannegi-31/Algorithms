import java.util.Arrays;
import java.util.Scanner;

public class RadixSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        System.out.println("enter 10 elements in array :");
        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }
        radixSort(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }
    static void radixSort(int[] arr, int n){
        int max = max(arr,n);
        for(int pos = 1; max/pos > 0; pos*=10){
            countSort(arr,n,pos);
        }
    }
    static int max(int[] arr, int n){
        int max = arr[0];
        for(int i = 1; i < n; i++){
            if(max < arr[i]){
                max = arr[i];
            }
        }
        return max;
    }
    static void countSort(int[] arr, int n, int pos){
        int[] count = new int[10];
        for(int i = 0; i < 10; i++){
            count[i] = 0;
        }
        for(int i = 0; i < n; i++){
            count[(arr[i]/pos)%10]++;
        }
        for(int i = 1; i < 10; i++){
            count[i] += count[i-1];
        }
        int[] brr = new int[n];
        for(int i = n-1; i >= 0; i--){
            brr[--count[(arr[i]/pos)%10]] = arr[i];
        }
        for(int i = 0; i < n; i++){
            arr[i] = brr[i];
        }
    }
}
