package br.com.cafeweb.estruturadados.arvore;

public class NoArvore<T> {

    private T value;
    private NoArvore<T> leftKnot;
    private NoArvore<T> rightKnot;

    public NoArvore(T value) {
        this.value = value;
        this.leftKnot = null;
        this.rightKnot = null;
    }

    public T getValue() {
        return value;
    }

    public NoArvore<T> getLeftKnot() {
        return leftKnot;
    }

    public void setLeftKnot(NoArvore<T> leftKnot) {
        this.leftKnot = leftKnot;
    }

    public NoArvore<T> getRightKnot() {
        return rightKnot;
    }

    public void setRightKnot(NoArvore<T> rightKnot) {
        this.rightKnot = rightKnot;
    }

    private int generateHash() {
        return this.value.hashCode();
    }
}
