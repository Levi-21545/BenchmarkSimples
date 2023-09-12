package mypackage;

class BuscaArvBinThread implements Runnable {

    mypackage.Busca busca;
    ArvoreBinaria arvore;
    double n;

    public BuscaArvBinThread(mypackage.Busca busca, ArvoreBinaria arvore, double n) {
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

    mypackage.Busca busca;
    ArvoreBinariaAlt arvore;
    double n;

    public BuscaArvBinAltThread(mypackage.Busca busca, ArvoreBinariaAlt arvore, double n) {
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

    mypackage.Busca busca;
    ArvoreAvl arvore;
    double n;

    public BuscaArvBalThread(mypackage.Busca busca, ArvoreAvl arvore, double n) {
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

    mypackage.Busca busca;
    ArvoreAvlAlt arvore;
    double n;

    public BuscaArvBalRuimThread(mypackage.Busca busca, ArvoreAvlAlt arvore, double n) {
        this.busca = busca;
        this.arvore = arvore;
        this.n = n;
    }

    @Override
    public void run() {
        busca.ArvBalRuim(arvore, n);
    }
}
