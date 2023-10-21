package main.java.mypackage;

import main.java.arvores.ArvoreAvlAlt;
import main.java.arvores.ArvoreBinaria;
import main.java.arvores.ArvoreBinariaAlt;
import main.java.arvores.ArvoreAvl;

class BuscaArvBinThread implements Runnable {

    main.java.estuturas_simples.Busca busca;
    ArvoreBinaria arvore;
    double n;

    public BuscaArvBinThread(main.java.estuturas_simples.Busca busca, ArvoreBinaria arvore, double n) {
        this.busca = busca;
        this.arvore = arvore;
        this.n = n;
    }

    @Override
    public void run() {
        busca.ArvBin(arvore, n);
    }
}

class BuscaArvBinAltThread implements Runnable {

    main.java.estuturas_simples.Busca busca;
    ArvoreBinariaAlt arvore;
    double n;

    public BuscaArvBinAltThread(main.java.estuturas_simples.Busca busca, ArvoreBinariaAlt arvore, double n) {
        this.busca = busca;
        this.arvore = arvore;
        this.n = n;
    }

    @Override
    public void run() {
        busca.ArvBinAlt(arvore, n);
    }
}

class BuscaArvBalThread implements Runnable {

    main.java.estuturas_simples.Busca busca;
    ArvoreAvl arvore;
    double n;

    public BuscaArvBalThread(main.java.estuturas_simples.Busca busca, ArvoreAvl arvore, double n) {
        this.busca = busca;
        this.arvore = arvore;
        this.n = n;
    }

    @Override
    public void run() {
        busca.ArvBal(arvore, n);
    }
}

class BuscaArvBalRuimThread implements Runnable {

    main.java.estuturas_simples.Busca busca;
    ArvoreAvlAlt arvore;
    double n;

    public BuscaArvBalRuimThread(main.java.estuturas_simples.Busca busca, ArvoreAvlAlt arvore, double n) {
        this.busca = busca;
        this.arvore = arvore;
        this.n = n;
    }

    @Override
    public void run() {
        busca.ArvBalAlt(arvore, n);
    }
}
