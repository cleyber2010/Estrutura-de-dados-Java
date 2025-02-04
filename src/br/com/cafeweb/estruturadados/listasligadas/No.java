package br.com.cafeweb.estruturadados.listasligadas;

class No<T> {
    private T element;
    private No<T> next;
    private No<T> previous;

    public No() {
        this.next = null;
    }

    public No(T element) {
        this.element = element;
        this.next = null;
    }

    public No(T element, No<T> next) {
        this.element = element;
        this.next = next;
    }

    public T getElement() {
        return this.element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public No<T> getNext() {
        return this.next;
    }

    public void setNext(No<T> next) {
        this.next = next;
    }

    public No<T> getPrevious() {
        return this.previous;
    }

    public void setPrevious(No<T> previous) {
        this.previous = previous;
    }

}
