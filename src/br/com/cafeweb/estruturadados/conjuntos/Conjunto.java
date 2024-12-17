package br.com.cafeweb.estruturadados.conjuntos;

import br.com.cafeweb.estruturadados.espalhamento.TabelaEspalhamento;
import br.com.cafeweb.estruturadados.listasligadas.ListaLigada;

/**
 * The set data structure does not allow duplicate data
 * @param <T>
 */

public class Conjunto <T>{

    private TabelaEspalhamento<T> set;

    public Conjunto() {
        this.set = new TabelaEspalhamento<>();
    }

    public boolean insert(T elemento) {
        return set.insert(elemento);
    }

    public void remove(T elemento) {
        set.remove(elemento);
    }

    public boolean isEmpty() {
        return set.size() == 0;
    }

    @Override
    public String toString() {
        return "Conjunto{" +
                "set=" + set +
                '}';
    }
}
