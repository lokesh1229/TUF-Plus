import java.util.*;
class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        next = null;
    }
}
public class StackUsingLinkedList {
    
    Node head;
    int size;

    public StackUsingLinkedList() {
        head = null;
        size = 0;
    }

    public void push(int data){
        Node x = new Node(data);
        x.next = head;
        head = x;
        size++;
    }

    public int pop(){
        if(head==null){
            return -1;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int peek(){
        if(head==null){
            return -1;
        }
        int val = head.data;
        return val;
    }

    public int size(){
        return size;
    }

    public void printStack(){
        if(head==null){
            System.out.println("Stack is Empty");
        }
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StackUsingLinkedList s = new StackUsingLinkedList();

        int choice;

        do {
            System.out.println("\n1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display Elements");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch(choice){
                case 1:
                    System.out.print("Enter element: ");
                    int x = sc.nextInt();
                    s.push(x);
                    break;

                case 2:
                    s.pop();
                    break;

                case 3:
                    int val = s.peek();
                    if(val != -1)
                        System.out.println(val);
                    break;

                case 4:
                    s.printStack();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while(choice != 5); // ✅ correct exit condition

        sc.close();
    }
}
