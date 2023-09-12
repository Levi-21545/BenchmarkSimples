package mypackage;

import estuturas_simples.Sort;
import estuturas_simples.Vetor;

class geraVetorThread implements Runnable {

    private Vetor vetor;

    public geraVetorThread(Vetor vetor) {
        this.vetor = vetor;
    }

    @Override
    public void run() {
        vetor.geraVetor();

    }
}

class BubbleSortThread implements Runnable {

    private Sort bubble;

    public BubbleSortThread(Sort bubble) {
        this.bubble = bubble;
    }

    @Override
    public void run() {
        bubble.ordenaBubble();

    }
}

class SelectionSortThread implements Runnable {

    private Sort selection;

    public SelectionSortThread(Sort selection) {
        this.selection = selection;
    }

    @Override
    public void run() {
        selection.ordenaSelection();
    }
}

class InsertionSortThread implements Runnable {

    private Sort insertion;

    public InsertionSortThread(Sort insertion) {
        this.insertion = insertion;
    }

    @Override
    public void run() {
        insertion.ordenaInsertion();
    }
}

class QuickSortThread implements Runnable {

    private Sort quick;

    public QuickSortThread(Sort quick) {
        this.quick = quick;
    }

    @Override
    public void run() {
        quick.ordenaQuick();
    }
}





