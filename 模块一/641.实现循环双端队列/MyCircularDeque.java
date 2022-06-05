class MyCircularDeque {
    private int[] elements;
    private int size;
    private int front, rear;
    private int capacity;

    public MyCircularDeque(int k) {
        this.size = 0;
        /**
         两个指针，一前一后，front存放第1个有效数据的前一个位置，rear存放最后一个有效元素的位置
         指针后移的时候，下标 +1，要对数组的长度取模；
         指针前移的时候，为了循环到数组的末尾，需要先加上数组的长度，然后再对数组长度取模。
         */
        this.front = 0;
        this.rear = 0;

        this.elements = new int[k];
        this.capacity = k;
    }

    public boolean insertFront(int value) {
        if (size == capacity) {
            return false;
        }
        elements[front] = value;
        front--;
        front = (front + capacity) % capacity;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (size == capacity) {
            return false;
        }
        rear++;
        rear = rear % capacity;
        elements[rear] = value;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if(size == 0) {
            return false;
        }
        front++;
        front = front % capacity;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if(size == 0) {
            return false;
        }
        rear--;
        rear = (rear + capacity) % capacity;
        size--;
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        // front存的是队头元素之前的那个位置的下标，需要+1之后对capacity取模，防止越界
        return elements[(front + 1) % capacity];
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return elements[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}
