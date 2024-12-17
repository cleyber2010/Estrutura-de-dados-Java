package br.com.cafeweb.estruturadados.espalhamento;

import br.com.cafeweb.estruturadados.listasligadas.ListaLigada;

public class TabelaEspalhamento <T>{

    private ListaLigada<ListaLigada<T>> spreadTable;
    private int categories;
    private int size;

    public TabelaEspalhamento() {
        spreadTable = new ListaLigada<ListaLigada<T>>();
        categories = 16;
        size = 0;
    }

    public int generateHash(T elemento) {
        return elemento.hashCode() % this.categories;
    }

}
