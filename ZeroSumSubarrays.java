import java.util.*;

public class ZeroSumSubarrays {
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

        // Finding and displaying all zero-sum subarrays
        findZeroSumSubarrays(arr, n);

        sc.close();
    }

    // Function to find all zero-sum subarrays
    public static void findZeroSumSubarrays(int[] arr, int n) {
        Map<Integer, List<Integer>> sumMap = new HashMap<>();
        int cumulativeSum = 0;
        boolean found = false;

        // To store subarrays
        List<String> subarrays = new ArrayList<>();

        // Add an initial entry for sum 0 at index -1 (handles case when subarray starts from index 0)
        sumMap.put(0, new ArrayList<>());
        sumMap.get(0).add(-1);

        // Traverse the array
        for (int i = 0; i < n; i++) {
            cumulativeSum += arr[i];

            // If cumulativeSum is already present, it means subarrays with zero sum exist
            if (sumMap.containsKey(cumulativeSum)) {
                for (int start : sumMap.get(cumulativeSum)) {
                    subarrays.add("Subarray found from index " + (start + 1) + " to " + i);
                    found = true;
                }
            }

            // Add current index to the map
            sumMap.putIfAbsent(cumulativeSum, new ArrayList<>());
            sumMap.get(cumulativeSum).add(i);
        }

        // Display result
        if (found) {
            for (String sub : subarrays) {
                System.out.println(sub);
            }
        } else {
            System.out.println("No zero-sum subarray found.");
        }
    }
}
