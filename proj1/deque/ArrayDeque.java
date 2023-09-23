package deque;

import java.util.Iterator;

public class ArrayDeque<Type> implements Iterable<Type> {
    private int first, last, size;
    private Type[] items;

    public ArrayDeque() {
        items = (Type[]) new Object[8];
        size = 0;
        first = 1;
        last = first + 1;
    }

    public void addFirst(Type item) {
        if (size >= items.length) {
            resizeItems(size * 2);
        }
        items[first] = item;
        first = getPre(first);
        size += 1;
    }

    public void addLast(Type item) {
        if (size >= items.length) {
            resizeItems(size * 2);
        }
        items[last] = item;
        last = getNext(last);
        size += 1;
    }

    public boolean isEmpty() {
        return  size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        StringBuilder stringDeque = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            stringDeque.append(get(i).toString());
            if (i != size-1)
                stringDeque.append(", ");
        }
        stringDeque.append("]");
        System.out.println(stringDeque.toString());
    }

    @Override
    public String toString() {
        StringBuilder stringDeque = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            stringDeque.append(get(i).toString());
            if (i != size-1)
                stringDeque.append(", ");
        }
        stringDeque.append("]");
        return stringDeque.toString();
    }

    public Type removeFirst() {
        if (isEmpty())
            return null;
        if (items.length > 16 && size < items.length/4)
            resizeItems(items.length/4);
        first = getNext(first);
        Type tmp = items[first];
        items[first] = null;
        size -= 1;
        return  tmp;
    }

    public Type removeLast() {
        if (isEmpty())
            return null;
        if (items.length > 16 && size < items.length/4)
            resizeItems(items.length/4);
        last = getPre(last);
        Type tmp = items[last];
        items[last] = null;
        size -= 1;
        return  tmp;
    }

    public Type get(int index) {
        if (isEmpty())
            return null;
        return items[getNext(first + index)];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return  true;
        if (o instanceof ArrayDeque otherDeque) {
            if (this.size != otherDeque.size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (!get(i).equals(otherDeque.get(i))){
                    return false;
                }
            }
            return true;
        }
        return false;
    }


    private int getPre(int index) {
        return (index - 1 + items.length) % items.length;
    }

    private int getNext(int index) {
        return (index + 1 + items.length) % items.length;
    }

    public void resizeItems(int capacity) {
        if (capacity < 16)
            capacity = 16;
        Type[] a =  (Type[]) new Object[capacity];
        int start = getNext(first);
        int end = getPre(last);
        if (start <= end) {
            if (capacity > items.length) {
                System.arraycopy(items, start, a, start, size);
            } else {
                System.arraycopy(items, start, a, 1, size);
                first = 0;
                last = size + 1;
            }
        } else {
            System.arraycopy(items, start, a, capacity - (items.length - start), items.length - start);
            first += capacity - items.length;
            System.arraycopy(items, 0, a, 0, last);
        }
        items = a;
    }

    private class DequeIterator implements Iterator<Type> {
        private int index;

        public DequeIterator() {
            index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public Type next() {
            if (index >= size)
                return null;
            return get(index++);
        }
    }

    public Iterator<Type> iterator() {
        return new DequeIterator();
    }

}
