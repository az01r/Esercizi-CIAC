/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackvisitabile;

import java.util.Arrays;
import java.util.Iterator;

/**
 *
 * @author alfonso
 */
public class MioStack<T> implements Stack<T>, Iterable<T> {

    private final T[] stack;

    private final int length;

    private int idx = -1;

    public MioStack(int length) {
        this.stack = (T[]) new Object[length];
        this.length = length;
    }

    @Override
    public boolean put(T t) {
        if (idx == stack.length - 1) {
            return false;
        }
        stack[++idx] = t;
        return true;
    }

    @Override
    public T get() {
        if (idx == -1) {
            return null;
        }
        T result = stack[idx];
        stack[idx] = null;
        --idx;
        return result;
    }

    @Override
    public int length() {
        return this.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(stack);
    }

    @Override
    public Iterator<T> iterator() {
       return new StackIterator();
    }

    private class StackIterator implements Iterator<T> {

        private int current;

        public StackIterator() {
            this.current = -1;
        }

        @Override
        public boolean hasNext() {
            return this.current < stack.length - 1;
        }

        @Override
        public T next() {
            return stack[++current];
        }

    }
}
