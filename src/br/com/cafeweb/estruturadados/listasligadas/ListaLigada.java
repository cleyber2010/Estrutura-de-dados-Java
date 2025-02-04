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

    public boolean contains(T element) {
        for (int i = 0; i < this.size; i++) {
            No<T> actual = this.getNo(i);
            if (actual.getElement() != null && actual.getElement().equals(element)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(T element) {
        for (int i = 0; i < this.size; i++) {
            No<T> actual = this.getNo(i);
            if (actual.getElement() != null && actual.getElement().equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public No<T> getNo(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.size);
        }

        No<T> result = null;

        for (int i = 0; i <= index; i++) {
            if (i == 0) {
                result = this.first;
            } else if (result.getNext() != null) {
                result = result.getNext();
            }
        }

        return result;
    }

    public void remove(T element) {
        No<T> actual = this.getNo(this.indexOf(element));

        if (actual.getElement() != null && actual.getElement().equals(this.first.getElement())) {
            if (actual.getNext() != null) {
                No<T> next = this.getNo(this.indexOf(element) + 1);
                this.first = next;
                actual.setNext(null);
            }
            this.first = null;
        } else if (actual.getElement() != null && actual.getElement().equals(this.last.getElement())) {
            No<T> previus = this.getNo(this.indexOf(element) - 1);
            this.last = previus;
            this.last.setNext(null);
        } else {
            No<T> previus = this.getNo(this.indexOf(element) - 1);
            No<T> next = this.getNo(this.indexOf(element) + 1);

            previus.setNext(next);
            actual.setNext(null);
        }

        this.size--;
    }

    public void removeIndex(int index) {
        remove(this.getNo(index).getElement());
    }

    public T getElement(int index) {
        return this.getNo(index).getElement();
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
