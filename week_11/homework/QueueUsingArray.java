package week_11.homework;

import java.util.*;

class QueueArray {
    private int[] arr;
    private int front, rear, size;

    public QueueArray(int capacity) {
        arr = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean isFull() {
        return size == arr.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full!");
            return;
        }
        rear++;
        arr[rear] = item;
        size++;
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.println("Dequeued: " + arr[front]);
        for (int i = 0; i < rear; i++)
            arr[i] = arr[i + 1];
        rear--;
        size--;
    }

    public void peek() {
        if (!isEmpty())
            System.out.println("Front element: " + arr[front]);
        else
            System.out.println("Queue is empty!");
    }

    public void display() {
        System.out.print("Queue: ");
        for (int i = 0; i <= rear; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}

public class QueueUsingArray {
    public static void main(String[] args) {
        QueueArray q = new QueueArray(5);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.display();
        q.dequeue();
        q.peek();
        q.display();
    }
}
