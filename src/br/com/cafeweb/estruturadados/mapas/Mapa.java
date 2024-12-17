package br.com.cafeweb.estruturadados.mapas;

import br.com.cafeweb.estruturadados.listasligadas.ListaLigada;

public class Mapa<K, V> {
    private ListaLigada<ListaLigada<Associacao<K, V>>> map;
    private int categories = 16;

    public Mapa() {
        this.map = new ListaLigada<ListaLigada<Associacao<K, V>>>();
        for (int i = 0; i < this.categories; i++) {
            this.map.insertNo(new ListaLigada<Associacao<K, V>>());
        }
    }

    public boolean insert(K key, V value) {
        if (this.contains(key)) {
            this.remove(key);
        }

        ListaLigada<Associacao<K, V>> category = map.getElement(generateHash(key));
        category.insertNo(new Associacao<K, V>(key, value));
        return true;
    }

    public V getValue(K key) {
        ListaLigada<Associacao<K, V>> category = map.getElement(generateHash(key));
        V result = null;
        for (int i = 0; i < category.size(); i++) {
            Associacao<K, V> associacao = category.getElement(i);
            if (associacao.getKey().equals(key)) {
                result = associacao.getValue();
            }
        }
        return result;
    }

    public boolean contains(K key) {
        ListaLigada<Associacao<K, V>> category = map.getElement(generateHash(key));
        for (int i = 0; i < category.size(); i++) {
            Associacao<K, V> associacao = category.getElement(i);
            if (associacao.getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    public void remove(K key) {
        ListaLigada<Associacao<K, V>> category = map.getElement(generateHash(key));
        for (int i = 0; i < category.size(); i++) {
            Associacao<K, V> associacao = category.getElement(i);
            if (associacao.getKey().equals(key)) {
                category.remove(associacao);
                return;
            }
        }
    }

    public int generateHash(K key) {
        return Math.abs(key.hashCode() % this.categories);
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override
    public String toString() {
        return "Mapa{" +
                "map=" + map +
                '}';
    }
}
