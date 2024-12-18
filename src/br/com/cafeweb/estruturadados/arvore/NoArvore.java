package br.com.cafeweb.estruturadados.arvore;

public class NoArvore<T> {

    private T value;
    private NoArvore<T> leftNode;
    private NoArvore<T> rightNode;

    public NoArvore(T value) {
        this.value = value;
        this.leftNode = null;
        this.rightNode = null;
    }

    public T getValue() {
        return value;
    }

    public NoArvore<T> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(NoArvore<T> leftNode) {
        this.leftNode = leftNode;
    }

    public NoArvore<T> getRightNode() {
        return rightNode;
    }

    public void setRightNode(NoArvore<T> rightNode) {
        this.rightNode = rightNode;
    }

    public int hash() {
        return this.value.hashCode();
    }

    @Override
    public String toString() {
        return (this.leftNode == null ? "[ESQ: (X) ]" : this.leftNode.toString()) +
                "[ " + this.value.toString() + " ]" +
                (this.rightNode == null ? "[DIR: (X) ]" : this.rightNode.toString());
    }
}
