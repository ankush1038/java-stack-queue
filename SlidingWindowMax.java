import java.util.Scanner;

public class SlidingWindowMax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input from user
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter window size (k): ");
        int k = sc.nextInt();

        int[] result = findMaxSlidingWindow(arr, n, k);

        // Displaying the result
        System.out.print("Maximum in each window: ");
        for (int max : result) {
            System.out.print(max + " ");
        }
        System.out.println();

        sc.close();
    }

    // Function to find maximum in each sliding window
    public static int[] findMaxSlidingWindow(int[] arr, int n, int k) {
        if (n < k) {
            return new int[0]; // If window size is greater than array length
        }

        int[] maxValues = new int[n - k + 1]; // Output array to store max in each window
        IndexDeque deque = new IndexDeque(n); // Manual deque implementation

        int resultIndex = 0;

        for (int i = 0; i < n; i++) {
            // Remove elements from front if they are out of the current window
            if (!deque.isEmpty() && deque.front() < i - k + 1) {
                deque.popFront();
            }

            // Remove elements from back while they are smaller than current element
            while (!deque.isEmpty() && arr[deque.back()] <= arr[i]) {
                deque.popBack();
            }

            // Add the current index at the back of deque
            deque.pushBack(i);

            // Store the maximum for the current window
            if (i >= k - 1) {
                maxValues[resultIndex++] = arr[deque.front()];
            }
        }

        return maxValues;
    }
}

// Manual deque (double-ended queue) implementation for storing indices
class IndexDeque {
    int[] arr;
    int front, back, size;

    public IndexDeque(int size) {
        this.size = size;
        this.arr = new int[size];
        this.front = 0;
        this.back = -1;
    }

    public boolean isEmpty() {
        return front > back;
    }

    public void pushBack(int value) {
        arr[++back] = value;
    }

    public void popFront() {
        if (!isEmpty()) {
            front++;
        }
    }

    public void popBack() {
        if (!isEmpty()) {
            back--;
        }
    }

    public int front() {
        return isEmpty() ? -1 : arr[front];
    }

    public int back() {
        return isEmpty() ? -1 : arr[back];
    }
}
