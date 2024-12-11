package br.com.cafeweb.estruturadados.main;

import br.com.cafeweb.estruturadados.vetor.Vetor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("1. Vetores");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Selecione a opção: ");
        var option = scanner.nextLine();

        switch (option) {
            case "1":
                vetor();
                break;
        }
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
    }
}