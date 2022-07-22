package com.edu.miracosta.cs113;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

public class CircularArrayQueue<E> implements Queue<E> {

    private int front;
    private int rear;
    private int size;
    private int capacity;
    private static final int DEFAULT_CAPACITY = 10;

    private E[] data;

    public CircularArrayQueue(){
        this(DEFAULT_CAPACITY);
    }

    public CircularArrayQueue(int initCapacity){
        capacity = initCapacity;
        data = (E[]) new Object[capacity];
        front = 0;
        rear = capacity - 1;
        size = 0;
    }

    @Override
    public boolean add(E e) {
        offer(e);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        for (Object o : c){
            offer((E)o);
        }
        return true;
    }

    @Override
    public void clear() {
        for (E e: this){
            remove();
        }

    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public boolean offer(E e) {
        if (size == capacity) reallocate();
        size++;
        rear = (rear + 1) % capacity;
        data[rear] = e;
        return true;
    }

    @Override
    public E remove() {
        if (size == 0) throw new NoSuchElementException();
        else return poll();
    }

    @Override
    public E poll() {
        if (size == 0) return null;
        E result = data[front];
        front = (front + 1) % capacity;
        size--;
        return result;
    }

    @Override
    public E element() {
        if (size == 0) throw new NoSuchElementException();
        return peek();
    }

    @Override
    public E peek() {
        if (size == 0) return null;
        else return data[front];
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @SuppressWarnings("unchecked")
    private void reallocate() {
        int newCapacity = 2 * capacity;
        E[] newData = (E[]) new Object[newCapacity];
        int j = front;
        for (int i = 0; i < size; i++) {
            newData[i] = data[j];
            j = (j + 1) % capacity;
        }
        front = 0;
        rear = size - 1;
        capacity = newCapacity;
        data = newData;
    }
}
