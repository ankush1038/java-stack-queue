import java.util.Scanner;

public class RecursiveStackSort{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ManualStack stack = new ManualStack(10); // Stack size

        // Taking input from user
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        System.out.println("Enter stack elements:");
        for (int i = 0; i < n; i++) {
            stack.push(sc.nextInt());
        }

        // Sorting the stack using recursion
        sortStack(stack);

        // Display sorted stack
        System.out.print("Sorted Stack: ");
        stack.printStack();

        sc.close();
    }

    // Recursive function to sort the stack
    public static void sortStack(ManualStack stack) {
        if (!stack.isEmpty()) {
            // Pop top element
            int temp = stack.pop();
            // Recursively sort the remaining stack
            sortStack(stack);
            // Insert the popped element back at the correct position
            insertSorted(stack, temp);
        }
    }

    // Insert an element into a sorted stack
    public static void insertSorted(ManualStack stack, int value) {
        if (stack.isEmpty() || stack.peek() <= value) {
            stack.push(value);
        } else {
            int temp = stack.pop();
            insertSorted(stack, value);
            stack.push(temp);
        }
    }
}

// Manual Stack Implementation (without built-in Stack class)
class ManualStack {
    int[] arr;
    int top;
    int size;

    public ManualStack(int size) {
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
            System.out.println("Stack underflow!");
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

    public void printStack() {
        for (int i = 0; i <= top; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
