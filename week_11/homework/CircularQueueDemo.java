package week_11.homework;

import java.util.*;

class CircularQueue {
    private int[] arr;
    private int front, rear, size;

    public CircularQueue(int capacity) {
        arr = new int[capacity];
        front = -1;
        rear = -1;
        size = capacity;
    }

    public boolean isFull() {
        return (rear + 1) % size == front;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full!");
            return;
        }
        if (front == -1)
            front = 0;
        rear = (rear + 1) % size;
        arr[rear] = data;
        System.out.println("Inserted: " + data);
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.println("Deleted: " + arr[front]);
        if (front == rear)
            front = rear = -1;
        else
            front = (front + 1) % size;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.print("Queue elements: ");
        int i = front;
        while (true) {
            System.out.print(arr[i] + " ");
            if (i == rear)
                break;
            i = (i + 1) % size;
        }
        System.out.println();
    }
}

public class CircularQueueDemo {
    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(5);
        cq.enqueue(10);
        cq.enqueue(20);
        cq.enqueue(30);
        cq.display();
        cq.dequeue();
        cq.display();
    }
}
