package br.com.cafeweb.estruturadados.main;

import br.com.cafeweb.estruturadados.listasligadas.ListaDuplamenteLigada;
import br.com.cafeweb.estruturadados.listasligadas.ListaLigada;
import br.com.cafeweb.estruturadados.pilhas.Pilha;
import br.com.cafeweb.estruturadados.vetor.Vetor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("1. Vetores");
        System.out.println("2. Listas");
        System.out.println("3. Lista Dupla");
        System.out.println("4. Pilha");
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
}