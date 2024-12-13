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

    @Override
    public String toString() {
        if (this.isEmpty()) {
            return "Lista vazia []";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (this.first.getNext() != null) {
            sb.append((this.first.getElement() != null ? this.first.getElement().toString() : "<nulo>"));

            if (this.first.getNext().getNext() != null) {
                sb.append(",");
            }

            this.first = first.getNext();
        }
        sb.append("]");
        return sb.toString();
    }
}
