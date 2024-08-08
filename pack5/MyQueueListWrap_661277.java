package solutions.pack5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class MyQueueListWrap_661277<T> implements
        Iterable<T> {
    private LinkedList<T> items = new LinkedList<>();
    private int count;

    public void enqueue(T d) {
        items.add(d);
        count++;
    }

    public T dequeue() {
        count--;
        return items.poll();
    }

    public T top() {
        return items.peek();
    }

    public T getLast() {
        return items.getLast();
    }

    public String dumpToString() {
        return items.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new AnyItemsIterator(this);
    }

    @Override
    public String toString() {
    StringBuilder sb = new
    StringBuilder();
    sb.append("[");
    for (int i = 0; i < items.size(); i++) {
        sb.append(items.get(i));
        if (i < items.size() - 1) {sb.append(", ");}
    }
    sb.append("]");
    return sb.toString();
    }



    private class AnyItemsIterator
            implements Iterator<T> {
        private MyQueueListWrap_661277<T> lis;
        private int idx;

        public AnyItemsIterator(MyQueueListWrap_661277<T> arg) {
            this.lis = arg;
        }

        @Override
        public boolean hasNext() {
            return (idx < lis.count);
        }

        @Override
        public T next() {
            return lis.items.get(idx++);
        }
    }

}