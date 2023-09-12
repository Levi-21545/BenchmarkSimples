package mypackage;

import arvores.ArvoreAvlAlt;
import arvores.ArvoreBinaria;
import arvores.ArvoreBinariaAlt;
import arvores.ArvoreAvl;

class BuscaArvBinThread implements Runnable {

    estuturas_simples.Busca busca;
    ArvoreBinaria arvore;
    double n;

    public BuscaArvBinThread(estuturas_simples.Busca busca, ArvoreBinaria arvore, double n) {
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

    estuturas_simples.Busca busca;
    ArvoreBinariaAlt arvore;
    double n;

    public BuscaArvBinAltThread(estuturas_simples.Busca busca, ArvoreBinariaAlt arvore, double n) {
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

    estuturas_simples.Busca busca;
    ArvoreAvl arvore;
    double n;

    public BuscaArvBalThread(estuturas_simples.Busca busca, ArvoreAvl arvore, double n) {
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

    estuturas_simples.Busca busca;
    ArvoreAvlAlt arvore;
    double n;

    public BuscaArvBalRuimThread(estuturas_simples.Busca busca, ArvoreAvlAlt arvore, double n) {
        this.busca = busca;
        this.arvore = arvore;
        this.n = n;
    }

    @Override
    public void run() {
        busca.ArvBalRuim(arvore, n);
    }
}
