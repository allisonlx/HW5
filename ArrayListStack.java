package com.edu.miracosta.cs113;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class ArrayListStack<E> implements StackInterface<E> {

    ArrayList<E> list;

    public ArrayListStack(){
        list = new ArrayList<>();
    }


    @Override
    public boolean empty() {
        return list.isEmpty();
    }

    @Override
    public E peek() {
        if (empty()) throw new EmptyStackException();
        return list.get(list.size() - 1);
    }

    @Override
    public E pop() {
        if (empty()) throw new EmptyStackException();
        return list.remove(list.size() - 1);
    }

    @Override
    public E push(E obj) {
        list.add(obj);
        return obj;
    }
}
