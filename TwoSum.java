import java.util.*;

public class TwoSum {
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

        // Finding two sum indices
        int[] result = findTwoSum(arr, target);

        // Output result
        if (result.length == 2) {
            System.out.println("Indices: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No pair found with the given sum.");
        }

        sc.close();
    }

    // Function to find two indices that sum up to the target
    public static int[] findTwoSum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];

            // Check if complement exists
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            // Store current element's index
            map.put(arr[i], i);
        }

        return new int[]{};
    }
}
