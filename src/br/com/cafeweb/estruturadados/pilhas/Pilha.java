package br.com.cafeweb.estruturadados.pilhas;

import br.com.cafeweb.estruturadados.listasligadas.ListaDuplamenteLigada;

public class Pilha <T>{

    private ListaDuplamenteLigada<T> stack;

    public Pilha() {
        this.stack = new ListaDuplamenteLigada<T>();
    }

    public void stackUp(T elemento) {
        this.stack.insertNo(elemento);
    }

    public T unstack() {
        if (isEmpty()) {
            return null;
        }

        var result = this.stack.getElement(this.stack.size() - 1);
        this.stack.remove(result);
        return result;
    }

    public boolean isEmpty() {
        return this.stack.isEmpty();
    }


    @Override
    public String toString() {
        return "Pilha{" +
                "stack=" + stack.toString() +
                '}';
    }
}
