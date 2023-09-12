package mypackage;

import arvores.ArvoreAvlAlt;
import arvores.ArvoreBinaria;
import arvores.ArvoreBinariaAlt;
import arvores.ArvoreAvl;
import estuturas_simples.Sort;
import estuturas_simples.Busca;
import estuturas_simples.Vetor;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        new Janela().setVisible(true);

        Scanner leitor = new Scanner(System.in);

        System.out.println("Escolha um tamanho para o vetor: ");
        int tamanho = leitor.nextInt();

        //CRIA E ORDENA VETORES
        Vetor vetor = new Vetor(tamanho);
        Thread geraVetor = new Thread(new geraVetorThread(vetor));
        geraVetor.setName("ThreadGeraVetor");

        geraVetor.start();

        try {
            geraVetor.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Sort bubble = new Sort(vetor);
        Sort selection = new Sort(vetor);
        Sort insertion = new Sort(vetor);
        Sort quick = new Sort(vetor);

        //CRIA ARVORES
        ArvoreBinaria arvoreBin = new ArvoreBinaria();
        ArvoreBinariaAlt arvoreBinAlt = new ArvoreBinariaAlt();
        ArvoreAvl arvoreBal = new ArvoreAvl();
        ArvoreAvlAlt arvoreBalRuim = new ArvoreAvlAlt();

        Thread criaArvBin = new Thread(new criaArvBinThread(arvoreBin, vetor));
        criaArvBin.setName("ThreadCriaArvBin");

        Thread criaArvBinAlt = new Thread(new criaArvBinAltThread(arvoreBinAlt, vetor));
        criaArvBinAlt.setName("ThreadCriaArvBinAlt");

        Thread criaArvBal = new Thread(new criaArvBalThread(arvoreBal, vetor));
        criaArvBal.setName("ThreadCriaArvBal");

        Thread criaArvBalRuim = new Thread(new criaArvBalRuimThread(arvoreBalRuim, vetor));
        criaArvBalRuim.setName("ThreadCriaArvBalRuim");

        Thread bubbleThread = new Thread(new BubbleSortThread(bubble));
        bubbleThread.setName("ThreadBubble");

        Thread selectionThread = new Thread(new SelectionSortThread(selection));
        selectionThread.setName("ThreadSelection");

        Thread insertionThread = new Thread(new InsertionSortThread(insertion));
        insertionThread.setName("ThreadInsertion");

        Thread quickThread = new Thread(new QuickSortThread(quick));
        quickThread.setName("ThreadQuick");


        /*criaArvBin.start();
        criaArvBinAlt.start();
        criaArvBal.start();
        criaArvBalRuim.start();

        bubbleThread.start();
        selectionThread.start();
        insertionThread.start();
        quickThread.start();*/
        System.out.println("Deseja ordenar? ");
        int r = leitor.nextInt();

        vetor.imprimeAleatorio();
        //quick.imprimeVetor();

        try {
            criaArvBal.join();
            criaArvBin.join();
            criaArvBinAlt.join();
            criaArvBalRuim.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Digite o numero que deseja encontrar: ");
        double n = leitor.nextDouble();

        Busca busca = new Busca();

        Thread buscaArvBin = new Thread(new BuscaArvBinThread(busca, arvoreBin, n));
        buscaArvBin.setName("ThreadBuscaArvBin");

        Thread buscaArvBinAlt = new Thread(new BuscaArvBinAltThread(busca, arvoreBinAlt, n));
        buscaArvBinAlt.setName("ThreadBuscaArvBinAlt");

        Thread buscaArvBal = new Thread(new BuscaArvBalThread(busca, arvoreBal, n));
        buscaArvBal.setName("ThreadBuscaArvBal");

        Thread buscaArvBalRuim = new Thread(new BuscaArvBalRuimThread(busca, arvoreBalRuim, n));
        buscaArvBalRuim.setName("ThreadBuscaArvBalRuim");

        //FAZER BUSCA ALVORE BALANCEADA RUIM
        buscaArvBal.start();
        buscaArvBin.start();
        buscaArvBinAlt.start();
        buscaArvBalRuim.start();
        try {
            buscaArvBal.join();
            buscaArvBin.join();
            buscaArvBinAlt.join();
            buscaArvBalRuim.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (r == 1) {
            try {
                bubbleThread.join();
                selectionThread.join();
                insertionThread.join();
                quickThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("\nMetodo de ordenacao | Tempo de Execucao | Uso de Memoria ");
            System.out.printf("%-19s | %14.4f ms | %-17s\n", "Bubble Sort", bubble.getTempoExecucao(), "XXKb");
            System.out.printf("%-19s | %14.4f ms | %-17s\n", "Selection Sort", selection.getTempoExecucao(), "XXKb");
            System.out.printf("%-19s | %14.4f ms | %-17s\n", "Insertion Sort", insertion.getTempoExecucao(), "XXKb");
            System.out.printf("%-19s | %14.4f ms | %-17s\n", "Quick Sort", quick.getTempoExecucao(), "XXKb");

        } else {
            bubbleThread.interrupt();
            selectionThread.interrupt();
            insertionThread.interrupt();
            quickThread.interrupt();
        }

        System.out.println("\nCriacao da Arvore   | Tempo de Execucao | Uso de Memoria ");
        System.out.printf("%-19s | %14.4f ms | %-17s\n", "Arvore Bin.", arvoreBin.getTempoCria(), "XXKb");
        System.out.printf("%-19s | %14.4f ms | %-17s\n", "Arvore Bin. Alt", arvoreBinAlt.getTempoCria(), "XXKb");
        System.out.printf("%-19s | %14.4f ms | %-17s\n", "Arvore Balanc.", arvoreBal.getTempoCria(), "XXKb");
        System.out.printf("%-19s | %14.4f ms | %-17s\n", "Arvore Balanc. Ruim", arvoreBalRuim.getTempoCria(), "XXKb");

        System.out.println("\nMetodo de busca     | Tempo de Execucao | Uso de Memoria ");
        System.out.printf("%-19s | %14.4f ms | %-17s\n", "Arvore Bin.", busca.getTempoExecBin(), "XXKb");
        System.out.printf("%-19s | %14.4f ms | %-17s\n", "Arvore Bin. Alt", busca.getTempoExecBinAlt(), "XXKb");
        System.out.printf("%-19s | %14.4f ms | %-17s\n", "Arvore Balanc.", busca.getTempoExecBal(), "XXKb");
        System.out.printf("%-19s | %14.4f ms | %-17s\n", "Arvore Balanc. Ruim", busca.getTempoExecBalRuim(), "XXKb");
        //System.out.printf("%-19s | %14.4f ms | %-10s | %-17s\n","Arvore P e V", busca.ArvorePretoVermelho(n), "tempo", "XXKb");

    }

}
