package br.com.cafeweb.estruturadados.espalhamento;

import br.com.cafeweb.estruturadados.listasligadas.ListaLigada;

public class TabelaEspalhamento <T>{

    private ListaLigada<ListaLigada<T>> spreadTable;
    private int categories = 16;
    private int size;

    public TabelaEspalhamento() {
        spreadTable = new ListaLigada<ListaLigada<T>>();
        for (int i = 0; i < categories; i++) {
            spreadTable.insertNo(new ListaLigada<T>());
        }
        size = 0;
    }

    public boolean insert(T element) {
        if (element != null && !this.contains(element)) {
            ListaLigada<T> category = spreadTable.getElement(this.generateHash(element));
            category.insertNo(element);
            this.size++;
            return true;
        }
        return false;
    }

    public void remove(T element) {
        ListaLigada<T> category = spreadTable.getElement(this.generateHash(element));
        category.remove(element);
        this.size--;
    }

    public int size() {
        return this.size;
    }

    private int generateHash(T elemento) {
        return elemento.hashCode() % this.categories;
    }

    private boolean contains(T elemento) {
        ListaLigada<T> category = spreadTable.getElement(this.generateHash(elemento));
        return category.contains(elemento);
    }

}
