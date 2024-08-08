package solutions.pack5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class MyQueueExtendsLinkedList<T> extends LinkedList<T> {
        public void enqueue(T d) {
            this.add(d);
        }

        public T dequeue() {
            return this.poll();
        }

        public T top() {
            return this.peek();
        }

        public String dumpToString() {
            return super.toString();
        }

        @Override
        public String toString(){
            return dumpToString();
        }
    }

     class Type1<T> {
        private ArrayList<T> items = new ArrayList<>();
        private int count;

        public void add(T item) {
            items.add(item);
            count++;
        }

        public T get(int index) {
            return items.get(index);
        }
    }

    class Type2<T> implements Iterable<T> {
        private ArrayList<T> items = new ArrayList<>();
        private int count;

        public void add(T item) {
            items.add(item);
            count++;
        }

        public T get(int index) {
            return items.get(index);
        }

        @Override
        public Iterator<T> iterator() {
            return new AnyItemsIterator(this);
        }

        private class AnyItemsIterator implements Iterator<T> {
            private Type2<T> list;
            private int idx;

            public AnyItemsIterator(Type2<T> arg) {
                this.list = arg;
                this.idx = 0;
            }

            @Override
            public boolean hasNext() {
                return idx < list.count;
            }

            @Override
            public T next() {
                return list.items.get(idx++);
            }
        }
    }
