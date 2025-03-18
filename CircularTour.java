import java.util.Scanner;

public class CircularTour {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input from user
        System.out.print("Enter the number of petrol pumps: ");
        int n = sc.nextInt();

        int[] petrol = new int[n];
        int[] distance = new int[n];

        System.out.println("Enter petrol and distance for each pump:");
        for (int i = 0; i < n; i++) {
            System.out.print("Pump " + (i + 1) + " - Petrol: ");
            petrol[i] = sc.nextInt();
            System.out.print("Pump " + (i + 1) + " - Distance: ");
            distance[i] = sc.nextInt();
        }

        int startIndex = findStartingPoint(petrol, distance, n);

        // Displaying the result
        if (startIndex == -1) {
            System.out.println("No circular tour is possible.");
        } else {
            System.out.println("Start the tour from petrol pump index: " + startIndex);
        }

        sc.close();
    }

    // Function to find the starting petrol pump index
    public static int findStartingPoint(int[] petrol, int[] distance, int n) {
        int totalPetrol = 0, totalDistance = 0;
        int start = 0, balance = 0;

        // Calculate total petrol and total distance
        for (int i = 0; i < n; i++) {
            totalPetrol += petrol[i];
            totalDistance += distance[i];
        }

        // If total petrol is less than total distance, tour is not possible
        if (totalPetrol < totalDistance) {
            return -1;
        }

        // Finding the starting point
        for (int i = 0; i < n; i++) {
            balance += petrol[i] - distance[i];

            // If balance becomes negative, reset start index to next pump
            if (balance < 0) {
                start = i + 1;
                balance = 0;
            }
        }

        return start;
    }
}
