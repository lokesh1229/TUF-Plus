package DSA.QUEUES;

import java.util.Scanner;

public class QueueUsingArrays {
    private int queue[];
    private int size;
    private int currSize;
    private int start, end;

    QueueUsingArrays(int size){
        this.size = size;
        queue = new int[size];
        currSize = 0;
        start = end = -1;
    }

    public void push(int x){
        if(currSize == size){
            System.out.println("Queue is full");
            return;
        }

        if(end == -1){
            start = 0;
            end = 0;
        } else {
            end = (end + 1) % size;
        }

        queue[end] = x;
        currSize++;
        System.out.println("Inserted: " + x);
    }

    public int pop(){
        if(currSize == 0){
            System.out.println("Queue is empty");
            return -1;
        }

        int x = queue[start];

        if(currSize == 1){
            start = -1;
            end = -1;
        } else {
            start = (start + 1) % size;
        }

        currSize--;
        return x;
    }

    public int peek(){
        if(currSize == 0){
            System.out.println("Queue is empty");
            return -1;
        }
        return queue[start];
    }

    public void display(){
        if(currSize == 0){
            System.out.println("Queue is empty");
            return;
        }

        System.out.print("Queue elements: ");
        int i = start;
        for(int count = 0; count < currSize; count++){
            System.out.print(queue[i] + " ");
            i = (i + 1) % size;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of queue: ");
        int n = sc.nextInt();

        QueueUsingArrays q = new QueueUsingArrays(n);

        int choice;

        do {
            System.out.println("\n--- Queue Menu ---");
            System.out.println("1. Push (Enqueue)");
            System.out.println("2. Pop (Dequeue)");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch(choice){
                case 1:
                    System.out.print("Enter element: ");
                    int x = sc.nextInt();
                    q.push(x);
                    break;

                case 2:
                    int removed = q.pop();
                    if(removed != -1)
                        System.out.println("Removed: " + removed);
                    break;

                case 3:
                    int front = q.peek();
                    if(front != -1)
                        System.out.println("Front element: " + front);
                    break;

                case 4:
                    q.display();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while(choice != 5);

        sc.close();
    }
}