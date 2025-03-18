import java.util.Scanner;

public class QueueUsingStacks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CustomQueue queue = new CustomQueue(10); // Set max size

        while (true) {
            System.out.println("\nQueue Using Two Stacks");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display Queue");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter value to enqueue: ");
                int value = sc.nextInt();
                queue.enqueue(value);
            } else if (choice == 2) {
                queue.dequeue();
            } else if (choice == 3) {
                queue.display();
            } else if (choice == 4) {
                System.out.println("Exiting...");
                sc.close();
                break;
            } else {
                System.out.println("Invalid choice! Try again.");
            }
        }
    }
}

// Manual Stack Implementation (without built-in Stack class)
class CustomStack {
    int[] arr;
    int top;
    int size;

    public CustomStack(int size) {
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
    }
}

// Queue using Two Stacks
class CustomQueue {
    CustomStack stack1, stack2;
    int maxSize;

    public CustomQueue(int size) {
        maxSize = size;
        stack1 = new CustomStack(size);
        stack2 = new CustomStack(size);
    }

    public void enqueue(int value) {
        if (stack1.isFull()) {
            System.out.println("Queue is full!");
            return;
        }
        stack1.push(value);
        System.out.println("Enqueued: " + value);
    }

    public void dequeue() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        int removed = stack2.pop();
        System.out.println("Dequeued: " + removed);
    }

    public void display() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }

        System.out.print("Queue: ");
        if (!stack2.isEmpty()) {
            stack2.printStack();
        }
        if (!stack1.isEmpty()) {
            for (int i = stack1.top; i >= 0; i--) {
                System.out.print(stack1.arr[i] + " ");
            }
        }
        System.out.println();
    }
}
