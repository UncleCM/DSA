package solutions.pack3;

public class MyArray extends MyArrayBasic {
    public MyArray() {
        super();
        MAX_SIZE = 100_000;
        data = new int[MAX_SIZE];
    }

    public MyArray(int max) {
        super();
        MAX_SIZE = max;
        data = new int[MAX_SIZE];
    }

    public boolean isFull() {
        return size == MAX_SIZE;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void expandByK(int k) {
        int newMaxSize = k * MAX_SIZE;
        int[] newData = new int[newMaxSize];
        System.arraycopy(data, 0, newData, 0, size);
        MAX_SIZE = newMaxSize;
        data = newData;
    }

    public void  expand() {
        expandByK(2);
    }

    @Override
    public void add(int n) {
        if (isFull()) {
            expand();
        }
        super.add(n);
    }

    @Override
    public void insert(int n, int index) {
        if (isFull()) {
            expand();
        }
        super.insert(n, index);
    }
    @Override
    public void delete(int index){
        if (!isEmpty()){
            super.delete(index);
        }
    }
}