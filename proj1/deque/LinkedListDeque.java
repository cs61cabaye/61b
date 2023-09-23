package deque;

import java.util.Iterator;

public class LinkedListDeque<Type> implements Deque<Type>{
    /* inner class of the Node*/
    private class Node{
        public Node prev;
        public  Type item;
        public Node next;

        public Node(Type i, Node p, Node n){
            item = i;
            prev = p;
            next = n;
        }
    }
    private class DequeIterator implements Iterator<Type> {
        private  int pos;
        private  Node curNode;
        public DequeIterator() {
            pos = 0;
            curNode = sentinel;
        }

        @Override
        public boolean hasNext() {
            return pos < size;
        }

        @Override
        public Type next() {
            if (pos >= size)
                return null;
            pos += 1;
            curNode = curNode.next;
            return curNode.item;
        }
    }

    public LinkedListDeque(){
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    @Override
    public void addFirst(Type item) {
        Node tmp = sentinel.next;
        sentinel.next = new Node(item, sentinel,  tmp);
        tmp.prev = sentinel.next;
        size += 1;
    }

    @Override
    public void addLast(Type item) {
        Node tmp = sentinel.prev;
        sentinel.prev = new Node(item, tmp,  sentinel);
        tmp.next = sentinel.prev;
        size += 1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        StringBuilder stringDeque = new StringBuilder("[");
        Node p = sentinel.next;
        while (p != sentinel) {
            stringDeque.append(p.item.toString());
            p = p.next;
            if (p != sentinel)
                stringDeque.append(", ");
        }
        stringDeque.append("]");
        System.out.println(stringDeque.toString());
    }

    @Override
    public String toString() {
        StringBuilder stringDeque = new StringBuilder("[");
        Node p = sentinel.next;
        while (p != sentinel) {
            stringDeque.append(p.item.toString());
            p = p.next;
            if (p != sentinel)
                stringDeque.append(", ");
        }
        stringDeque.append("]");
        return stringDeque.toString();
    }


    @Override
    public Type removeFirst() {
        if (isEmpty())
            return null;
        Node tmpNode = sentinel.next;
        sentinel.next = tmpNode.next;
        tmpNode.next.prev = sentinel;
        size -= 1;
        tmpNode.prev = tmpNode.next = null;
        return  tmpNode.item;
    }

    @Override
    public Type removeLast() {
        if (isEmpty())
            return null;
        Node tmpNode = sentinel.prev;
        sentinel.prev = tmpNode.prev;
        tmpNode.prev.next = sentinel;
        size -= 1;
        tmpNode.prev = tmpNode.next = null;
        return  tmpNode.item;
    }

    @Override
    public Type get(int index) {
        Node p = sentinel.next;
        while (p != sentinel){
            if (index == 0)
                return p.item;
            p = p.next;
            index -= 1;
        }
        return null;
    }

    private Type getRecursive(int index, Node p) {
        if (p == sentinel) {
            return null;
        } else if (index == 0) {
            return p.item;
        } else {
            return getRecursive(index - 1, p.next);
        }
    }

    public Type getRecursive(int index) {
        if (isEmpty())
            return null;
        return  getRecursive(index, sentinel.next);
    }

    @Override
    public Iterator<Type> iterator() {
        return new DequeIterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return  true;
        if (o instanceof LinkedListDeque otherDeque) {
            if (this.size != otherDeque.size) {
                return false;
            }
            Node p = sentinel.next;
            Node q = otherDeque.sentinel.next;
            while (p != sentinel) {
                if (p.item.equals(q.item)){
                    p = p.next;
                    q = q.next;
                } else {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private Node sentinel;
    private int size;
}
