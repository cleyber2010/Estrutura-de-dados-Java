package br.com.cafeweb.estruturadados.conjuntos;

import br.com.cafeweb.estruturadados.listasligadas.ListaLigada;

/**
 * The set data structure does not allow duplicate data
 * @param <T>
 */

public class Conjunto <T>{
    private ListaLigada<T> set;

    public Conjunto() {
        this.set = new ListaLigada<T>();
    }

    public boolean insert(T elemento) {

        if (elemento != null && !this.contains(elemento)) {
            set.insertNo(elemento);
            return true;
        }
        return false;
    }

    public boolean insertIn(int index, T elemento) {
        if (elemento != null && !this.contains(elemento)) {
            set.insertIn(index, elemento);
            return true;
        }

        return false;
    }

    public void remove(T elemento) {
        set.remove(elemento);
    }

    public void removeIndex(int index) {
        set.removeIndex(index);
    }

    private boolean contains(T elemento) {
        if (!set.isEmpty()) {
            for (int i = 0; i < set.size(); i++) {
                var el = set.getElement(i);
                if (el.hashCode() == elemento.hashCode()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Conjunto{" +
                "set=" + set +
                '}';
    }
}
