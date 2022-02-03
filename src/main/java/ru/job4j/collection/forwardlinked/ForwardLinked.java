package ru.job4j.collection.forwardlinked;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;

    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    public boolean revert() {
        boolean res = true;
        if (head == null || head.next == null) {
        return false;
        }
        Node<T> prev = null;
        Node<T> curr = head;
        while (curr != null) {
        Node<T> next = curr.next; /* адрес на следующий */
        curr.next = prev; /* ставим null */
        prev = curr;
        curr = next;
        }
        head = prev;
        return res;
    }

    public void addFirst(T value) {
        head = new Node<T>(value, head);
    }

    public T deleteFirst() {
        Node<T> delValue = head;
        if (head == null) {
            throw new NoSuchElementException();
        }
        head = head.next;
        delValue.next = null;
        return delValue.value;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
