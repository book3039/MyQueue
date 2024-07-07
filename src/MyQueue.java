public class MyQueue {
    private final int[] array;
    private final int capacity;
    private int head;
    private int tail;
    private boolean isFull = false;
    private boolean isEmpty = true;

    public MyQueue(int capacity) {
        array = new int[capacity];
        this.capacity = capacity;
        head = 0;
        tail = 0;
    }

    public void add(int element) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        if (isEmpty()) {
            isEmpty = false;
        } else {
            tail = (tail + 1) % capacity;
        }

        array[tail] = element;

        if ((tail + 1) % capacity == head) {
            isFull = true;
        }
    }

    public int remove() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        if (isFull()) {
            isFull = false;
        }
        int item = array[head];
        head = (head + 1) % capacity;
        if (head > tail) {
            isEmpty = true;
            head = tail = 0;
        }
        return item;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return array[head];
    }

    public boolean isFull() {
        return isFull;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        if (head < tail) {
            for (int i = head; i <= tail; i++) {
                System.out.println(array[i]);
            }
        } else if (head == tail) {
            if (!isEmpty()) {
                System.out.println(array[head]);
            }
        } else {
            for (int i = head; i < capacity; i++) {
                System.out.println(array[i]);
            }

            for (int i = 0; i <= tail; i++) {
                System.out.println(array[i]);
            }
        }
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue(10);

        queue.print();

    }
}
