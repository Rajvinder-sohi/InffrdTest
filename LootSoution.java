import java.util.Scanner;
import java.util.stream.IntStream;

public class LootSoution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number of elements");
		int n = sc.nextInt();
		int[] arr = new int[n];
		System.out.println("Enter Array Elements");
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		endOfLoot(arr);
	}
	
	private static void endOfLoot(int[] arr) {
        int day;
        for(day = 1; day < arr.length; day++) {
            int previousElm = arr[0];
            boolean isRemoved = false;
            for(int index = 1; index < arr.length; index++) {
                if(previousElm < arr[index]) {
                    arr = removeTheElement(arr, index);
                    previousElm = arr[index -1];
                    isRemoved = true;
                } else {
                    previousElm = arr[index];
                }
            }
            if(!isRemoved) {
                break;
            }
        }
        System.out.print("Loot end after " + --day + " days");
    }

    public static int[] removeTheElement(int[] arr,
                                         int index)
    {

        // If the array is empty
        // or the index is not in array range
        // return the original array
        if (arr == null
                || index < 0
                || index >= arr.length) {

            return arr;
        }

        // return the resultant array
        return IntStream.range(0, arr.length)
                .filter(i -> i != index)
                .map(i -> arr[i])
                .toArray();
    }

}
