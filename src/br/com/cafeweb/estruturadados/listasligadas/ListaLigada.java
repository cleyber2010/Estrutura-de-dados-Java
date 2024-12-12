package br.com.cafeweb.estruturadados.listasligadas;

public class ListaLigada<T> {
    private No<T> first;
    private No<T> last;
    private int size;

    public ListaLigada() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public void insertNo(T element) {
        No<T> newNo = new No<T>(element);

        if (isEmpty()) {
            this.first = newNo;
            this.last = newNo;
        } else {
            this.last.setNext(newNo);
            this.last = newNo;
        }

        this.size++;
    }

    public T getListaLigada() {
        return (T) first;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }
}
