import java.util.EmptyStackException;

class Stack {
    //ask the interviewer about capacity,make it infinite or not?,
    private int capacity;
    private int top;
    private int[] array; //easier with a stack

    Stack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity must be a positive number");
        }
        this.capacity = capacity;
        this.top = -1;
        this.array = new int[capacity];
    }

    public void push(int item) {
        if (isFull()) {
//            throw new RuntimeException("stack is full");
            int newCapacity = capacity + capacity / 2;
            int[] newArray = new int[newCapacity];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            capacity = newCapacity;
            array = newArray;
        }
        array[++top] = item;
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return array[top--];
    }

    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return array[top];
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

}