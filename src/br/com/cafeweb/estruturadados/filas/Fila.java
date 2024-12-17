package br.com.cafeweb.estruturadados.filas;

import br.com.cafeweb.estruturadados.listasligadas.ListaLigada;

public class Fila <T>{
    private ListaLigada<T> queue;

    public Fila() {
        this.queue = new ListaLigada<T>();
    }

    public void enqueue(T elemento) {
        this.queue.insertNo(elemento);
    }
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }

        T result = queue.getElement(0);
        queue.removeIndex(0);
        return result;
    }

    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    @Override
    public String toString() {
        return "Fila{" +
                "queue=" + queue.toString() +
                '}';
    }
}
