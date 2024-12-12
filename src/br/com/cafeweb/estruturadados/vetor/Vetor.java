package br.com.cafeweb.estruturadados.vetor;

import java.util.Arrays;

/**
 * The vector class will have a generic type
 * You will be responsible for manipulating the vectors
 * Every class in Java inherits from the Object class
 */

public class Vetor<T> {
    private Object[] vetor;
    private int count;

    /**
     * Constructor
     */
    public Vetor() {
        this.vetor = new Object[10];
    }

    public void add(T element) {
        if (count >= vetor.length) {
            this.grow();
        }

        this.vetor[count] = element;
        count++;
    }

    public void addIndex(int index, T element) {
        if (index < 0 || index >= this.size()) {
            throw new ArrayIndexOutOfBoundsException(index);
        }

        if (this.vetor[index] != null) {
            Object[] arrayStart = Arrays.copyOfRange(this.vetor, 0, index); //10,20
            Object[] arrayEnd = Arrays.copyOfRange(this.vetor, index, vetor.length); //30,40,50
            arrayStart = Arrays.copyOf(arrayStart, arrayStart.length + 1);
            arrayStart[index] = element;
            this.vetor = new Object[arrayStart.length + arrayEnd.length];
            System.arraycopy(arrayStart, 0, this.vetor, 0, arrayStart.length);
            System.arraycopy(arrayEnd, 0, this.vetor, arrayStart.length, arrayEnd.length);
            this.count++;
        } else {
            this.vetor[index] = element;
            this.count++;
        }
    }

    public void grow() {
        this.vetor = Arrays.copyOf(this.vetor, this.size() + 1);
    }

    @SuppressWarnings("unchecked")
    public T getVetor(int position) throws IndexOutOfBoundsException {
        if (position < 0 || position >= this.size()) {
            throw new ArrayIndexOutOfBoundsException(position);
        }

        return (T) this.vetor[position];
    }

    public int size() {
        return vetor.length;
    }

    public boolean has(T element) {
        for (int i = 0; i < size(); i++) {
            if (this.vetor[i] != null && this.vetor[i].equals(element)) {
                return true;
            }
        }

        return false;
    }

    public int searchIndex(T element) {
        for (int i = 0; i < size(); i++) {
            if (this.vetor[i] != null && this.vetor[i].equals(element)) {
                return i;
            }
        }

        return -1;
    }

    public void remove (T element) {
        //10,20,30,40,50
        // element 40
        var index = this.searchIndex(element);

        if (index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }

        Object[] arrayStart = Arrays.copyOfRange(this.vetor, 0, index);
        Object[] arrayEnd = Arrays.copyOfRange(this.vetor, index + 1, this.size());
        this.vetor = new Object[this.size() - 1];
        System.arraycopy(arrayStart, 0, this.vetor, 0 , arrayStart.length);
        System.arraycopy(arrayEnd, 0, this.vetor, arrayStart.length, arrayEnd.length);
        count --;
    }
}
