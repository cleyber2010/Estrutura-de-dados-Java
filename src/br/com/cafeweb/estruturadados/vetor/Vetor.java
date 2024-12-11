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

    public void add(T element ) {
        if (count >= vetor.length) {
            this.grow();
        }

        this.vetor[count] = element;
        count++;
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


}
