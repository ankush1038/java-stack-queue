import java.util.*;

public class LongestConsecutiveSequence {
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

        // Finding longest consecutive sequence
        int longestSequence = findLongestConsecutiveSequence(arr);
        System.out.println("Length of longest consecutive sequence: " + longestSequence);

        sc.close();
    }

    // Function to find the longest consecutive sequence
    public static int findLongestConsecutiveSequence(int[] arr) {
        Set<Integer> numSet = new HashSet<>();

        // Insert all elements into a HashSet
        for (int num : arr) {
            numSet.add(num);
        }

        int maxLength = 0;

        // Check each number in the array
        for (int num : arr) {
            // Start a new sequence if num - 1 is not in the set
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int count = 1;

                // Count consecutive numbers
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }

                // Update max sequence length
                maxLength = Math.max(maxLength, count);
            }
        }

        return maxLength;
    }
}
