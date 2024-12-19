package br.com.cafeweb.estruturadados.main;

import br.com.cafeweb.estruturadados.arvore.Arvore;
import br.com.cafeweb.estruturadados.arvore.NoArvore;
import br.com.cafeweb.estruturadados.conjuntos.Conjunto;
import br.com.cafeweb.estruturadados.espalhamento.TabelaEspalhamento;
import br.com.cafeweb.estruturadados.filas.Fila;
import br.com.cafeweb.estruturadados.listasligadas.ListaDuplamenteLigada;
import br.com.cafeweb.estruturadados.listasligadas.ListaLigada;
import br.com.cafeweb.estruturadados.mapas.Mapa;
import br.com.cafeweb.estruturadados.pilhas.Pilha;
import br.com.cafeweb.estruturadados.vetor.Vetor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("1. Vetores");
        System.out.println("2. Listas");
        System.out.println("3. Lista Dupla");
        System.out.println("4. Pilha");
        System.out.println("5. Fila");
        System.out.println("6. Conjuntos (sets)");
        System.out.println("7. Mapas");
        System.out.println("8. Árvore");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Selecione a opção: ");
        var option = scanner.nextLine();

        switch (option) {
            case "1":
                vetor();
                break;
            case "2":
                lista();
                break;
            case "3":
                listaDupla();
                break;
            case "4":
                pilha();
                break;
            case "5":
                fila();
                break;
            case "6":
                conjunto();
                break;
            case "7":
                mapa();
                break;
            case "8":
                arvore();
                break;
        }
        scanner.close();
    }

    public static void vetor() {
        Vetor<Integer> vetor = new Vetor<Integer>();

        for (int i = 0; i < vetor.size(); i++) {
            vetor.add(i + 1);
        }

        vetor.add(11);

        System.out.println("============ Exibindo dados do vetor =================");

        for (int i = 0; i < vetor.size(); i++) {
            System.out.println(vetor.getVetor(i));
        }

        System.out.println("============ Adicionando dados entre os elementos =================");
        vetor.addIndex(3, 12);

        for (int i = 0; i < vetor.size(); i++) {
            System.out.println(vetor.getVetor(i));
        }

        System.out.println("================== Verificando se um valor existe no vetor ========================");

        if (vetor.has(12)) {
            System.out.printf("Existe e está na posição %d ", vetor.searchIndex(12));
        } else {
            System.out.println("Não existe");
        }

        System.out.println("====================== Removendo itens de um array ================================");

        vetor.remove(12);
        vetor.removeIndex(3);

        for (int i = 0; i < vetor.size(); i++) {
            System.out.println(vetor.getVetor(i));
        }
    }

    public static void lista() {
        ListaLigada<Integer> numbers = new ListaLigada<Integer>();

        numbers.insertNo(10);
        numbers.insertNo(20);
        numbers.insertNo(30);
        numbers.insertNo(40);
        numbers.insertNo(50);

        numbers.insertIn(4, 60);

        System.out.println(numbers.contains(40));
        System.out.println(numbers.contains(400));
        System.out.println(numbers.indexOf(40));
        System.out.println(numbers.indexOf(400));

        System.out.println(numbers.indexOf(40));

        System.out.println(numbers);
    }

    public static void listaDupla() {

        ListaDuplamenteLigada<Integer> numbers = new ListaDuplamenteLigada<>();

        numbers.insertNo(10);
        numbers.insertNo(20);
        numbers.insertNo(30);
        numbers.insertNo(40);
        numbers.insertNo(50);

        numbers.insertIn(4, 60);
        numbers.insertIn(2, 25);
        numbers.insertIn(0, 5);
        //numbers.removeIndex(2);

        System.out.println(numbers.contains(40));
        System.out.println(numbers.contains(400));
        System.out.println(numbers.indexOf(40));
        System.out.println(numbers.indexOf(400));
        System.out.println(numbers);
    }

    public static void pilha() {
        Pilha<Integer> stack = new Pilha<Integer>();
        System.out.println(stack.isEmpty());
        stack.stackUp(10);
        stack.stackUp(20);
        stack.stackUp(30);
        System.out.println(stack.unstack());
        System.out.println(stack);

    }

    public static void fila() {
        Fila<Integer> queue = new Fila<Integer>();
        System.out.println(queue.isEmpty());
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue);
    }

    public static void conjunto() {
        Conjunto<Integer> set = new Conjunto<Integer>();
        System.out.println(set.isEmpty());
        System.out.println(set.insert(10));
        System.out.println(set.insert(10));
        System.out.println(set.insert(20));
        System.out.println(set.insert(30));
        System.out.println(set.insert(250));
        System.out.println(set.insert(480));
        System.out.println(set);
    }

    public static void mapa() {
        Mapa<String, Integer> mapa = new Mapa<String, Integer>();
        System.out.println(mapa.isEmpty());
        System.out.println(mapa.insert("dez", 10));
        System.out.println(mapa.insert("vinte", 20));
        System.out.println(mapa.insert("trinta", 30));
        System.out.println(mapa.insert("quarenta", 40));
        System.out.println(mapa.getValue("vinte"));
        System.out.println(mapa.insert("dez", 100));
        mapa.remove("dez");
        System.out.println(mapa);
    }

    public static void arvore() {
        Arvore<Integer> numbers = new Arvore<Integer>();
        numbers.insert(new NoArvore<Integer>(10));
        numbers.insert(new NoArvore<Integer>(20));
        numbers.insert(new NoArvore<Integer>(30));
        numbers.insert(new NoArvore<Integer>(31));
        numbers.insert(new NoArvore<Integer>(25));
        numbers.insert(new NoArvore<>(5));
        System.out.println("=============== Busca =================");
        System.out.println(numbers.search(new NoArvore<>(31)));
        System.out.println(numbers);
    }
}