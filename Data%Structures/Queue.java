/**
 *               A Queue is a FIFO object i.e,
 *               The element that is first in will be out first
 *               It is like a queue in the Bank
 *
 * @param <T>    The Generic Data Type
 */
public class Queue<T> {

    private Node head = new Node();
    private int size = 0;
    
    /**
     * The main Elements of a Queue are made of such objects.
     */
    public class Node {
        public T value;
        public Node next;
    }

    /**
     *               Enqueues a given key
     * 
     * @param key    The key/item to be enqueued
     */
    public void enqueue(T key) { 
        Node temp = new Node();
        temp.value = key;
        if (size == 0) {
            head.next = temp;
        } else {
            temp.next = head.next;
            head.next = temp;
        }
        size++;
    }

    /**
     *            Deques the First item in the Que
     * 
     * @return    The key/item Dequed
     */
    public T dequeue() {
        size--;
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        T value = temp.next.value;
        temp.next = null;
        return value;
        
    }
  
    /**
     * @return    The size of the current Que
     */
    public int size() {
        return size;
    }

    /**
     * @return    The item at the rear end
     */
    public T rear() {
        Node temp = head;
        while (temp.next != null) temp = temp.next;
        return temp.value;
    }

    /**
     * @return    The item at the first
     */
    public T front() {
        return head.next.value;
    }
    
    public static void main(String[] args) {
        Queue<Integer> que = new Queue<Integer>();
        que.enqueue(4);
        que.enqueue(5);
        que.enqueue(6);
        que.enqueue(7);
        que.enqueue(8);
        que.enqueue(9);
        System.out.println(que.dequeue() + " | " + que.size() + " | " + que.rear() + " | " + que.front());
        System.out.println(que.dequeue() + " | " + que.size() + " | " + que.rear() + " | " + que.front());
        System.out.println(que.dequeue() + " | " + que.size() + " | " + que.rear() + " | " + que.front());
        System.out.println(que.dequeue() + " | " + que.size() + " | " + que.rear() + " | " + que.front());
        System.out.println(que.dequeue() + " | " + que.size() + " | " + que.rear() + " | " + que.front());

    }
}