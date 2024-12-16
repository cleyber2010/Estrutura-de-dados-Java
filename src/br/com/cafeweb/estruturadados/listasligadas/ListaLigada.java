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

    public No<T> getListaLigada() {
        return this.first;
    }

    public void listData() {
        if (this.isEmpty()) {
            return;
        }

        for (int i = 0; i < this.size; i++) {
            System.out.println(this.first.getElement());
            this.first = first.getNext();
        }
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    public void insertIn(int index, T element) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.size);
        }
        No<T> actual = this.getNo(index);
        No<T> newNo = new No<T>(element);

        if (index == 0) {
            newNo.setNext(actual);
            this.first = newNo;
        } else if (index == this.size - 1) {
            actual.setNext(newNo);
            this.last = newNo;
        } else {
            getNo(index - 1).setNext(newNo);
            newNo.setNext(actual);
        }

        this.size++;
    }

    public No<T> getNo(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.size);
        }

        No<T> result = null;
        // 0 1 2 3 4 5
        // i 6
        for (int i = 0; i <= index; i++) {
            if (i == 0) {
                result = this.first;
            } else if (result.getNext() != null) {
                result = result.getNext();
            }
        }

        return result;
    }

    @Override
    public String toString() {
        if (this.isEmpty()) {
            return "Lista vazia []";
        }
        No<T> actual = this.first;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append((actual.getElement() != null) ? actual.getElement().toString() : "null");
        sb.append(",");
        while (actual.getNext() != null) {
            sb.append((actual.getNext().getElement() != null ? actual.getNext().getElement().toString() : "<nulo>"));

            if (actual.getNext().getNext() != null) {
                sb.append(",");
            }

            actual = actual.getNext();
        }

        sb.append("]");
        return sb.toString();
    }
}
