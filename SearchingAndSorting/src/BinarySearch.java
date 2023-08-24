import java.util.Scanner;

class BinarySearch{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        System.out.println("enter 10 elements in array :");
        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter element you want to search :");
        int search = sc.nextInt();
        binarySearch(arr, search);
    }
    static void binarySearch(int[] arr, int search){
        int start = 0;
        int end = arr.length - 1;
        int mid;
        boolean found = false;
        while(start <= end){
            mid = start + (end - start)/2;
            if(arr[mid] == search){
                found = true;
                break;
            }
            else if(arr[mid] > search){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        if(found){
            System.out.println("found");
        }
        else{
            System.out.println("not found");
        }
    }
}