package br.com.cafeweb.estruturadados.listasligadas;

public class ListaDuplamenteLigada<T> {
    private No<T> first;
    private No<T> last;
    private int size;

    public ListaDuplamenteLigada() {
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
            newNo.setPrevious(this.last);
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
            actual.setPrevious(newNo);
            this.first = newNo;
        } else if (index == this.size - 1) {
            actual.setNext(newNo);
            newNo.setPrevious(actual);
            this.last = newNo;
        } else {
            actual.getPrevious().setNext(newNo);
            newNo.setPrevious(actual.getPrevious());
            newNo.setNext(actual);
            actual.setPrevious(newNo);
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
            No<T> next = this.first.getNext();
            actual.setNext(null);
            next.setPrevious(null);
            this.first = next;
        } else if (actual.getElement() != null && actual.getElement().equals(this.last.getElement())) {
            No<T> previous = this.last.getPrevious();
            previous.setNext(null);
            this.last.setPrevious(null);
            this.last = previous;
        } else {
            No<T> previous = actual.getPrevious();
            No<T> next = actual.getNext();

            previous.setNext(next);
            next.setPrevious(previous);
            actual.setPrevious(null);
            actual.setNext(null);
        }

        this.size--;
    }

    public void removeIndex(int index) {
        remove(this.getNo(index).getElement());
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
