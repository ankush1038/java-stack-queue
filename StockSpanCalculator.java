import java.util.Scanner;

public class StockSpanCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input from user
        System.out.print("Enter number of days: ");
        int n = sc.nextInt();
        int[] prices = new int[n];
        System.out.println("Enter stock prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        int[] spans = calculateSpan(prices, n);

        // Displaying stock spans
        System.out.print("Stock Spans: ");
        for (int span : spans) {
            System.out.print(span + " ");
        }
        System.out.println();

        sc.close();
    }

    // Function to calculate stock spans
    public static int[] calculateSpan(int[] prices, int n) {
        int[] spans = new int[n];
        IndexStack stack = new IndexStack(n); // Stack to store indices

        for (int i = 0; i < n; i++) {
            // Pop elements from stack while stack is not empty and the price at top is less than or equal to current price
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            // If stack is empty, it means all previous prices were smaller
            if (stack.isEmpty()) {
                spans[i] = i + 1;
            } else {
                spans[i] = i - stack.peek();
            }

            // Push current index onto the stack
            stack.push(i);
        }
        return spans;
    }
}

// Manual stack implementation for storing indices
class IndexStack {
    int[] arr;
    int top;
    int size;

    public IndexStack(int size) {
        this.size = size;
        this.arr = new int[size];
        this.top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack overflow!");
            return;
        }
        arr[++top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        return arr[top--];
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return arr[top];
    }
}
