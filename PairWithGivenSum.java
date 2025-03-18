import java.util.*;

public class PairWithGivenSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input
        System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter the target sum: ");
        int target = sc.nextInt();

        // Checking for a pair
        if (!findPairWithSum(arr, n, target)) {
            System.out.println("No pair found with the given sum.");
        }

        sc.close();
    }

    // Function to find a pair with the given sum
    public static boolean findPairWithSum(int[] arr, int n, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int complement = target - arr[i];

            // Check if complement exists in the map
            if (map.containsKey(complement)) {
                System.out.println("Pair found: (" + complement + ", " + arr[i] + ")");
                return true;
            }

            // Store current number in the map
            map.put(arr[i], i);
        }

        return false;
    }
}
