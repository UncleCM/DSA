package solutions.pack3;

public class MyArrayBasic {
    protected int MAX_SIZE = 5;
    protected int data[] = new int[MAX_SIZE];
    protected int size = 0;

    public MyArrayBasic(int...a) {
        MAX_SIZE = a.length;
    }

    public void add(int d){
        data[size] = d;
        size += 1;
    }

    public void insert(int d, int index){
        data[size++] = data[index];
        data[index] = d;
    }

    public int find(int d){
        for (int i=0; i<size; i++){
            if (data[i] == d){
                return i;
            }
        }
        return -1;
    }

    public int binarySearch(int d) {
        int a = 0, b=size-1;
        while(a<=b) {
        int m = (a+b)/2;
        if(data[m]==d) return m;
        if(d<data[m]) b = m-1;
        else a = m+1; // d>data[m]
        }
        return -1;
        }
    public void delete(int index){
        for(int i = index; i < size -1; i++){
            data[i] = data[i+1];
        }
        size--;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
